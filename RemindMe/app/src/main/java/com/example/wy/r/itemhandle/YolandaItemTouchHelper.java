package com.example.wy.r.itemhandle;

import android.support.v7.widget.helper.ItemTouchHelper;



public class YolandaItemTouchHelper extends ItemTouchHelper {
    public ItemTouchHelper.Callback mCallback = null;
    public YolandaItemTouchHelper(ItemTouchHelper.Callback callback) {
        super(callback);
        mCallback = callback;
    }
    public Callback getCallback(){
        return mCallback;

    }

}
