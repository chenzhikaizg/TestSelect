package com.example.a.testdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;




/**
 * Created by chenzhikai on 2017/11/4.
 */

public class LjYyueAdapter extends RecyclerView.Adapter<LjYyueAdapter.SyTjViewHolder> {
    private List<YydjOrderItemBean.ArtImage> values;
    private Context mContext;
    private int pos = -1; //用来表示被选中的位置
    public LjYyueAdapter(Context mContext){
        this.mContext = mContext;
        values = new ArrayList<YydjOrderItemBean.ArtImage>();

    }
    public void addData(List<YydjOrderItemBean.ArtImage> values) {
        this.values.addAll(values);
    }
    public void clear() {
        values.clear();
    }

    private OnItemClickListener clickListener;

    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public  static interface OnItemClickListener {
        void onClick(View view, int position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }
    //返回选中的状态
    public int getSelectItem() {
        return pos;
    }

    @Override
    public SyTjViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_yydj_yyue, parent, false);
        SyTjViewHolder holder = new SyTjViewHolder(view);
        return holder;
    }



    @Override
    public void onBindViewHolder(final SyTjViewHolder holder, int position) {


        holder.rlRoot.setBackgroundResource(R.drawable.bg_shape_grey_login_border_no_solid);
        if (values.get(position).status==1){
            holder.rlRoot.setBackgroundResource(R.drawable.bg_shape_pink_xiaoxi_border_no_solid);
            pos= position;

        }

    holder.tv.setText(values.get(position).month);
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
    class SyTjViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        private final TextView tv;
        private final RelativeLayout rlRoot;

        public SyTjViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            tv = (TextView) itemView.findViewById(R.id.tv_month);
            rlRoot = (RelativeLayout)itemView.findViewById(R.id.rl_root);

        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.onClick(itemView, getAdapterPosition());
            }


        }
    }


}
