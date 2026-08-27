package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // 도서 추가
    public void addBook(Book book) {
        books.add(book);
        System.out.println("도서가 추가되었습니다: " + book.getTitle());
    }

    // 제목으로 검색
    public Book findByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }
    public Book findBookByTitle(String title) {
        return findByTitle(title);
    }

    // 저자로 검색
    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }
    public List<Book> findBooksByAuthor(String author) {
        return findByAuthor(author);
    }

    // ISBN으로 검색
    public Book findByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
    public Book findBookByISBN(String isbn) {
        return findByISBN(isbn);
    }

    // 도서 대출
    public boolean checkOutBook(String isbn) {
        Book book = findByISBN(isbn);
        if (book != null) {
            return book.checkOut();
        }
        return false;
    }

    // 도서 반납
    public boolean returnBook(String isbn) {
        Book book = findByISBN(isbn);
        if (book != null) {
            return book.returnBook();
        }
        return false;
    }

    // 대출 가능한 도서 목록
    public List<Book> getAvailableBooks() {
        List<Book> availableList = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableList.add(book);
            }
        }
        return availableList;
    }

    // 전체 도서 목록
    public List<Book> getAllBooks() {
        return books;
    }

    // 전체 도서 수
    public int getTotalBooks() {
        return books.size();
    }

    // 대출 가능한 도서 수
    public int getAvailableBooksCount() {
        return getAvailableBooks().size();
    }

    // 대출 중인 도서 수
    public int getBorrowedBooksCount() {
        return getTotalBooks() - getAvailableBooksCount();
    }
}