package rf.sanjiang.com.itemdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import rf.sanjiang.com.itemdemo.Layout;
import rf.sanjiang.com.itemdemo.R;
import rf.sanjiang.com.itemdemo.bean.TestData;

@Layout(layoutId = R.layout.item)
public class TestAdapter extends BaseRecyAdapter2<TestData> {


    public TestAdapter(Context context, List<TestData> datas) {
        super(context, datas);
    }

    @Override
    protected void bindData(BaseViewHolder2 holder, TestData data, int position) {
        LinearLayout layout=holder.getView(R.id.layout);

        TextView item=holder.getView(R.id.item);
        item.setText(data.title);



    }





    public void addItem(int position,TestData data){
        datas.add(position, data);
        notifyItemInserted(position);
        notifyItemRangeChanged(position,datas.size()-position);//通知数据与界面重新绑定

    }


}
