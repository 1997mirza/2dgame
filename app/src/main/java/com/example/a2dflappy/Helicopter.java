package com.example.a2dflappy;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.support.constraint.solver.widgets.Rectangle;

import static com.example.a2dflappy.GameView.screenRatioX;
import static com.example.a2dflappy.GameView.screenRatioY;

public class Helicopter {

    public int speed=20;
    public boolean wasShot=true;
    int x, y,width, height,helCounter =1 ;
    Bitmap hel1, hel2, hel3, hel4;

    Helicopter(Resources res){

        hel1 = BitmapFactory.decodeResource(res, R.drawable.hel1);
        hel2 = BitmapFactory.decodeResource(res, R.drawable.hel2);
        hel3 = BitmapFactory.decodeResource(res, R.drawable.hel3);
        hel4 = BitmapFactory.decodeResource(res, R.drawable.hel4);

        width = hel1.getWidth();
        height=hel1.getHeight();

        width /=6;
        height /=6;

        width = (int) (width *screenRatioX);
        height = (int) (height *screenRatioY);

        hel1 = Bitmap.createScaledBitmap(hel1,width,height,false);
        hel2 = Bitmap.createScaledBitmap(hel2,width,height,false);
        hel3 = Bitmap.createScaledBitmap(hel3,width,height,false);
        hel4 = Bitmap.createScaledBitmap(hel4,width,height,false);

        y= -height;
    }

Bitmap getHel (){

        if (helCounter ==1){
            helCounter++;
            return hel1;
        }
    if (helCounter ==2){
        helCounter++;
        return hel2;
    }
    if (helCounter ==3){
        helCounter++;
        return hel3;
    }
    helCounter= 1;
    return hel4;

}

Rect getCollisionShape (){
        return new Rect(x,y,x+width,y+height);
}

}
