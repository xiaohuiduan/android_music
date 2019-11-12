package cc.weno.qq_music.music_util.page;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import cc.weno.qq_music.MainActivity;
import cc.weno.qq_music.MusicActivity;
import cc.weno.qq_music.R;
import cc.weno.qq_music.music_util.dao.SearchResultDao;
import cc.weno.qq_music.service.MusicService;

public class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.ViewHolder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<SearchResultDao.DataBean.SongListBean> songList;

    public SongListAdapter(Context context, SearchResultDao searchResultDao) {
        this.context = context;
        this.songList = searchResultDao.getData().getSongList();
        layoutInflater = LayoutInflater.from(this.context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(layoutInflater.inflate(R.layout.song_info,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final SearchResultDao.DataBean.SongListBean song = songList.get(position);
        holder.songId.setText(song.getSongMid()+"");
        holder.songName.setText(song.getSongName());
        holder.authorName.setText(song.getSinger().get(0).getSingerName());
        holder.songInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MusicActivity.class);
                intent.putExtra("url",holder.songId.getText());
                intent.putExtra("albummid",song.getAlbumMid());
                intent.putExtra("singerMid",song.getSongMid());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView authorName;
        TextView songName;
        TextView songId;
        CardView songInfo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.song_img);
            authorName= itemView.findViewById(R.id.author_name);
            songName= itemView.findViewById(R.id.song_name);
            songId = itemView.findViewById(R.id.songId);
            songInfo = itemView.findViewById(R.id.song_info);
        }
    }
}
