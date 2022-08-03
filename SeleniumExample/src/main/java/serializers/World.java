package serializers;

import java.util.ArrayList;
import java.util.List;

public class World
{
    public World(String name, String url) {
        Name = name;
        URL = url;
        Clans = new ArrayList<>();
    }

    public String getName() {
        return Name;
    }

    public List<Clan> getClans() {
        return Clans;
    }

    public String getURL() {
        return URL;
    }

    @Override
    public String toString() {
        return String.format("%s | %s clans | %s", this.getName(), this.Clans.size(), this.getURL());
    }

    private final String Name, URL;
    private final List<Clan> Clans;
}
