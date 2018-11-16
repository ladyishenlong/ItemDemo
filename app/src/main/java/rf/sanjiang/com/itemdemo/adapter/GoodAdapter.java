package rf.sanjiang.com.itemdemo.adapter;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import rf.sanjiang.com.itemdemo.Layout;
import rf.sanjiang.com.itemdemo.R;
import rf.sanjiang.com.itemdemo.bean.GoodData;
import rf.sanjiang.com.itemdemo.bean.GoodData2;
import rf.sanjiang.com.itemdemo.bean.GoodData3;
import rf.sanjiang.com.itemdemo.bean.ItemGoodData;


@Layout(layoutId = R.layout.good_item)
public class GoodAdapter extends BaseRecyAdapter2<ItemGoodData> {

    public GoodAdapter(Context context, List<ItemGoodData> datas) {
        super(context, datas);
    }

    @Override
    protected void bindData(BaseViewHolder2 holder, ItemGoodData data, int position) {
        LinearLayout layout = holder.getView(R.id.layout);
        TextView tv_item = holder.getView(R.id.tv_item);


        if (tv_item.getVisibility() == View.VISIBLE) {
            tv_item.setVisibility(View.GONE);

            for (GoodData3 goodData3 : data.data.datalist) {
                TextView textView=new TextView(context);
                textView.setTextSize(20);
                textView.setText(goodData3.goodName+" "+goodData3.title+" "+goodData3.samllTiele);
                layout.addView(textView);
            }

        }

    }

    public List<ItemGoodData> getDatas(){
        return datas;
    }
}
