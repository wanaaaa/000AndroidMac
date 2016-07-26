package com.ga.android.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by wanmac on 7/26/16.
 */
public class AdapterItemAll extends RecyclerView.Adapter<VHolderItemDetail>{
    List<DaIndiItem> mIndiItems;

    public AdapterItemAll(List<DaIndiItem> itemAll) {
        mIndiItems = itemAll;
    }

    @Override
    public VHolderItemDetail onCreateViewHolder(ViewGroup parent, int viewType) {
        View parentView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.woman_item_all, parent, false);
        VHolderItemDetail viewHolder = new VHolderItemDetail(parentView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VHolderItemDetail holder, int position) {
        holder.mItemTitle.setText(mIndiItems.get(position).getIteTitle());
        holder.mItemPrice.setText(mIndiItems.get(position).getItePrice());
    }

    @Override
    public int getItemCount() {
        return mIndiItems.size();
    }

//    public void removeAt(int position) {
//        notifyDataSetChanged(position);
//        notifyDataSetChanged(position, mIndiItems.size());
//    }
}
