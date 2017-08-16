package com.minminaya.coordinatebehavior.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.minminaya.coordinatebehavior.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Niwa on 2017/8/16.
 */

public class RecyclerViewAdapter1 extends RecyclerView.Adapter<RecyclerViewAdapter1.ViewHolder1> {
    @Override
    public ViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder1 holder, int position) {
        holder.text1.setText("text");
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        @BindView(R.id.text1)
        TextView text1;
        public ViewHolder1(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
