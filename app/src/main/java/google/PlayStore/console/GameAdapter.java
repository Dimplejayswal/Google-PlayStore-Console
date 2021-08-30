package google.PlayStore.console;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication3.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.CustomViewHolder>{
    private Context context;
    private ArrayList<Game> game;
    private LayoutInflater inflater;

    public GameAdapter(Context context, ArrayList<Game> game) {
        this.context = context;
        this.game = game;
        this.inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = inflater.inflate(R.layout.game, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Game game1 = game.get(position);
        holder.tvChapterName.setText(game1.title);
        Picasso.get().load(game1.imageUrl).into(holder.ivChapter);
    }

    @Override
    public int getItemCount() {
        return game.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivChapter;
        public TextView tvChapterName;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            tvChapterName = (TextView) itemView.findViewById(R.id.tvGameOption);
            ivChapter = (ImageView) itemView.findViewById(R.id.imgGameOption);
        }
    }
}
