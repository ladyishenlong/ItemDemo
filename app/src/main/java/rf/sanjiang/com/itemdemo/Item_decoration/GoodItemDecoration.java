package rf.sanjiang.com.itemdemo.Item_decoration;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class GoodItemDecoration extends RecyclerView.ItemDecoration {


    public Paint paint;
    private int height=3;

    public GoodItemDecoration() {
        paint=new Paint();
        paint.setColor(Color.GRAY);
    }


    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        outRect.bottom=height;
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);

        int childCount=parent.getChildCount();//页面上显示的第一个
        int left=parent.getPaddingLeft();
        int right=parent.getWidth()-parent.getPaddingRight();

        for (int i = 0; i < childCount-1; i++) {
            View view=parent.getChildAt(i);
            int top=view.getBottom();
            int bottom=top+height;
            c.drawRect(left, top, right, bottom, paint);
        }

    }
}
