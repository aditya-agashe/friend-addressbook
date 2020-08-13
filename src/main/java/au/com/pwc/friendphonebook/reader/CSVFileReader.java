package au.com.pwc.friendphonebook.reader;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Component
public class CSVFileReader {

    /**
     * This method reads the Rows from the CSV file from the passed location.
     * An IOException will be thrown if the path does not exists or if an error occurs while reading the file.
     * @param csvFilePath Path to the CSV file to be read
     * @return List of CSV Rows
     * @throws IOException
     */
    public List<String[]> readCSVRows(String csvFilePath) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(csvFilePath));
        return reader.readAll();
    }
}
