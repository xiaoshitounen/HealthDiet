package swu.xl.healthdiet.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.gyf.immersionbar.ImmersionBar;

import swu.xl.healthdiet.R;

public class FoodBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_base);

        //ImmersionBar.with(this).init();
        /*ImmersionBar.with(this)
                .reset()
                .statusBarColor(R.color.colorPrimary)
                .init();*/
    }
}