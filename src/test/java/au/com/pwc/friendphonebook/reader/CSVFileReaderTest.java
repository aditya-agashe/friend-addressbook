package au.com.pwc.friendphonebook.reader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVFileReaderTest {

    private static final int COLUMN_ONE = 0;
    private static final int COLUMN_TWO = 1;

    private List<String[]> rows;

    @BeforeEach
    void setUp() throws IOException {
        CSVFileReader csvFileReader = new CSVFileReader();
        rows = csvFileReader.readCSVRows("src\\test\\resources\\phonebook.csv");
    }

    @Test
    void shouldReturnCorrectNumberOfRows() {
        assertEquals(5, rows.size());
    }

    @Test
    void shouldReturnColumnCountAs1IfCSVRowIsEmpty() {
        assertEquals(1, rows.get(3).length);
    }

    @Test
    void shouldReturnFirstColumnAsEmptyIfCSVRowIsEmpty() {
        assertEquals("", rows.get(3)[COLUMN_ONE]);
    }

    @Test
    void shouldReturnOnlyOneColumnIfCSVRowHasNoCommas() {
        assertEquals(1, rows.get(4).length);
    }

    @Test
    void shouldReturnTwoColumnsIfCSVRowHasOneCommas() {
        assertEquals(2, rows.get(2).length);
    }

    @Test
    void shouldReturnSecondColumnAsEmptyThereIsNothingAfterFirstComma() {
        assertEquals("", rows.get(2)[COLUMN_TWO]);
    }

    @Test
    void shouldReturnCorrectNumberOfColumns() {
        assertEquals(2, rows.get(1).length);
    }

    @Test
    void shouldReturnCorrectColumnValueForFirstColumn() {
        assertEquals("zen", rows.get(1)[COLUMN_ONE]);
    }

    @Test
    void shouldReturnUntrimmedColumnValueForSecondColumn() {
        assertEquals(" 1212101", rows.get(1)[COLUMN_TWO]);
    }

    @Test
    void shouldReturnFirstColumnAsEmptyIfThereIsNoSpaceBeforComma() {
        assertEquals("", rows.get(0)[COLUMN_ONE]);
    }

    @Test
    void shouldReturnSecondColumnAsBlankIfThereIsABlankAfterComma() {
        assertEquals(" ", rows.get(0)[COLUMN_TWO]);
    }

    @Test
    void shouldReturnEmptyListIfFileIsEmpty() throws IOException {
        CSVFileReader csvFileReader = new CSVFileReader();
        assertEquals(0, csvFileReader.readCSVRows("src\\test\\resources\\phonebookempty.csv").size());
    }

}