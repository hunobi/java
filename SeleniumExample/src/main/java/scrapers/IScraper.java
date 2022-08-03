package scrapers;

import org.openqa.selenium.WebDriver;

import java.util.List;

public interface IScraper<T>
{
    public List<T> Scrape(WebDriver driver, String url);
}
