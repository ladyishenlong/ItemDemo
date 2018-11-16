package rf.sanjiang.com.itemdemo.Item_decoration;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

public class LineItemDecoration extends RecyclerView.ItemDecoration {

    private static final String TAG = "LineItemDecoration";


    public Paint paint;

    public LineItemDecoration() {
        paint=new Paint();
        paint.setColor(Color.GRAY);
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom=5;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int childCount=parent.getChildCount();
        int left=parent.getPaddingLeft();
        int right=parent.getWidth()-parent.getPaddingRight();

        Log.e(TAG, "onDraw: gggg");

        for (int i = 0; i < childCount-1; i++) {//最后一行不画

            Log.e(TAG, "onDraw: "+i);


            View view =parent.getChildAt(i);
            float top=view.getBottom();
            float bottom=view.getBottom()+5;
            c.drawRect(left, top, right, bottom, paint);
        }

    }



}
