package edu.virginia.cs.threelayer;

import java.util.*;
import java.util.stream.Collectors;

public class BestSellersList {
    private Map<Integer, Book> bestSellers;

    public BestSellersList() {
        this(new HashMap<Integer, Book>());
    }

    public BestSellersList(Map<Integer, Book> bestSellers) {
        this.bestSellers = bestSellers;
    }

    public void addBook(Book book, int rank) {
        if (bestSellers.containsKey(rank)) {
            throw new IllegalArgumentException("A book of that rank has already been specified - " + rank + "." + book);
        }
        bestSellers.put(rank, book);
    }

    public Book getBookByRank(int rank) {
        if (!bestSellers.containsKey(rank)) {
            throw new IllegalArgumentException("Rank doesn't exist in BestSellerList" + rank);
        }
        return bestSellers.get(rank);
    }

    public int getMaxRank() {
        OptionalInt maxRank = bestSellers.keySet().stream()
                .mapToInt(x -> x)
                .max();
        if (maxRank.isEmpty()) {
            throw new IllegalStateException("Error: Empty BestSellersList");
        }
        return maxRank.getAsInt();
    }

    public List<Book> getBooks() {
        return new ArrayList<>(bestSellers.values());
    }

    public List<Book> getAllBooksInOrderOfRank() {
        return bestSellers.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .toList();
    }
}
