package com.pavel.recycledecorate;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public final class MiddleDividerItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable mDivider;
    private int mOrientation;
    private final Rect mBounds;
    private static final int HORIZONTAL = 0;
    private static final int VERTICAL = 1;
    private static final int ALL = 2;
    private static final String TAG = "DividerItem";
    private static final int[] ATTRS = new int[]{16843284};

    public final void setDividerColor(int color) {
        Drawable var10000 = this.mDivider;
        if (var10000 == null) {
        }
        var10000.setColorFilter((ColorFilter)(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP)));
    }

    public final void setOrientation(int orientation) {
        if (orientation != HORIZONTAL && orientation != VERTICAL && orientation != ALL) {
            try {
                throw (Throwable)(new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL"));
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        } else {
            this.mOrientation = orientation;
        }
    }

    public final void setDrawable(Drawable drawable) {
        this.mDivider = drawable;
    }

    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {

        if (parent.getLayoutManager() != null && this.mDivider != null) {
            int var4 = this.mOrientation;
            if (var4 == ALL) {
                this.drawVertical(c, parent);
                this.drawHorizontal(c, parent);

            } else if (var4 == VERTICAL) {
                this.drawVertical(c, parent);
            } else {
                this.drawHorizontal(c, parent);
            }

        }
    }

    private final void drawVertical(Canvas canvas, RecyclerView parent) {
        canvas.save();
        int leftInt;
        int rightInt;
        if (parent.getClipToPadding()) {
            leftInt = parent.getPaddingLeft();
            rightInt = parent.getWidth() - parent.getPaddingRight();
            canvas.clipRect(leftInt, parent.getPaddingTop(), rightInt, parent.getHeight() - parent.getPaddingBottom());
        } else {
            leftInt = 0;
            rightInt = parent.getWidth();
        }

        int childCount = parent.getChildCount();
        int leftItems;
        if (parent.getLayoutManager() instanceof GridLayoutManager) {
            RecyclerView.LayoutManager var10001 = parent.getLayoutManager();
            if (var10001 == null) {
                try {
                    throw new Exception("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            leftItems = childCount % ((GridLayoutManager)var10001).getSpanCount();
            if (leftItems == 0) {
                RecyclerView.LayoutManager var10000 = parent.getLayoutManager();
                if (var10000 == null) {
                    try {
                        throw new Exception("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                leftItems = ((GridLayoutManager)var10000).getSpanCount();
            }

            childCount -= leftItems;
        }

        leftItems = 0;

        for(int var7 = childCount - 1; leftItems < var7; ++leftItems) {
            View var13 = parent.getChildAt(leftItems);
            if (var13 == null) {
                return;
            }

            View child = var13;
            parent.getDecoratedBoundsWithMargins(child, this.mBounds);
            int bottom = this.mBounds.bottom + Math.round(child.getTranslationY());
            Drawable var15 = this.mDivider;
            if (var15 == null) {

            }

            int top = bottom - var15.getIntrinsicHeight();
            Drawable var14 = this.mDivider;
            if (var14 == null) {

            }

            var14.setBounds(leftInt, top, rightInt, bottom);
            var14 = this.mDivider;
            if (var14 == null) {

            }

            var14.draw(canvas);
        }

        canvas.restore();
    }

    private final void drawHorizontal(Canvas canvas, RecyclerView parent) {
        canvas.save();
        int topInt;
        int bottomInt;
        if (parent.getClipToPadding()) {
            topInt = parent.getPaddingTop();
            bottomInt = parent.getHeight() - parent.getPaddingBottom();
            canvas.clipRect(parent.getPaddingLeft(), topInt, parent.getWidth() - parent.getPaddingRight(), bottomInt);
        } else {
            topInt = 0;
            bottomInt = parent.getHeight();
        }

        int childCount = parent.getChildCount();
        RecyclerView.LayoutManager var10000;
        if (parent.getLayoutManager() instanceof GridLayoutManager) {
            var10000 = parent.getLayoutManager();
            if (var10000 == null) {
                try {
                    throw new Exception("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            childCount = ((GridLayoutManager)var10000).getSpanCount();
        }

        int i = 0;

        for(int var7 = childCount - 1; i < var7; ++i) {
            View var13 = parent.getChildAt(i);
            if (var13 == null) {
                return;
            }

            View child = var13;
            var10000 = parent.getLayoutManager();
            if (var10000 == null) {

            }

            var10000.getDecoratedBoundsWithMargins(child, this.mBounds);
            int right = this.mBounds.right + Math.round(child.getTranslationX());
            Drawable var10001 = this.mDivider;
            if (var10001 == null) {

            }

            int left = right - var10001.getIntrinsicWidth();
            Drawable var14 = this.mDivider;
            if (var14 == null) {

            }

            var14.setBounds(left, topInt, right, bottomInt);
            var14 = this.mDivider;
            if (var14 == null) {

            }

            var14.draw(canvas);
        }

        canvas.restore();
    }

    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (this.mDivider == null) {
            outRect.set(0, 0, 0, 0);
        } else {
            if (this.mOrientation == VERTICAL) {
                Drawable var10004 = this.mDivider;
                if (var10004 == null) {

                }

                outRect.set(0, 0, 0, var10004.getIntrinsicHeight());
            } else {
                Drawable var10003 = this.mDivider;
                if (var10003 == null) {

                }

                outRect.set(0, 0, var10003.getIntrinsicWidth(), 0);
            }

        }
    }

    public MiddleDividerItemDecoration(Context context, int orientation) {
        super();

        this.mBounds = new Rect();
        TypedArray a = context.obtainStyledAttributes(ATTRS);
        this.mDivider = a.getDrawable(0);
        a.recycle();
        this.setOrientation(orientation);
    }

    public static class Companion {

        public  int getHORIZONTAL() {
            return MiddleDividerItemDecoration.HORIZONTAL;
        }

        public  int getVERTICAL() {
            return MiddleDividerItemDecoration.VERTICAL;
        }

        public  int getALL() {
            return MiddleDividerItemDecoration.ALL;
        }

        private Companion() {
        }
    }
}
