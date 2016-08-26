package githubzzx752904457.com.autorotarydemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.dalong.library.listener.OnItemClickListener;
import com.dalong.library.view.LoopRotarySwitchView;

public class MainActivity extends AppCompatActivity {
    private LoopRotarySwitchView rotaryView;
    private int width;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics dm = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(dm);
        width =dm.widthPixels;

        rotaryView = (LoopRotarySwitchView) findViewById(R.id.mRotaryView);
        rotaryView
                .setMultiple(3.0f)//设置前后item大小差别
                .setR(width/5)//设置半径
                .setAutoRotation(true)//设置是否自动旋转
                .setAutoRotationTime(2500)//设置自动旋转时间间隔
                .setAutoScrollDirection(LoopRotarySwitchView.AutoScrollDirection.left)//设置自动旋转方向
                .setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int item, View view) {
                        if (toast == null){
                            toast = Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT);
                        }else {
                            toast.setText("hello");
                        }
                        toast.show();
                    }
                });
    }
}
