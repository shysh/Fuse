package com.tjl.fuse.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.tjl.fuse.R;
import com.tjl.fuse.player.tracks.FuseTrack;
import java.util.List;

/**
 * Created by JoshBeridon on 9/19/15.
 */
public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.TrackViewHolder> {

  private List<FuseTrack> tracks;

  public PlaylistAdapter(List<FuseTrack> tracks) {
    this.tracks = tracks;
  }

  @Override public TrackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.playlist_card, parent, false);

    return new TrackViewHolder(view);
  }

  @Override public void onBindViewHolder(TrackViewHolder holder, int position) {
    holder.text.setText(tracks.get(position).title);
    Picasso.with(holder.card.getContext())
        .load(tracks.get(position).image_url)
        .into(holder.image);
  }


  @Override public int getItemCount() {
    return tracks.size();
  }

  public class TrackViewHolder extends RecyclerView.ViewHolder {
    CardView card;
    ImageView image;
    TextView text;

    public TrackViewHolder(View itemView) {
      super(itemView);
      card = (CardView) itemView.findViewById(R.id.card);
      image = (ImageView) itemView.findViewById(R.id.track_photo);
      text = (TextView) itemView.findViewById(R.id.track_name);
    }
  }
}
