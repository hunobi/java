package serializers;

public class Player
{

    public Player(String nick, String URL, String profession, int level) {
        Nick = nick;
        this.URL = URL;
        Profession = profession;
        Level = level;
    }

    public String getNick() {
        return Nick;
    }

    public String getURL() {
        return URL;
    }

    public String getProfession() {
        return Profession;
    }

    public int getLevel() {
        return Level;
    }

    @Override
    public String toString() {
        return String.format("%s | %s LvL | %s | %s}",this.getNick(), this.getLevel(), this.getProfession(), this.getURL());
    }

    private final String Nick, URL, Profession;
    private final int Level;

}
