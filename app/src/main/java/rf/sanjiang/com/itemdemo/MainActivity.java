package rf.sanjiang.com.itemdemo;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import rf.sanjiang.com.itemdemo.Item_decoration.GoodItemDecoration;
import rf.sanjiang.com.itemdemo.Item_decoration.GoodTitleItemDecoration;
import rf.sanjiang.com.itemdemo.Item_decoration.LineItemDecoration;
import rf.sanjiang.com.itemdemo.Item_decoration.TitleItemDecoration;
import rf.sanjiang.com.itemdemo.adapter.GoodAdapter;
import rf.sanjiang.com.itemdemo.adapter.TestAdapter;
import rf.sanjiang.com.itemdemo.bean.GoodData;
import rf.sanjiang.com.itemdemo.bean.GoodData2;
import rf.sanjiang.com.itemdemo.bean.GoodData3;
import rf.sanjiang.com.itemdemo.bean.ItemGoodData;
import rf.sanjiang.com.itemdemo.bean.TestData;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private TestAdapter adapter;
    private SmartRefreshLayout refresh;
    private ClassicsFooter footer;

    private List<TestData> datas;
    private GoodAdapter goodAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        refresh = findViewById(R.id.refresh);
//        footer = findViewById(R.id.footer);


//        refresh.setRefreshHeader(new ClassicsHeader(this));
//        refresh.setRefreshFooter(new ClassicsFooter(this));
//        refresh.setEnableOverScrollDrag(true);
//
//
//        recyclerView.addItemDecoration(new LineItemDecoration());
//        recyclerView.addItemDecoration(new TitleItemDecoration());
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new TestAdapter(this, null);
//        recyclerView.setAdapter(adapter);

//        datas = new ArrayList<>();
//
//        for (int i = 0; i < 5; i++) {
//
//            datas.add(new TestData("这里是内容" + i));
//
//        }
//
//        adapter.setDataSource(datas);
//
//
//        refresh.setOnLoadMoreListener(new OnLoadMoreListener() {
//            @Override
//            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
//
//                //加载一次标记没有更多数据了
////                refreshLayout.finishLoadMoreWithNoMoreData();
//                refreshLayout.closeHeaderOrFooter();//关闭刷新
//
//                List<TestData> testDataList = new ArrayList<>();
//                testDataList.add(new TestData("新增加的内容"));
//                TestData testData = new TestData("新增加的内容");
//                adapter.addItem(adapter.getItemCount(), testData);
//            }
//        });


        init();

    }


    private void init() {

        List<GoodData> goodList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {


            List<GoodData2> goodData2s = new ArrayList<>();

            for (int j = 0; j < 4; j++) {

                List<GoodData3> goodData3s = new ArrayList<>();
                for (int k = 0; k < 5; k++) {

                    GoodData3 goodData3;
                    if(j==0){
                        goodData3 = new GoodData3("大标题" + i, "小标题" + j, "商品" + k,true);

                    }else {
                        goodData3 = new GoodData3("大标题" + i, "小标题" + j, "商品" + k,false);
                    }
                    goodData3s.add(goodData3);
                }
                GoodData2 goodData2 = new GoodData2("小标题" + j, goodData3s);
                goodData2s.add(goodData2);
            }

            GoodData goodData = new GoodData("大标题" + i, goodData2s);
            goodList.add(goodData);

        }


        List<ItemGoodData> itemList = new ArrayList<>();

        for (GoodData goodData : goodList) {
            for (GoodData2 datum : goodData.data) {
                itemList.add(new ItemGoodData(datum));
            }
        }


        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        goodAdapter = new GoodAdapter(this, itemList);
        recyclerView.setAdapter(goodAdapter);
        recyclerView.addItemDecoration(new GoodItemDecoration());
        recyclerView.addItemDecoration(new GoodTitleItemDecoration(goodAdapter));


    }


}
