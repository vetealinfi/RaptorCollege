package com.codebake.raptor.raptorcollege.ui;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.IntegerRes;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by CTN Developer on 29-07-2016.
 */
public class ItemOffsetDecoration extends RecyclerView.ItemDecoration {


    private int mItemOffset;

    public ItemOffsetDecoration(Context context, @IntegerRes int integerResId){
        int itemOffsetDp = context.getResources().getInteger(integerResId);
        mItemOffset = convertToPixels(itemOffsetDp, context.getResources().getDisplayMetrics());


    }

    public int convertToPixels(int offsetDp, DisplayMetrics metrics){
        return offsetDp * (metrics.densityDpi/160);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(0,mItemOffset,mItemOffset,mItemOffset);
    }
}
