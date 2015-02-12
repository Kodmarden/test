package kodmarden.kodmarden_contactlist;

/**
 * Created by magnus on 2/3/15.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class AnimationActivity extends Activity
{
    private AnimationView animationView;
    private boolean running = false;
    private Ticker ticker = new Ticker();
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        animationView=new AnimationView(this);
        setContentView(animationView);
        ticker.startTicking();
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        ticker.stopTicking();
    }

    private class Ticker implements Runnable
    {
        public void startTicking()
        {
            running = true;
            new Thread(this).start();
        }

        public void stopTicking()
        {
            running = false;
        }
        public void run()
        {
            while (running)
            {
                try
                {
                    Thread.sleep(20);
                    animationView.postInvalidate();
                }
                catch (Exception e)
                {
                }
            }
        }
    }
}
