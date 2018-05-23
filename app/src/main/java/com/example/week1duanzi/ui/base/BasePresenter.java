package com.example.week1duanzi.ui.base;

public class BasePresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {
    protected T mView;

    @Override
    public void attchView(T view) {
        if(view !=null){
            this.mView = view;
        }
    }

    @Override
    public void detachView() {
        if(mView !=null){
            this.mView = null;
        }
    }
}
