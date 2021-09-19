 // Figura 8.11: EnumTest.java
         // Testando o tipo enum Book.
         import java.util.EnumSet;

         public class EnumTest
 {
         public static void main(String[] args)
         {
         System.out.println("All books:");

         // imprime todos os livros em enum Book
         for (Book book : Book.values())
         System.out.printf("%-10s%-45s%s%n", book,
         book.getTitle(),book.getCopyrightYear());

         System.out.printf("%nDisplay a range of enum constants:%n");

         // imprime os primeiros quatro livros
         for (Book book : EnumSet.range(Book.JHTP, Book.CPPHTP))
         System.out.printf("%-10s%-45s%s%n", book,
         book.getTitle(),book.getCopyrightYear());
         }
         } // fim da classe EnumTest
