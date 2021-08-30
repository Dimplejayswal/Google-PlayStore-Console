package google.PlayStore.console;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication3.R;
import com.google.android.material.navigation.NavigationBarView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView rvSubject;
    private GameTypeAdapter gameTypeAdapter;
    private ArrayList<GameType> games = new ArrayList<>();
    NavigationBarView bottomNavigationView;
    int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rvSubject = (RecyclerView) findViewById(R.id.rvGameOptions);
        bottomNavigationView = findViewById(R.id.bottomAppBar);

//        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.games:
//
//                        number = 1;
//                        Toast.makeText(getApplicationContext(),"Number 1",Toast.LENGTH_SHORT).show();
//                        games = addItemsFromJSON();
//                        return true;
//                    case R.id.apps:
//
//                        number = 2;
//                        Toast.makeText(getApplicationContext(),"Number 2",Toast.LENGTH_SHORT).show();
//                       // games = addAppsFromJSON();
//                        return true;
//
//                    case R.id.movies_tv:
//
//                        number = 3;
//                        Toast.makeText(getApplicationContext(),"Number 3",Toast.LENGTH_SHORT).show();
//
//                        return true;
//
//                    case R.id.books:
//
//                        number = 4;
//                        Toast.makeText(getApplicationContext(),"Number 4",Toast.LENGTH_SHORT).show();
//
//                        return true;
//                }
//                return false;
//            }
//        });

        games = addItemsFromJSON();

        gameTypeAdapter = new GameTypeAdapter(games, HomeActivity.this);
        LinearLayoutManager manager = new LinearLayoutManager(HomeActivity.this);
        rvSubject.setLayoutManager(manager);
        rvSubject.setAdapter(gameTypeAdapter);
    }

//   private ArrayList<GameType> addAppsFromJSON() {
//
//       ArrayList<GameType> AllGames = new ArrayList<GameType>();
//       try {
//
//           JSONArray array = new JSONArray(readAppJSON());
//
//           for(int i=0;i<array.length();i++)
//           {
//               JSONObject jsonObject = array.getJSONObject(i);
//               String GameTypeTitle = jsonObject.getString("list_title");
//               String innertitle = "";
//               String gameImageUrl = "";
//
//               JSONArray GamesofGameType = jsonObject.getJSONArray("games");
//               GameType gametype1 = new GameType();
//               gametype1.listTitle = GameTypeTitle;
//               gametype1.gameList = new ArrayList<Game>();
//
//               for(int j=0;j<GamesofGameType.length();j++)
//               {
//                   JSONObject innerobject = GamesofGameType.getJSONObject(j);
//                   innertitle = innerobject.getString("title");
//                   gameImageUrl = innerobject.getString("img");
//
//                   Game game1 = new Game();
//                   game1.title = innertitle;
//                   game1.imageUrl = gameImageUrl;
//                   gametype1.gameList.add(game1);
//               }
//               AllGames.add(gametype1);
//           }
//
//       } catch (JSONException e) {
//           e.printStackTrace();
//           Toast.makeText(this, "Error",
//                   Toast.LENGTH_LONG).show();
//       }
//       return AllGames;
//   }



    private ArrayList<GameType> addItemsFromJSON() {
        ArrayList<GameType> AllGames = new ArrayList<GameType>();
        try {

            JSONArray array = new JSONArray(readJSON());

            for(int i=0;i<array.length();i++)
            {
                JSONObject jsonObject = array.getJSONObject(i);
                String GameTypeTitle = jsonObject.getString("list_title");
                String innertitle = "";
                String gameImageUrl = "";

                JSONArray GamesofGameType = jsonObject.getJSONArray("games");
                GameType gametype1 = new GameType();
                gametype1.listTitle = GameTypeTitle;
                gametype1.gameList = new ArrayList<Game>();

                for(int j=0;j<GamesofGameType.length();j++)
                {
                    JSONObject innerobject = GamesofGameType.getJSONObject(j);
                    innertitle = innerobject.getString("title");
                    gameImageUrl = innerobject.getString("img");

                    Game game1 = new Game();
                    game1.title = innertitle;
                    game1.imageUrl = gameImageUrl;
                    gametype1.gameList.add(game1);
                }
                AllGames.add(gametype1);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error",
                    Toast.LENGTH_LONG).show();
        }
        return AllGames;
    }

//    public String readAppJSON(){
//        String json = null;
//        String FileName = "MyAppJsonFile.json";
//
//
//
//        try {
//            InputStream inputStream = getAssets().open(FileName);
//            int size = inputStream.available();
//            byte[] buffer = new byte[size];
//            inputStream.read(buffer);
//            inputStream.close();
//            json = new String(buffer,"UTF-8");
//        } catch (IOException e) {
//            e.printStackTrace();
//            return json;
//        }
//        return json;
//    }

    public String readJSON(){

        String json = null;
        String FileName = "MyJsonFile.json";



        try {
            InputStream inputStream = getAssets().open(FileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return json;
        }
        return json;
    }
}