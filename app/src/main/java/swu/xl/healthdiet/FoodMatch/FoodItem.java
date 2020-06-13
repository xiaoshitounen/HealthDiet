package swu.xl.healthdiet.FoodMatch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import swu.xl.healthdiet.R;

/**
 * Controller：控制器
 */
public class FoodItem {
    //item对应的模型
    private FoodBean bean;
    //item对应的视图
    private int layout;

    //存储关联好的视图
    private View item_view;

    /**
     * 构造方法
     */
    public FoodItem(FoodBean bean, Context context, View convertView) {
        this.bean = bean;
        this.layout = R.layout.food_layout;

        //关联
        initView(context,convertView);
    }

    //将模型和视图关联
    private void initView(Context context,View convertView){
        //1.获取布局
        ViewHolder viewHolder;
        if (convertView == null){
            //2.获取子视图

            //加载布局
            convertView = LayoutInflater.from(context).inflate(layout, null);
            //完善ViewHolder
            viewHolder = new ViewHolder();
            viewHolder.food_icon = convertView.findViewWithTag(context.getResources().getString(R.string.food_icon));
            viewHolder.food_name = convertView.findViewWithTag(context.getResources().getString(R.string.food_name));
            viewHolder.food_no = convertView.findViewWithTag(context.getResources().getString(R.string.food_no));
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //3.设置数据
        viewHolder.food_icon.setImageResource(bean.food_id);
        viewHolder.food_name.setText(bean.food_name);
        viewHolder.food_no.setText("不能搭配："+bean.food_no);

        //4.保存视图
        item_view = convertView;
    }

    /**
     * 内部类：ViewHolder
     */
    private class ViewHolder{
        public ImageView food_icon;
        public TextView food_name;
        public TextView food_no;
    }

    //get方法
    public View getItem_view() {
        return item_view;
    }

}
