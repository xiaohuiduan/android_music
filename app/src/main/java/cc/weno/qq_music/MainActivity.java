package cc.weno.qq_music;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

import cc.weno.qq_music.music_util.dao.SearchResultDao;
import cc.weno.qq_music.music_util.net.AsyncRequest;
import cc.weno.qq_music.music_util.net.got.SearchSong;
import cc.weno.qq_music.music_util.page.SongListAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText searchKey;
    private Button searchButton;
    private RecyclerView songList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        searchKey= findViewById(R.id.search_key);
        searchButton =findViewById(R.id.key_button);
        songList = findViewById(R.id.song_list);
        searchButton.setOnClickListener(this);
        songList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onClick(View view) {
        String key = searchKey.getText().toString();
        if (key.length() != 0){
            SearchSong searchSong = new SearchSong(key);
            AsyncTask asyncTask = new AsyncRequest().execute(searchSong);
            try {
                SearchResultDao searchResultDao = (SearchResultDao) asyncTask.get();
                SongListAdapter adapter = new SongListAdapter(MainActivity.this, searchResultDao);
                songList.setAdapter(adapter);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
