package au.com.pwc.friendphonebook.console.helper;

import au.com.pwc.friendphonebook.reader.CSVFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleReadHelper {

    @Autowired
    private CSVFileReader csvFileReader;

    /**
     * This method returns List of CSV Rows from the file. The file path is input by the user.
     * This method does not exit until the file is read.
     * @param message Prompt message which is to be printed on the Console
     * @return List of CSV Rows from the file
     */
    public List<String[]> readCSVRows(String message) {
        Scanner scanner = new Scanner(System.in);
        List<String[]> rows = new ArrayList<>();
        boolean read = false;
        while (!read) {
            System.out.println(message);
            String filePath = scanner.nextLine();
            try {
                // Delegate the job of reading the file to another class. Pass the file path.
                rows = csvFileReader.readCSVRows(filePath);
                read = true;
            } catch (IOException io) {
                System.out.println("Error occurred while reading the file: " + filePath);
            }
        }
        return rows;
    }

}
