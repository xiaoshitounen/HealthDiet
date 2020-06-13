package swu.xl.healthdiet.FoodMatch;

import java.util.List;

/**
 * 数据管理者
 */
public class DataManager {
    //数据
    private List<FoodBean> beans;

    //单例模式
    private static DataManager instance = null;
    //私有化构造方法
    private DataManager(){
        loadData();
    }
    public static synchronized DataManager getDataManager(){
        if (instance == null){
            instance = new DataManager();
        }
        return instance;
    }

    //加载数据
    public void loadData() {
        beans = DataUtil.loadData();
    }

    //get方法
    public List<FoodBean> getBeans() {
        return beans;
    }
    //set方法
    public void setBeans(List<FoodBean> beans) {
        this.beans = beans;
    }
}
