package com.templestay.reservation;

import com.templestay.reservation.domain.temple.Temple;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Crawling {

    private final String url;
    private WebDriver driver;

    public Crawling(String url) {
        this.url = url;
    }

    public List<Temple> initProcess() {
        System.setProperty("webdriver.chrome.driver", "/Users/jang-yeji/대학/project/templestay/chromedriver");

        driver = new ChromeDriver();

        List<Temple> templeList = getTempleList();

        driver.close();
        driver.quit();

        return templeList;
    }

    public List<Temple> getTempleList() {
        List<Temple> templeList = new ArrayList<>();
        driver.get(url);    // 접속
        try {
            Thread.sleep(1000);     // url 접속시간 보장
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 1; i < 8; i++) {
            int templelinkCnt = 0;

            List<WebElement> ulElements = driver.findElements(By.className("meta-ul"));
            List<WebElement> templeLinks = driver.findElements(By.className("temple-link"));

            for (int j = 0; j < ulElements.size(); j++) {
                WebElement ulElement = ulElements.get(j);
                List<WebElement> li = ulElement.findElements(By.tagName("li"));
                WebElement nameAndAddress = li.get(0);
                String[] nameAndAddressSplit = nameAndAddress.getText().split(",");
                String name = nameAndAddressSplit[0];
                String address = nameAndAddressSplit[1];
                String contact = li.get(1).getText();
                String englishName = "";
                Long pageTempleId = null;

                for (int k = 0; k < 2; k++) {
                    String href = templeLinks.get(templelinkCnt).getAttribute("href");
                    int index = href.indexOf("=");
                    href = href.substring(index + 1);

                    if (k == 0) {
                        englishName = href;
                    } else {
                        pageTempleId = Long.valueOf(href);
                    }

                    templelinkCnt++;
                }

                Temple temple = new Temple(pageTempleId, name, englishName, address, contact);
                templeList.add(temple);
            }

            WebElement nextPage = driver.findElement(By.cssSelector("#content_LinkNext"));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            nextPage.click();    // page 클릭 후 로딩
        }
        return templeList;
    }
}
