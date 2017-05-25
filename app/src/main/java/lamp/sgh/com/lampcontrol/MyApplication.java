package lamp.sgh.com.lampcontrol;

import android.app.Application;

import com.aitangba.swipeback.ActivityLifecycleHelper;

/**
 * Created by Won on 2017/3/11.
 */

public class MyApplication extends Application {

    public static int REQUESTCODE = 0x00;

    public static int RESULTCODE = 0x01;

    //是否夜间模式
    public static boolean NIGHT_MODE = false;

    @Override
    public void onCreate() {
        super.onCreate();
        //滑动返回注册
        registerActivityLifecycleCallbacks(ActivityLifecycleHelper.build());
    }
}
