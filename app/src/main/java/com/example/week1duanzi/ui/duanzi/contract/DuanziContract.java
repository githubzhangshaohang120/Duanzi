package com.example.week1duanzi.ui.duanzi.contract;

import com.example.week1duanzi.bean.DuanziBean;
import com.example.week1duanzi.ui.base.BaseContract;

import java.util.List;

public interface DuanziContract {
    interface View extends BaseContract.BaseView {
        void onSuccess(List<DuanziBean.DataBean> list);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getDuanzi(String page);
    }
}
