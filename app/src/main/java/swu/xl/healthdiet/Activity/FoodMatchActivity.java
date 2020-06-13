package swu.xl.healthdiet.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import swu.xl.healthdiet.FoodMatch.DataManager;
import swu.xl.healthdiet.FoodMatch.FoodBean;
import swu.xl.healthdiet.FoodMatch.FoodUtil;
import swu.xl.healthdiet.FoodMatch.XLListView;
import swu.xl.healthdiet.R;

public class FoodMatchActivity extends FoodBaseActivity {


    private EditText search_text;
    private ImageView search_btn;
    private XLListView listView;
    private SwipeRefreshLayout refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_match);

        listView = findViewById(R.id.list_view);
        refresh = findViewById(R.id.refresh);
        search_text = findViewById(R.id.search_text);
        search_btn = findViewById(R.id.search_btn);

        //搜索事件
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(FoodMatchActivity.this, "开始搜索", Toast.LENGTH_SHORT).show();
                if (!TextUtils.isEmpty(search_text.getText().toString())){
                    final List<FoodBean> foods = new ArrayList<>();
                    //筛选满足条件的bean
                    for (FoodBean foodBean : FoodUtil.getAllFoodList()) {
                        if (foodBean.food_name.contains(search_text.getText().toString())){
                            foods.add(foodBean);
                        }
                    }
                    //刷新
                    refresh.setRefreshing(true);
                    //取消刷新
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (refresh.isRefreshing()) {
                                refresh.setRefreshing(false);
                                //替换
                                DataManager.getDataManager().getBeans().clear();
                                DataManager.getDataManager().getBeans().addAll(foods);
                                listView.getAdapter().notifyDataSetChanged();
                            }
                        }
                    }, 800);
                }
            }
        });

        //刷新事件
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //跟新数据
                DataManager.getDataManager().loadData();

                //取消刷新
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (refresh.isRefreshing()) {
                            refresh.setRefreshing(false);

                            //刷新
                            listView.getAdapter().notifyDataSetChanged();
                        }
                    }
                }, 800);
            }
        });

        //ListView的点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //FoodBean foodBean = DataManager.getDataManager().getBeans().get(position);
                //Toast.makeText(FoodMatchActivity.this, foodBean.toString(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(FoodMatchActivity.this,FoodMessageActivity.class);
                intent.putExtra("position",position);

                //跳转界面
                startActivity(intent);
            }
        });
    }
}