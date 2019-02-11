package fun.zzti.memoire;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

public class alarmActivity extends AppCompatActivity {
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_alarm);

        intent = new Intent(this, LongRunningService.class);
        //开启关闭Service
        startService(intent);

        //设置一个Toast来提醒使用者提醒的功能已经开始
        Toast.makeText(alarmActivity.this,"提醒的功能已经开启，关闭界面则会取消提醒。",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在Activity被关闭后，关闭Service
        stopService(intent);


    }
}
