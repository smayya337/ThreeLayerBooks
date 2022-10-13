package edu.virginia.cs.threelayer.data;

import edu.virginia.cs.threelayer.ListName;
import edu.virginia.cs.threelayer.data.BestSellersApi;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BestSellersAPITest {
    @Test
    public void testGetCurrentBestSellers() {
        BestSellersApi api = new BestSellersApi();
        JSONObject object = api.getCurrentBestSellers(ListName.COMBINED_FICTION);
        assertNotNull(object);
    }
}
