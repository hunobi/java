import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import scrapers.ClanScraper;
import scrapers.IScraper;
import scrapers.PlayerScraper;
import scrapers.WorldScraper;
import serializers.Clan;
import serializers.Player;
import serializers.World;

import java.util.List;

class Main
{

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","C:/selenium/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        IScraper<World> worldScraper = new WorldScraper();
        List<World> worlds = worldScraper.Scrape(driver, "https://www.margonem.pl/ladder");
        IScraper<Clan> clanScraper = new ClanScraper();
        IScraper<Player> playerScraper = new PlayerScraper();
        for(World el : worlds){
            el.getClans().addAll(clanScraper.Scrape(driver, el.getURL()));
            for(Clan cl : el.getClans()){
                cl.getPlayers().addAll(playerScraper.Scrape(driver, cl.getURL()));
            }
        }
    }
}
