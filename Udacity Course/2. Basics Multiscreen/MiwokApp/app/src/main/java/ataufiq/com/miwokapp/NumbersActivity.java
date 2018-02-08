package ataufiq.com.miwokapp;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("lutti","one"));
        words.add(new Word("lutti","two"));
        words.add(new Word("lutti","three"));
        words.add(new Word("lutti","four"));
        words.add(new Word("lutti","five"));
        words.add(new Word("lutti","six"));
        words.add(new Word("lutti","seven"));
        words.add(new Word("lutti","eight"));
        words.add(new Word("lutti","nine"));
        words.add(new Word("lutti","ten"));

        WordAdapter itemsAdapter=
                new WordAdapter(this,words);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

    }
}
