package google.PlayStore.console;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication3.R;

import java.util.ArrayList;

public class GameTypeAdapter extends RecyclerView.Adapter<GameTypeAdapter.ViewHolder>{

    public ArrayList<GameType> gametype;
    private Context context;
    private LayoutInflater layoutInflater;

    public GameTypeAdapter(ArrayList<GameType> gametype, Context context) {
        this.gametype = gametype;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.game_type, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.recyclerView.setAdapter(new GameAdapter(context,gametype.get(position).gameList));
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setHasFixedSize(true);
        holder.tvHeading.setText(gametype.get(position).listTitle);
    }

    @Override
    public int getItemCount() {
        return gametype.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView tvHeading;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.rvGames);
            tvHeading = (TextView) itemView.findViewById(R.id.tvGameType);
        }
    }
}
