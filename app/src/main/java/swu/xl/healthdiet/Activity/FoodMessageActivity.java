package swu.xl.healthdiet.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

import swu.xl.healthdiet.FoodMatch.DataManager;
import swu.xl.healthdiet.FoodMatch.FoodBean;
import swu.xl.healthdiet.R;
import swu.xl.xltoolbar.XLToolBar;

public class FoodMessageActivity extends FoodBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_message);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);
        FoodBean foodBean = DataManager.getDataManager().getBeans().get(position);
        //Toast.makeText(FoodMessageActivity.this, foodBean.toString(), Toast.LENGTH_SHORT).show();

        //设置toolbar
        XLToolBar toolBar = findViewById(R.id.tool_bar);
        toolBar.getLeft_btn().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolBar.getLogo_btn().setText(foodBean.food_name);

        //设置图片
        findViewById(R.id.food_icon).setBackgroundResource(foodBean.food_id);

        //设置名称
        TextView name = findViewById(R.id.food_name);
        name.setText(foodBean.food_name);

        //设置具体描述
        TextView intro = findViewById(R.id.food_intro);
        intro.setText(foodBean.food_intro);

        //设置不能一起吃
        TextView no = findViewById(R.id.food_no);
        no.setText(foodBean.food_no);
    }
}