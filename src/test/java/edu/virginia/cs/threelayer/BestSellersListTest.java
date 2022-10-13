package edu.virginia.cs.threelayer;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BestSellersListTest {
    private BestSellersList testList;
    private Map<Integer, Book> mockMap;

    private static final Book gardensOfTheMoon = new Book("553812173", "Gardens Of The Moon", "Steve Erickson", 10);
    private static final Book deadhouseGates = new Book("0553813110", "Deadhouse Gates", "Steve Erickson", 5);

    @BeforeEach
    @SuppressWarnings("unchecked")
    void setUp() {
        mockMap = (Map<Integer, Book>) mock(Map.class);
        testList = new BestSellersList(mockMap);
    }

    @Test
    void testAddBook() {
        when(mockMap.containsKey(3)).thenReturn(false);
        testList.addBook(gardensOfTheMoon, 3);
        verify(mockMap).put(3, gardensOfTheMoon);
    }

    @Test
    void testAddBook_rankUsed() {
        when(mockMap.containsKey(3)).thenReturn(true);
        assertThrows(IllegalArgumentException.class, () -> testList.addBook(gardensOfTheMoon, 3));
    }

    @Test
    void testGetBook() {
        when(mockMap.containsKey(3)).thenReturn(true);
        when(mockMap.get(3)).thenReturn(gardensOfTheMoon);
        assertEquals(gardensOfTheMoon, testList.getBookByRank(3));
    }

    @Test
    void testMaxRank() {
        when(mockMap.keySet()).thenReturn(Set.of(1, 7, 3, 5));
        assertEquals(7, testList.getMaxRank());
    }

    @Test
    void testGetAllBooksInOrderOfRank() {
        when(mockMap.entrySet()).thenReturn(Set.of(Map.entry(2, gardensOfTheMoon), Map.entry(1, deadhouseGates)));
        List<Book> orderedBookList = testList.getAllBooksInOrderOfRank();
        assertEquals(deadhouseGates, orderedBookList.get(0));
        assertEquals(gardensOfTheMoon, orderedBookList.get(1));

    }

    @Test
    void testGetBook_BadRank() {
        assertThrows(IllegalArgumentException.class, () -> testList.getBookByRank(5));
    }
}