package com.ga.android.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by wanmac on 7/26/16.
 */
public class AdapterItemAll extends RecyclerView.Adapter<VHolderItemDetail>{
    private static final String TAG = "AdapterItemAll";
    List<DaIndiItem> mIndiItems;
    Bundle bundle = new Bundle();

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
    public void onBindViewHolder(final VHolderItemDetail holder,final int position) {

        holder.mItemTitle.setText(mIndiItems.get(position).getIteTitle());
        Log.d(TAG,mIndiItems.get(position).getIteTitle().toString() );
        String priceStr = Integer.toString(mIndiItems.
                get(position).getItePrice());
        holder.mItemPrice.setText(priceStr);

        View.OnClickListener clickToCart = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                DaCartList cartArray = DaCartList.getInstance();
                cartArray.addItem(mIndiItems.get(position));
                String cartSize = String.valueOf(cartArray.cartSize());
                Log.d(TAG, cartSize + "//////");
                Toast.makeText(view.getContext(), "The item saved",
                        Toast.LENGTH_SHORT ).show();

            }
        };

        View.OnClickListener clickDetail = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d(TAG,"itemView clicked");
                Intent intent = new Intent(view.getContext(), MmDetailActivity.class);
                intent.putExtra("title",mIndiItems.get(position).getIteTitle() );
                intent.putExtra("price", Integer.toString(mIndiItems.
                        get(position).getItePrice()));
                view.getContext().startActivity(intent);

                Toast.makeText(view.getContext(), "I am itemView",
                        Toast.LENGTH_SHORT ).show();

            }
        };

//        View.OnClickListener delItemCart = new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
////                DaCartList cartArray = DaCartList.getInstance();
////                cartArray.removeAnItem(position);
//                Toast.makeText(view.getContext(), "Do not remove me",
//                        Toast.LENGTH_SHORT ).show();
//            }
//        };

        holder.mBuGoCart.setOnClickListener(clickToCart);

        //holder.mDelItemCart.setOnClickListener(delItemCart);

        holder.itemView.setOnClickListener(clickDetail);
    }

    @Override
    public int getItemCount() {
        return mIndiItems.size();
    }

    public void notifyWan(int position) {
        notifyItemChanged(position);
        notifyItemRangeChanged(position, mIndiItems.size());
    }
}
