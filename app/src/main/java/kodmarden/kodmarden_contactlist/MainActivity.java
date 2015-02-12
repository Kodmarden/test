package kodmarden.kodmarden_contactlist;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import android.widget.RelativeLayout;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.dasLayout);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
        mainLayout.addView(new DasCanvas(this.getBaseContext()), params);
        //setContentView(new DasCanvas(this.getBaseContext()));
    }


    public void doStuff(View view) {
        Intent intent = new Intent(this, DasActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        intent.putExtra("dasString", editText.getText().toString());
        startActivity(intent);
    }
    public void doOtherStuff(View view) {
        Intent intent = new Intent(this, CanvasActivity.class);
        startActivity(intent);
    }
}
