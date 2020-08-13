package au.com.pwc.friendphonebook.phonebook.parser;

import au.com.pwc.friendphonebook.phonebook.model.PhoneBookEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVPhoneBookEntryParserTest {

    private CSVPhoneBookEntryParser csvPhoneBookEntryParser;

    private List<String[]> rows = new ArrayList<>();

    @BeforeEach
    void setUp() {
        csvPhoneBookEntryParser = new CSVPhoneBookEntryParser();
        rows.add(new String []{"adam"});
        rows.add(new String []{"pete", ""});
        rows.add(new String []{"zen", "  1212101", "  1212102"});
        rows.add(new String []{" ", " ", " "});
        rows.add(new String []{});
    }

    @Test
    void shouldNotParseEntryIfRowIsEmptyORIfFirstColumnIsBlank() {
        List<PhoneBookEntry> phoneBookEntries = csvPhoneBookEntryParser.parse(rows);
        assertEquals(3, phoneBookEntries.size());
    }

    @Test
    void shouldMapFirstColumnToFriendName() {
        List<PhoneBookEntry> phoneBookEntries = csvPhoneBookEntryParser.parse(rows);
        assertEquals("adam", phoneBookEntries.get(0).getFriendName());
    }

    @Test
    void shouldMapSecondColumnToPhoneNumber() {
        List<PhoneBookEntry> phoneBookEntries = csvPhoneBookEntryParser.parse(rows);
        assertEquals("", phoneBookEntries.get(1).getPhoneNumbers());
    }

    @Test
    void shouldMapSecondColumnOnwardsToPhoneNumbers() {
        List<PhoneBookEntry> phoneBookEntries = csvPhoneBookEntryParser.parse(rows);
        assertEquals("1212101, 1212102", phoneBookEntries.get(2).getPhoneNumbers());
    }

    @Test
    void shouldReturnEmptyParsedListIfCSVRowListIsEmpty() {
        List<PhoneBookEntry> phoneBookEntries = csvPhoneBookEntryParser.parse(new ArrayList<>());
        assertTrue(phoneBookEntries.isEmpty());
    }

}