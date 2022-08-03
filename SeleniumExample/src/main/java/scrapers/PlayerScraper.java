package scrapers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import serializers.Player;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PlayerScraper implements IScraper<Player>
{
    public PlayerScraper(){
        Players = new ArrayList<>();
    }

    @Override
    public List<Player> Scrape(WebDriver driver, String url) {
        this.Players.clear();
        driver.get(url); // load page
        utils.WebDriverUtils.waitForPageLoad(driver, Duration.ofMillis(200));
        List<WebElement> playersContainer = driver
                .findElement(new By.ByXPath("/html/body/div[3]/div/div[4]/div[1]/div/div[4]/table/tbody"))
                .findElements(new By.ByTagName("tr"));

        for(WebElement el : playersContainer){
            WebElement tmp = el.findElement(new By.ByClassName("nick")).findElement(new By.ByTagName("a"));
            String player_name = tmp.getText();
            String player_url = tmp.getAttribute("href");
            tmp = el.findElement(new By.ByClassName("level"));
            int player_lvl = Integer.parseInt(tmp.getText());
            tmp = el.findElement(new By.ByClassName("prof"));
            String player_prof = tmp.getText();
            this.Players.add(new Player(player_name, player_url, player_prof, player_lvl));
        }
        return this.Players;
    }

    private final List<Player> Players;
}
