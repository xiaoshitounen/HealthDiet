package swu.xl.healthdiet.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import swu.xl.healthdiet.FoodPabulum.XLGridRecyclerView;
import swu.xl.healthdiet.R;
import swu.xl.xltoolbar.XLToolBar;

public class FoodPabulumActivity extends FoodBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_pabulum);

        //设置toolbar
        XLToolBar toolBar = findViewById(R.id.tool_bar);
        toolBar.getLeft_btn().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //recycler
        XLGridRecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setOnItemClickListener(new XLGridRecyclerView.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //FoodBean foodBean = DataManager.getDataManager().getBeans().get(position);
                //Toast.makeText(FoodMatchActivity.this, foodBean.toString(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(FoodPabulumActivity.this,FoodMessageActivity.class);
                intent.putExtra("position",position);

                //跳转界面
                startActivity(intent);
            }
        });
    }
}