package swu.xl.healthdiet.FoodMatch;

import java.util.ArrayList;
import java.util.List;

import swu.xl.healthdiet.R;

/**
 * 数据加载工具类
 */
public class DataUtil {
    /**
     * 正常加载
     * @return
     */
    public static List<FoodBean> loadData(){
        return FoodUtil.getAllFoodList();
    }

    /**
     * 本地文件加载数据
     * @return
     */
    public static List<FoodBean> loadDateByFile(){
        return null;
    }

    /**
     * 数据库加载数据
     * @return
     */
    public static List<FoodBean> loadDateBySQL(){
        return null;
    }

    /**
     * 网络加载数据
     * @return
     */
    public static List<FoodBean> loadDateByServer(){
        return null;
    }

}
