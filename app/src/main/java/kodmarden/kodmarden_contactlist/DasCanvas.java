package kodmarden.kodmarden_contactlist;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
/**
 * Created by magnus on 1/29/15.
 */
public class DasCanvas extends View implements OnTouchListener {

    int x=0;
    int y=0 ;
    public DasCanvas(Context context) {
        super(context);
        this.setOnTouchListener(this);

    }
    @Override
    public void onDraw(Canvas canvas)
    {
        if(x==0&&y==0) {
            x = canvas.getWidth() / 2;
            y = canvas.getHeight() / 2;
        }
        Paint paint=new Paint();
        paint.setColor(Color.parseColor("#FF0000"));
        System.out.println("x: " + x + "y: " + y);
        paint.setStrokeWidth(10);
        canvas.drawCircle(x,y,100,paint);

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(Math.abs(x-event.getX())<100 && Math.abs(y-event.getY())<100)
        {
            x= (int)event.getX();
            y= (int)event.getY();
            System.out.println("dragging shit");
            invalidate();
        }
        System.out.println(event.getX());
        System.out.println(event.getY());

        return true;
    }
}
