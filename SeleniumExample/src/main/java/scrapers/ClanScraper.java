package scrapers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import serializers.Clan;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ClanScraper implements IScraper<Clan>
{
    public ClanScraper(){
        this.Clans = new ArrayList<>();
    }

    @Override
    public List<Clan> Scrape(WebDriver driver, String url) {
        this.Clans.clear();
        driver.get(url); // load page
        utils.WebDriverUtils.waitForPageLoad(driver, Duration.ofMillis(200));
        WebElement clansContainer = driver
                .findElement(new By.ByXPath("/html/body/div[3]/div/div[4]/div[1]/div/div"))
                .findElement(new By.ByTagName("tbody"));
        List<WebElement> clans_children = clansContainer.findElements(new By.ByTagName("tr"));
        for(WebElement el: clans_children){
            WebElement col = el
                    .findElement(new By.ByClassName("long-clan"))
                    .findElement(new By.ByTagName("a"));
            String clan_name = col.getText();
            String clan_url = col.getAttribute("href");
            col = el.findElement(new By.ByClassName("long-level"));
            int clan_lvl = Integer.parseInt(col.getText());
            this.Clans.add(new Clan(clan_name, clan_url, clan_lvl));
        }
        return this.Clans;
    }

    private final List<Clan> Clans;
}
