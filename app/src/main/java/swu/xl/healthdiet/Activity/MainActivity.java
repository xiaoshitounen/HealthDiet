package swu.xl.healthdiet.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import swu.xl.healthdiet.R;

public class MainActivity extends FoodBaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //设置监听事件
        findViewById(R.id.food_match).setOnClickListener(this);
        findViewById(R.id.food_pabulum).setOnClickListener(this);
        findViewById(R.id.food_about).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();

        switch (v.getId()){
            case R.id.food_match:
                intent.setClass(MainActivity.this, FoodMatchActivity.class);
                break;
            case R.id.food_pabulum:
                intent.setClass(MainActivity.this, FoodPabulumActivity.class);
                break;
            case R.id.food_about:
                intent.setClass(MainActivity.this, FoodAboutActivity.class);
                break;
        }

        //跳转界面
        startActivity(intent);
    }
}