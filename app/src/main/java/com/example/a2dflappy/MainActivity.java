package com.example.a2dflappy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Trace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean isMute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //kao neki sablon za full screan
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GameActivity.class));

            }
        });

        TextView highScoreTxt = findViewById(R.id.highScoreTxt);
        final SharedPreferences prefs = getSharedPreferences("game",MODE_PRIVATE);
        highScoreTxt.setText("Highscore"+prefs.getInt("highscore",0));
        isMute=prefs.getBoolean("isMute",false);

        final TextView volumeCtrl=findViewById(R.id.volumeCtrl);
        if (isMute) {
            volumeCtrl.setText("Sound:Off");
        }else
        {
            volumeCtrl.setText("Sound:On");
        }
        volumeCtrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isMute=!isMute;
                if (isMute) {
                    volumeCtrl.setText("Sound:Off");
                }else
                {
                    volumeCtrl.setText("Sound:On");
                }
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("isMute",isMute);
                editor.apply();
            }
        });

    }
}
