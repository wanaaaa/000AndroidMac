package com.ga.android.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by wanmac on 7/26/16.
 */
public class VHolderItemDetail extends RecyclerView.ViewHolder {
    public TextView mItemTitle, mItemPrice;
    public Button mBuDelete, mBuGoCart, mDelItemCart;
    public VHolderItemDetail(View itemView) {
        super(itemView);

        mItemTitle = (TextView) itemView.findViewById(R.id.itemTitle);
        mItemPrice = (TextView) itemView.findViewById(R.id.itemPrice);
        mBuDelete = (Button) itemView.findViewById(R.id.buDeleteIndi);
        mBuGoCart = (Button) itemView.findViewById(R.id.buShoppinCart);
        mDelItemCart = (Button) itemView.findViewById(R.id.cartItemDelet);
    }
}
