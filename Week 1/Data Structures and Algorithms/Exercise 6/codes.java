//Setup



public class Book {
    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}


//Implementation




public class Library {
    private Book[] books;
    private int size;

    public Library(int capacity) {
        this.books = new Book[capacity];
        this.size = 0;
    }

    public void addBook(Book book) {
        if (size == books.length) {
            System.out.println("Library is full. Cannot add more books.");
            return;
        }
        books[size++] = book;
    }

    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    
    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Library library = new Library(10);
        library.addBook(new Book(1, "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book(2, "1984", "George Orwell"));
        library.addBook(new Book(3, "The Great Gatsby", "F. Scott Fitzgerald"));

        System.out.println("Linear Search for '1984':");
        System.out.println(library.linearSearchByTitle("1984"));

        System.out.println("\nBinary Search for 'The Great Gatsby':");
        System.out.println(library.binarySearchByTitle("The Great Gatsby"));
    }
}