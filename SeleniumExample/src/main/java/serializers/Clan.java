package serializers;

import java.util.ArrayList;
import java.util.List;

public class Clan
{

    public Clan(String name, String URL, int lvl) {
        Name = name;
        this.URL = URL;
        Level = lvl;
        Players = new ArrayList<>();
    }

    public String getName() {
        return Name;
    }

    public String getURL() {
        return URL;
    }

    public int getLevel(){ return Level; }

    public List<Player> getPlayers() {
        return Players;
    }

    @Override
    public String toString() {
        return String.format("%s | %s LvL | %s players | %s",this.getName(), this.Level ,this.getPlayers().size(), this.getURL());
    }

    private final String Name, URL;
    private final int Level;
    private final List<Player> Players;
}
