package kodmarden.kodmarden_contactlist;

/**
 * Created by magnus on 2/3/15.
 */
import java.util.Random;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class BallPainter
{
    private Paint paint;
    private Ball ball;
    private static final Random random = new Random();
    public BallPainter(Ball ball, Paint paint)
    {
        this.paint = paint;
        this.ball = ball;
    }
    public BallPainter(Ball ball)
    {
        this(ball, createRandomPaint());
    }
    public void paintBall(Canvas canvas)
    {
        canvas.drawCircle(ball.getX(), ball.getY(), ball.getRadius(), paint);
        canvas.drawText("Michael Bui", (ball.getX()-35), (ball.getY()-80), paint);
    }
    private static Paint createRandomPaint()
    {
        byte[] params = new byte[4];
        random.nextBytes(params);
        Paint paint = new Paint();
        paint.setColor(Color.argb(params[0], params[1], params[2], params[3]));
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        return paint;
    }
}