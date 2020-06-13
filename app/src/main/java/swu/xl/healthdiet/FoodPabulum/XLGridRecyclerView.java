package swu.xl.healthdiet.FoodPabulum;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import swu.xl.healthdiet.FoodMatch.DataManager;
import swu.xl.healthdiet.FoodMatch.FoodBean;
import swu.xl.healthdiet.R;

public class XLGridRecyclerView extends RecyclerView {
    //监听者
    private OnItemClickListener listener;

    /**
     * 构造方法：Java代码初始化
     * @param context
     */
    public XLGridRecyclerView(@NonNull Context context) {
        super(context);

        //初始化操作
        init();
    }

    /**
     * 构造方法：Xml代码初始化
     * @param context
     * @param attrs
     */
    public XLGridRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        //初始化操作
        init();
    }

    /**
     * 初始化操作
     */
    private void init() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        this.setLayoutManager(gridLayoutManager);
        this.setAdapter(new MyAdapter(DataManager.getDataManager().getBeans()));
    }

    /**
     * 适配器
     */
    class MyAdapter extends Adapter {
        //存储数据
        private List<FoodBean> friends;

        //构造方法
        public MyAdapter(List<FoodBean> friends) {
            this.friends = friends;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            //加载布局
            View inflate = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.grid_item_layout, parent,
                    false);

            //返回布局
            return new MyViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
            //加载数据
            final FoodBean food = friends.get(position);

            //设置数据
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            myViewHolder.food_icon.setImageResource(food.food_id);
            myViewHolder.food_name.setText(food.food_name);

            //设置点击事件
            myViewHolder.food_icon.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        listener.onItemClick(position);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return friends.size();
        }
    }

    /**
     * ViewHolder
     */
    static class MyViewHolder extends ViewHolder {
        //图片
        ImageView food_icon;
        //名称
        TextView food_name;

        /**
         * 构造方法
         * @param itemView
         */
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //绑定控件
            food_icon = itemView.findViewById(R.id.food_icon);
            food_name = itemView.findViewById(R.id.food_name);
        }
    }

    /**
     * 监听item被点击
     */
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
