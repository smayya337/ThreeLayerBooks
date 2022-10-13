package edu.virginia.cs.threelayer;

import edu.virginia.cs.threelayer.data.ApiKeyFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ApiKeyFactoryTest {
    @Test
    public void getBestSellersAPI() {
        ApiKeyFactory factory = new ApiKeyFactory();
        assertNotNull(factory.getBestSellersAPIKey());
    }
}
