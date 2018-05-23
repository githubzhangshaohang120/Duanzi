package com.example.week1duanzi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.week1duanzi.R;
import com.example.week1duanzi.bean.DuanziBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class DuanziAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<DuanziBean.DataBean> list;
    private LayoutInflater inflater;

    public DuanziAdapter(Context context, List<DuanziBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.xrv_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DuanziBean.DataBean dataBean = list.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        String imgUrls = (String) dataBean.getImgUrls();
        String imgUrl = "";
        if (!TextUtils.isEmpty(imgUrls)) {
            imgUrl = imgUrls.split("\\|")[0];
        }
        myViewHolder.iv.setImageURI(imgUrl);
        myViewHolder.tvName.setText(dataBean.getUser().getNickname() + "");
        myViewHolder.tvTime.setText(dataBean.getCreateTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView iv;
        private final TextView tvName;
        private final TextView tvTime;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.img);
            tvName = itemView.findViewById(R.id.tv_name);
            tvTime = itemView.findViewById(R.id.tv_time);
        }
    }

    public void refresh(List<DuanziBean.DataBean> tempList) {
        //清楚原先集合里的内容
        this.list.clear();
        this.list.addAll(tempList);
        notifyDataSetChanged();
    }

    public void loadMore(List<DuanziBean.DataBean> tempList) {
        this.list.addAll(tempList);
        notifyDataSetChanged();
    }

    public int getListNum(){
        return this.list.size();
    }
}
