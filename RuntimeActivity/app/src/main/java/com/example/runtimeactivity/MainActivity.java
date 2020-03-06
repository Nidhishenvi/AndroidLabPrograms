package com.example.runtimeactivity;
//DO IT-put an image as an runtime
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new CustomView(this));
    }


    public class CustomView extends View
    {
        final Paint mpaint=new Paint();

        public CustomView(Context context)
        {
            super(context);
            mpaint.setTextSize(75);
            mpaint.setColor(Color.CYAN);
        }
        protected void onDraw(Canvas canvas)
        {
            super.onDraw(canvas);
            canvas.drawText("hello",500,500,mpaint);
            setBackgroundColor(Color.BLACK);
            //canvas.drawPicture();

            invalidate();
        }
    }
}

