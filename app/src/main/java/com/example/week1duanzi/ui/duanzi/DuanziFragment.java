package com.example.week1duanzi.ui.duanzi;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.app.MyApp;
import com.example.week1duanzi.R;
import com.example.week1duanzi.adapter.DuanziAdapter;
import com.example.week1duanzi.bean.DuanziBean;
import com.example.week1duanzi.bean.MyDataBean;
import com.example.week1duanzi.bean.MyDataBeanDao;
import com.example.week1duanzi.component.DaggerHttpComponent;
import com.example.week1duanzi.ui.base.BaseFragment;
import com.example.week1duanzi.ui.duanzi.contract.DuanziContract;
import com.example.week1duanzi.ui.duanzi.presenter.DuanziPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DuanziFragment extends BaseFragment<DuanziPresenter> implements DuanziContract.View {
    private XRecyclerView xlv;
    private List<DuanziBean.DataBean> list = new ArrayList<>();
    private DuanziAdapter adapter;
    private boolean isRefresh = true;
    private int page = 1;

    @Override
    public int getContentLayout() {
        return R.layout.fragment_duanzi;
    }

    @Override
    public void initView(View view) {
        xlv = view.findViewById(R.id.xrl);
        xlv.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new DuanziAdapter(getContext(), list);
        xlv.setAdapter(adapter);
        //判断数据库中是否有数据
        MyDataBeanDao myDataBeanDao = MyApp.getDaoSession().getMyDataBeanDao();
        List<MyDataBean> list = myDataBeanDao.queryBuilder().build().list();
        if (list != null && list.size() > 0) {
            //说明数据库有数据
        } else {
            mPresenter.getDuanzi(page + "");
        }

        //设置刷新和加载更多监听
        xlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                //刷新
                page = 1;
                isRefresh = true;
                mPresenter.getDuanzi(page + "");
            }

            @Override
            public void onLoadMore() {
                //加载更多
                page++;
                isRefresh = false;
                mPresenter.getDuanzi(page + "");

            }
        });

    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void onSuccess(List<DuanziBean.DataBean> list) {
        if (isRefresh) {
            adapter.refresh(list);
            xlv.refreshComplete();
        } else {
            adapter.loadMore(list);
            int listNum = adapter.getListNum();
            xlv.loadMoreComplete();
            int size = list.size();
            int count = listNum + size;
            if (count >= 20) {
                xlv.setLoadingMoreEnabled(false);
            }
        }

    }
}
