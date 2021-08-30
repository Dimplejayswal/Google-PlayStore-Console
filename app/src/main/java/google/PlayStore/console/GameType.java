package google.PlayStore.console;

import java.util.ArrayList;

public class GameType {
    public String listTitle;
    public String listimageUrl;
    public ArrayList<Game> gameList;



    public String getListTitle() {
        return listTitle;
    }

    public void setListTitle(String listTitle) {
        this.listTitle = listTitle;
    }

    public String getListimageUrl() {
        return listimageUrl;
    }

    public void setListimageUrl(String listimageUrl) {
        this.listimageUrl = listimageUrl;
    }
}
