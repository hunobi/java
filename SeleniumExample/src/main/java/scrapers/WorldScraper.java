package scrapers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import serializers.World;

import java.util.ArrayList;
import java.util.List;
import utils.WebDriverUtils;

import java.time.Duration;

public class WorldScraper implements IScraper<World>
{
    private final List<World> Worlds;

    @Override
    public List<World> Scrape(WebDriver driver, String url) {
        driver.get(url); // load page
        WebDriverUtils.waitForPageLoad(driver, Duration.ofMillis(200)); // wait for page loaded
        // get clan button and go to url
        WebElement clanButton = driver.findElement(new By.ByXPath("/html/body/div/div/div[4]/div/div[2]/a[2]"));
        driver.get(clanButton.getAttribute("href"));
        WebDriverUtils.waitForPageLoad(driver, Duration.ofMillis(200)); // wait for page loaded
        // get item container and get children, from children get name and url
        WebElement container = driver.findElement(new By.ByXPath("/html/body/div/div/div[4]/div/div[3]"));
        List<WebElement> children = container.findElements(new By.ByClassName("ranking-container"));
        for(WebElement el : children){
            WebElement nameEl = el.findElement(new By.ByClassName("header-underline"));
            String name_world = nameEl.getText().replace("Ranking klanów", " ").strip();
            WebElement urlEl = el.findElement(new By.ByClassName("btn"));
            String url_world = urlEl.getAttribute("href");
            this.Worlds.add(new World(name_world, url_world));
        }
        return this.Worlds;
    }

    public WorldScraper() {
        Worlds = new ArrayList<>();
    }
}
