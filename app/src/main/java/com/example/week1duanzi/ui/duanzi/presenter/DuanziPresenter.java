package com.example.week1duanzi.ui.duanzi.presenter;

import android.annotation.SuppressLint;

import com.example.app.MyApp;
import com.example.week1duanzi.bean.DaoSession;
import com.example.week1duanzi.bean.DuanziBean;
import com.example.week1duanzi.bean.MyDataBean;
import com.example.week1duanzi.bean.MyDataBeanDao;
import com.example.week1duanzi.net.DuanziApi;
import com.example.week1duanzi.ui.base.BasePresenter;
import com.example.week1duanzi.ui.duanzi.contract.DuanziContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class DuanziPresenter extends BasePresenter<DuanziContract.View> implements DuanziContract.Presenter {
    private DuanziApi duanziApi;

    @Inject
    public DuanziPresenter(DuanziApi duanziApi) {
        this.duanziApi = duanziApi;
    }

    @SuppressLint("CheckResult")
    @Override
    public void getDuanzi(String page) {
        duanziApi.getDuanzi(page)
                .subscribeOn(Schedulers.io())
                .map(new Function<DuanziBean, List<DuanziBean.DataBean>>() {
                    @Override
                    public List<DuanziBean.DataBean> apply(DuanziBean duanziBean) throws Exception {
                        return duanziBean.getData();
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<DuanziBean.DataBean>>() {
                    @Override
                    public void accept(List<DuanziBean.DataBean> dataBeans) throws Exception {
                        DaoSession daoSession = MyApp.getDaoSession();
                        List<MyDataBean> list = new ArrayList<>();
                        MyDataBeanDao myDataBeanDao = daoSession.getMyDataBeanDao();
                        for (int i = 0; i < dataBeans.size(); i++) {
                            DuanziBean.DataBean dataBean = dataBeans.get(i);
                            MyDataBean myDataBean = new MyDataBean();
                            myDataBean.setAge(dataBean.getUser().getAge() + "");
                            myDataBean.setCommentNum(dataBean.getCommentNum() + "");
                            myDataBean.setContent(dataBean.getContent());
                            myDataBean.setCreateTime(dataBean.getCreateTime());
                            myDataBean.setFans(dataBean.getUser().getFans());
                            myDataBean.setFollow(dataBean.getUser().isFollow());
                            myDataBean.setIcon(dataBean.getUser().getIcon() + "");
                            myDataBean.setImgUrls((String)(dataBean.getImgUrls()));
                            list.add(myDataBean);
                        }
                        myDataBeanDao.insertInTx(list);
                        mView.onSuccess(dataBeans);
                    }
                });

    }
}
