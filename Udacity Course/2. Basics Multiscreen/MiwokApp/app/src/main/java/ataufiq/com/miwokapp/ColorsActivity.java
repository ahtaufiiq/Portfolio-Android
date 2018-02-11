package ataufiq.com.miwokapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = (new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("weṭeṭṭi","red",R.drawable.color_red,
                R.raw.color_red));
        words.add(new Word("chokokki","green",R.drawable.color_green,
                R.raw.color_green));
        words.add(new Word("ṭakaakki","brown",R.drawable.color_brown,
                R.raw.color_brown));
        words.add(new Word("ṭopoppi","gray",R.drawable.color_gray,
                R.raw.color_gray));
        words.add(new Word("kululli","black",R.drawable.color_black,
                R.raw.color_black));
        words.add(new Word("kelelli","white",R.drawable.color_white,
                R.raw.color_white));
        words.add(new Word("ṭopiisә","dusty yellow",R.drawable.color_dusty_yellow,
                R.raw.color_dusty_yellow));
        words.add(new Word("chiwiiṭә","mustard yellow",R.drawable.color_mustard_yellow,
                R.raw.color_mustard_yellow));

        WordAdapter itemsAdapter=
                new WordAdapter(this,words,R.color.category_colors);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Word word =words.get(position);
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getmAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();

        releaseMediaPlayer();
    }

    private void releaseMediaPlayer(){
        if (mMediaPlayer != null){
            mMediaPlayer.release();

            mMediaPlayer = null;
        }
    }
}
