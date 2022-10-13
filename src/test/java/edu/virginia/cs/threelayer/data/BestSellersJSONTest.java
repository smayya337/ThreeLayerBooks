package edu.virginia.cs.threelayer.data;

import edu.virginia.cs.threelayer.BestSellersList;
import edu.virginia.cs.threelayer.Book;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestSellersJSONTest {
    BestSellersJSON testBestSellerJSON;

    @BeforeEach
    public void setup() {
        testBestSellerJSON = new BestSellersJSON();
    }

    @Test
    public void testGetBookFromJSON() {
        JSONObject testBookJson = getExampleBookJSON();
        Book book = testBestSellerJSON.getBookFromJSON(testBookJson);
        assertEquals("0593422481", book.getIsbn());
        assertEquals("RIGHTEOUS PREY", book.getTitle());
        assertEquals("John Sandford", book.getAuthorName());
        assertEquals(1, book.getWeeksOnList());
    }

    @Test
    public void testGetListFromJSON() {
        JSONObject testListJson = getExampleBestSellerListJSON();
        BestSellersList bestSellersList = testBestSellerJSON.getBestSellerList(testListJson);
        assertEquals(15, bestSellersList.getMaxRank());
        assertEquals("RIGHTEOUS PREY", bestSellersList.getBookByRank(1).getTitle());
        assertEquals("THE SILENT PATIENT", bestSellersList.getBookByRank(15).getTitle());
    }


    private JSONObject getExampleBookJSON() {
        try {
            String bookJsonString = getStringFromTestResource("/example_book.json");
            return new JSONObject(bookJsonString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private JSONObject getExampleBestSellerListJSON() {
        try {
            String bookJsonString = getStringFromTestResource("/example_bestseller_list.json");
            return new JSONObject(bookJsonString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getStringFromTestResource(String fileName) throws IOException {
        String resourceFile = BestSellersJSONTest.class.getResource(fileName).getFile();
        InputStream is = new FileInputStream(resourceFile);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder builder = new StringBuilder();
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            builder.append(line);
        }
        return builder.toString();
    }
}