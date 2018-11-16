package rf.sanjiang.com.itemdemo.bean;

import java.util.List;

public class GoodData2 {


    public String smallTitle;//小标题


    public List<GoodData3> datalist;

    public GoodData2(String smallTitle, List<GoodData3> datalist) {
        this.smallTitle = smallTitle;
        this.datalist = datalist;
    }


}
