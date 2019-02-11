package fun.zzti.memoire;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver{@Override
public void onReceive(Context context, Intent intent) {
    //设置通知内容并在onReceive()这个函数执行时开启
    NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    Notification notification=new NotificationCompat.Builder(context)
    .setContentTitle("Hello?")
            .setContentText("Have you done all the tasks today?")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setLargeIcon(BitmapFactory.decodeResource(Resources.getSystem(),R.mipmap.ic_launcher))
            .build();

    notification.defaults = Notification.DEFAULT_ALL;
    manager.notify(1, notification);


    Intent i = new Intent(context, LongRunningService.class);
    context.startService(i);
}


}
