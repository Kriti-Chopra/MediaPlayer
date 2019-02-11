package kriti.somevalue.com.surprise;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer player;
    ViewPager viewPager;
    MyPagerAdapter adapter;

    int[] songArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager=(ViewPager) findViewById(R.id.viewPager);
        adapter=new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        songArray=new int[]{R.raw.tujhe_dekha_to,R.raw.kaabil_hoon};
    }

    public void Play(View view){
        if(player==null){
            player=MediaPlayer.create(this,songArray[viewPager.getCurrentItem()]);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }

    private void stopPlayer() {
        if(player!=null){
            player.release();
            player=null;
            Toast.makeText(this, "Releasing!", Toast.LENGTH_SHORT).show();
        }
    }

    public void Pause(View view){
        if(player!=null){
            player.pause();
        }
    }


    public void Stop(View view){
        stopPlayer();
    }
}
