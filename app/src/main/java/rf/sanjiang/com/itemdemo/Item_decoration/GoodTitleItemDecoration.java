package rf.sanjiang.com.itemdemo.Item_decoration;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;

import rf.sanjiang.com.itemdemo.adapter.GoodAdapter;

public class GoodTitleItemDecoration extends RecyclerView.ItemDecoration {
    private static final String TAG = "GoodTitleItemDecoration";

    private GoodAdapter adapter;

    private int smallTitle = 30;//小标题是每一个item都不一样的
    private int bigTitle = 50;
    private Paint paint;
    private Paint paint2;

    private TextPaint textPaint;

    public GoodTitleItemDecoration(GoodAdapter adapter) {
        this.adapter = adapter;
        paint = new Paint();
        paint.setColor(Color.parseColor("#FFD39B"));
        paint2 = new Paint();
        paint2.setColor(Color.parseColor("#B4EEB4"));
        textPaint = new TextPaint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(30);
    }


    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int pos = parent.getChildAdapterPosition(view);//当前的实际位置

        if (adapter.getDatas().get(pos).data.datalist.get(0).isBigtitle) {
            outRect.top = smallTitle + bigTitle;
        } else {
            outRect.top = smallTitle;
        }
    }


    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();


        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            int top = view.getTop() - smallTitle;
            int bottom = top + smallTitle;

            int pos = parent.getChildAdapterPosition(view);//当前的实际位置


            String stitle = adapter.getDatas().get(pos).data.datalist.get(0).samllTiele;

            c.drawRect(left, top, right, bottom, paint);//绘制小标题
            c.drawText(stitle, left, bottom, textPaint);


            String title=adapter.getDatas().get(pos).data.datalist.get(0).title;

            if (adapter.getDatas().get(pos).data.datalist.get(0).isBigtitle) {
                int top2 = view.getTop() - smallTitle - bigTitle;
                int bottom2 = top2 + bigTitle;
                c.drawRect(left, top2, right, bottom2, paint2);//绘制大标题
                c.drawText(title,left,bottom2,textPaint);
            }
        }
    }


    /**
     * 做吸附的操作
     *
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();//当前可见的item数量
        View child0 = parent.getChildAt(0);//当前可见的第一个item
        int position = parent.getChildAdapterPosition(child0);//实际的position位置

        String stitle=adapter.getDatas().get(position).data.smallTitle;

        if (adapter.getDatas().get(position).data.datalist.get(0).isBigtitle) { //有大标题在的情况下

            //余下部分小于小标题栏的时候
            if (child0.getBottom() <= smallTitle) {
                c.drawRect(left, 0, right, child0.getBottom(), paint);
                c.drawText(stitle,left,child0.getBottom(),textPaint);
            }

            //余下部分大于小标题栏
            if (child0.getBottom() > smallTitle && child0.getBottom() < child0.getHeight() + smallTitle) {
                c.drawRect(left, 0, right, smallTitle, paint);
                c.drawText(stitle,left,smallTitle,textPaint);
            }



        } else { //没有大标题在的情况下

            if (child0.getBottom() <= smallTitle) {
                c.drawRect(left, 0, right, child0.getBottom(), paint);
                c.drawText(stitle,left,child0.getBottom(),textPaint);
            } else {
                c.drawRect(0, 0, right, smallTitle, paint);//固定不动
                c.drawText(stitle,left,smallTitle,textPaint);
            }
        }

    }


}
