package lamp.sgh.com.lampcontrol.base;

import android.os.Bundle;

import com.aitangba.swipeback.SwipeBackActivity;

import butterknife.ButterKnife;
import lamp.sgh.com.lampcontrol.MyApplication;
import lamp.sgh.com.lampcontrol.R;


/**
 * Created by Won on 2017/3/11.
 */

public abstract class BaseActivity<V, T extends BasePresenter<V>> extends SwipeBackActivity {

    protected T presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (MyApplication.NIGHT_MODE) {
            setTheme(R.style.NightThemeTransNav);
        } else {

        }
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        ButterKnife.bind(this);
        presenter = initPresenter();
        presenter.attach((V) this);
        initView();
        //夜间模式颜色
        if (MyApplication.NIGHT_MODE) {
//            findViewById(R.id.root_view).setBackgroundColor(getResources().getColor(R.color.colorNightBg));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dettach();
        presenter.onDestroy();
    }

    abstract protected T initPresenter();

    abstract protected int setLayoutId();

    abstract protected void initView();

}
