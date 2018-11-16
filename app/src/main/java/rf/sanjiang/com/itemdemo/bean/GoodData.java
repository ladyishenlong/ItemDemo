package rf.sanjiang.com.itemdemo.bean;

import java.util.List;

public class GoodData {

    public String title;//大标题

    public List<GoodData2> data;

    public GoodData(String title, List<GoodData2> data) {
        this.title = title;
        this.data = data;
    }
}
