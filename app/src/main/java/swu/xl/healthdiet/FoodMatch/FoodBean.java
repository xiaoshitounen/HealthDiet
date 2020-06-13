package swu.xl.healthdiet.FoodMatch;

/**
 * Model：模型
 */
public class FoodBean {
    //资源id
    public int food_id;
    //名称
    public String food_name;
    //简介
    public String food_intro;
    //不可匹配
    public String food_no;

    /**
     * 构造方法
     */
    public FoodBean(int food_id, String food_name, String food_intro, String food_no) {
        this.food_id = food_id;
        this.food_name = food_name;
        this.food_intro = food_intro;
        this.food_no = food_no;
    }

    @Override
    public String toString() {
        return "FoodBean{" +
                "food_id=" + food_id +
                ", food_name='" + food_name + '\'' +
                ", food_intro='" + food_intro + '\'' +
                ", food_no='" + food_no + '\'' +
                '}';
    }

}

