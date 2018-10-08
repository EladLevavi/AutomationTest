package com.cloudents.AutomationTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static com.cloudents.AutomationTest.Resources.*;

public class Sitemap extends CloudentsAutoTests {


    @Test
    public void sitemap() throws IOException {

        URL url;
        HttpURLConnection http;
        int statusCode;
        driver.get(SITEMAP_PAGE);
        Assert.assertNotNull(sitemapPage.urlSet);
        for(int i = 0 ; i < 5 ; i++) {
            url = new URL(SITEMAP_ITEM_PAGE[i]);
            http = (HttpURLConnection)url.openConnection();
            statusCode = http.getResponseCode();
            if (statusCode != 200) {
                System.out.println("HTTP status code: " + statusCode);
                Assert.fail();
            }
        }

    }


}
