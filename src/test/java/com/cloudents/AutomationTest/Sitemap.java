package com.cloudents.AutomationTest;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import static com.cloudents.AutomationTest.Resources.Pages.*;
import static com.cloudents.AutomationTest.Resources.Drivers.*;




public class Sitemap extends CloudentsAutoTests {


    @Test
    public void dev() {

        URL url;
        HttpURLConnection http;
        int statusCode;
        driver.get(SITEMAP_PAGE);
        //Assert.assertNotNull(mainPage.urlSet);

        try {
            // Create xml document object with sitemap url
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new URL(SITEMAP_PAGE).openStream());
            doc.getDocumentElement().normalize();

            // Getting the inside url from nodes
            NodeList nList = doc.getElementsByTagName("loc");

            for(int i = 0 ; i < nList.getLength() ; i++) {

                // Reading the node's element and open its url
                Node nNode = nList.item(i);
                url = new URL(nNode.getTextContent());
                http = (HttpURLConnection)url.openConnection();
                System.out.println(url);

                // First, check if link is working
                statusCode = http.getResponseCode();
                if (statusCode != 200) {
                    System.out.println("HTTP status code: " + statusCode);
                    Assert.fail();
                }

                // Second, lets check the XML content of url
                Document insideDoc = dBuilder.parse(new URL(url.toString()).openStream());
                insideDoc.getDocumentElement().normalize();
                NodeList iList = insideDoc.getElementsByTagName("sitemap");


                for(int j = 0 ; j < iList.getLength() ; j++) {
                    Node iNode = iList.item(j);
                    NodeList ttt = iNode.getChildNodes();
                    System.out.println(iNode.getTextContent());
                    if (! iNode.hasChildNodes())
                        Assert.fail();
                }

            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }



        /*for(int i = 0 ; i < 5 ; i++) {
            url = new URL(SITEMAP_ITEM_PAGE[i]);
            http = (HttpURLConnection)url.openConnection();
            statusCode = http.getResponseCode();
            if (statusCode != 200) {
                System.out.println("HTTP status code: " + statusCode);
                Assert.fail();
            }
        }*/

    }

    @Test
    public void production() {

        URL url;
        HttpURLConnection http;
        int statusCode;
        driver.get(SITEMAP_PAGE_PROD);
        //Assert.assertNotNull(mainPage.urlSet);

        try {
            // Create xml document object with sitemap url
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new URL(SITEMAP_PAGE_PROD).openStream());
            doc.getDocumentElement().normalize();

            // Getting the root element
            /*Element element = doc.getElementById("urlset");
            Assert.assertTrue(element.hasAttribute("xmlns"));
            String attribute = element.getAttribute("xmlns");
            if (attribute != "http://www.sitemaps.org/schemas/sitemap/0.9")
                Assert.fail();*/

            // Getting the inside url from nodes
            NodeList nList = doc.getElementsByTagName("loc");

            for(int i = 0 ; i < nList.getLength() ; i++) {

                // Reading the node's element and open its url
                Node nNode = nList.item(i);
                url = new URL(nNode.getTextContent());
                http = (HttpURLConnection)url.openConnection();
                System.out.println(url);

                // First, check if link is working
                statusCode = http.getResponseCode();
                if (statusCode != 200) {
                    System.out.println("HTTP status code: " + statusCode);
                    Assert.fail();
                }

                // Second, lets check the XML content of url
                Document insideDoc = dBuilder.parse(new URL(url.toString()).openStream());
                insideDoc.getDocumentElement().normalize();
                NodeList iList = insideDoc.getElementsByTagName("sitemap");


                for(int j = 0 ; j < iList.getLength() ; j++) {
                    Node iNode = iList.item(j);
                    NodeList ttt = iNode.getChildNodes();
                    System.out.println(iNode.getTextContent());
                    if (! iNode.hasChildNodes())
                        Assert.fail();
                }

            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }



        /*for(int i = 0 ; i < 5 ; i++) {
            url = new URL(SITEMAP_ITEM_PAGE[i]);
            http = (HttpURLConnection)url.openConnection();
            statusCode = http.getResponseCode();
            if (statusCode != 200) {
                System.out.println("HTTP status code: " + statusCode);
                Assert.fail();
            }
        }*/

    }


}
