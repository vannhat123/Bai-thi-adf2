/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nhat
 */
public class CollectionBook {

    public static void main(String[] args) throws IOException {
        CollectionBook collectionBook = new CollectionBook();
        //  collectionBook.printFile();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Quản lý book");
            System.out.println("1. Add book records");
            System.out.println("2. Save");
            System.out.println("3. Display book rercords");
            System.out.println("4. Exit");
            System.out.println("Vui lòng nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    collectionBook.generateBook();
                    break;
                case 2:
                    collectionBook.saveToFile();
                    break;
                case 3:
                    collectionBook.printFile();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    private ArrayList<Book> listBook;

    public ArrayList<Book> getListBook() {
        return listBook;
    }

    public void setListBook(ArrayList<Book> listBook) {
        this.listBook = listBook;
    }

    private void generateBook() {
        listBook = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Book Ip:");
        String bookId = sc.nextLine();
        System.out.println("Enter Book Name:");
        String bookName = sc.nextLine();
        System.out.println("Enter Author: ");
        String bookAuthor = sc.nextLine();
        System.out.println("Enter Price: ");
        String bookPrice = sc.nextLine();
        Book book = new Book(bookId, bookName, bookAuthor, bookPrice);
        listBook.add(book);
    }

    public void saveToFile() throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("books.dat");
        OutputStreamWriter osw = new OutputStreamWriter(fos, Charset.forName("utf-8"));
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write(" Book ID \t |\t Book Name \t \t \t \t |\t Author \t |\t Price");
        bw.newLine();
        bw.write("--------------------------------------------------------------------------------------------------------");
        bw.newLine();
        for (int i = 0; i < listBook.size(); i++) {
            Book book = listBook.get(i);
            bw.write(String.format("%2s", ("\t")));
            bw.write(book.getBookID());
            bw.write(String.format("%2s", ("\t | \t")));
            bw.write(book.getBookName());
            bw.write(String.format("%2s", ("\t | \t")));
            bw.write(book.getAuthor());
            bw.write(String.format("%5s", ("\t | \t")));
            bw.write(book.getPrice());
            bw.newLine();
        }
        bw.write("---------------------------------------------------------------------------------------------------------");
        bw.newLine();
        bw.newLine();
        bw.close();
        osw.close();
        fos.close();
    }

    public void printFile() {
        try {
            FileInputStream fis = new FileInputStream("books.dat");
            InputStreamReader isw = new InputStreamReader(fis, Charset.forName("utf-8"));
            BufferedReader br = new BufferedReader(isw);
            StringBuilder mycontent = new StringBuilder();
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                mycontent.append(inputLine);
                mycontent.append("\n");
                System.out.println(mycontent.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
