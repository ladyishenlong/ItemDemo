package rf.sanjiang.com.itemdemo.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import rf.sanjiang.com.itemdemo.Layout;

public abstract class BaseRecyAdapter2<T> extends RecyclerView.Adapter<BaseViewHolder2> {

    protected Integer layoutId;

    protected Context context;
    protected List<T> datas;



    public BaseRecyAdapter2(Context context, List<T> datas) {
        this.context = context;
        this.datas = datas;
        init();
    }


    private void init() {

        Class<? extends BaseRecyAdapter2> clazz = this.getClass();

        if (clazz.getAnnotations() != null) {
            if (clazz.isAnnotationPresent(Layout.class)) {

                Layout layout = clazz.getAnnotation(Layout.class);
                layoutId = layout.layoutId();

            }
        }
    }




    @NonNull
    @Override
    public BaseViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View converView = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        BaseViewHolder2 viewHolder = new BaseViewHolder2(converView);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder2 holder, int position) {
        bindData(holder,datas.get(position), position);
    }


    /**
     * 在这里绑定数据
     *
     * @param data
     * @param position
     */
    protected abstract void bindData(BaseViewHolder2 holder,T data, int position);


    /**
     * 刷新数据
     *
     * @param datas
     */
    public void setDataSource(List<T> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    protected View getLayoutView(Context context, @LayoutRes int layoutId) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutId, null);
        return view;
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }








    protected OnRecyItemClickListener onRecyItemClickListener;

    public interface OnRecyItemClickListener<T> {
        void onRecyItemClick(int position, T data);
    }

    public void setOnRecyItemClickListener(OnRecyItemClickListener onRecyItemClickListener) {
        this.onRecyItemClickListener = onRecyItemClickListener;
    }


}

