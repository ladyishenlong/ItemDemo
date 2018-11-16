package rf.sanjiang.com.itemdemo.Item_decoration;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;

public class TitleItemDecoration extends RecyclerView.ItemDecoration {

    private static final String TAG = "TitleItemDecoration";

    private Paint paint = new Paint();
    private TextPaint textPaint = new TextPaint();

    private Paint paint2;

    private int height = 50;//小标题高度
    private int bigHeight = 50;//大标题的高度


    public TitleItemDecoration() {
        paint.setColor(Color.YELLOW);

        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(40);
        textPaint.setColor(Color.BLACK);
        textPaint.setTextAlign(Paint.Align.LEFT);


        paint2 = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
//        paint2.setColor(Color.parseColor("#52ff0000"));
        paint2.setColor(Color.GREEN);


    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int pos = parent.getChildAdapterPosition(view);//当前的实际位置


        if (pos % 5 == 0) {
            outRect.top = height + bigHeight;

        } else {
            outRect.top = height;
        }


//        if (pos % 5 == 0) {
//            outRect.top = 50;
//        } else {
//            outRect.top = 0;
//        }

    }


    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);


        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();//当前可见的item数量
        int itemCount = state.getItemCount();


        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            int top = view.getTop() - height;
            int bottom = top + height;

            int position = parent.getChildAdapterPosition(view);//实际的position位置


            //绘制标题的矩形
            c.drawRect(left, top, right, bottom, paint2);

            c.drawText("这是标题栏" + position, left, bottom, textPaint);//绘制文本

            if (position % 5 == 0) {//判断哪项有大标题
                c.drawText("大标题栏", left, bottom - height, textPaint);
            }

        }


    }


    /**
     * 随着列表移动会重新加载
     *
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();//当前可见的item数量

        View child0 = parent.getChildAt(0);
        int position = parent.getChildAdapterPosition(child0);//实际的position位置



        //如果第一个item的Bottom<=分割线的高度
        //除去title部分的第一个item的底部完全没入到title之中
        //也就是下一个item的title和固定的title相互接触了

        if (position % 5 == 0) {//有大标题的那一项商品


            //遮掩整个item的时候，就是最上面的item余下可见的部分
            //当item0的最后的内容已经在title悬浮栏的后面时候，此时第一个仍然是item0
            //这里的100是50+50，大小标题的高度

            //这里的50是指标题栏的高度
            if (child0.getBottom() <= height) {
                c.drawRect(left, 0, right, child0.getBottom(), paint2);
                c.drawText("这是标题栏" + position, left, child0.getBottom(), textPaint);//绘制文本

            }

            if (height < child0.getBottom() && child0.getBottom() <= height + bigHeight) {

                c.drawRect(left, 0, right, height, paint2);
                c.drawText("这是标题栏" + position, left, height, textPaint);//绘制文本
            }


        } else {//普通没有大标题的商品

            if (child0.getBottom() <= height) {

                c.drawRect(left, 0, right, child0.getBottom(), paint2);
                c.drawText("这是标题栏" + position, left, child0.getBottom(), textPaint);//绘制文本
            } else {
                //固定不动
                c.drawRect(0, 0, right, height, paint2);
                c.drawText("这是标题栏" + position, left, height, textPaint);//绘制文本
            }
        }


    }


}
