package au.com.pwc.friendphonebook.phonebook.parser;

import au.com.pwc.friendphonebook.phonebook.model.PhoneBookEntry;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CSVPhoneBookEntryParser {

    /**
     * This method parses the CSV Rows into a list of Phone Book Entries, if the first column of a row has a non-empty value.
     * Furthermore, the first column is mapped to friend name. The second column and onwards is mapped as comma separated phone numbers.
     * @param rows List of CSV Rows to be parsed
     * @return List of Phone Book Entries
     */
    public List<PhoneBookEntry> parse(List<String[]> rows) {
        List<PhoneBookEntry> phoneBookEntries = new ArrayList<>();
        rows.forEach(column -> {
            final boolean firstColumnIsNotEmpty = column.length > 0 && !column[0].trim().isEmpty();
            if (firstColumnIsNotEmpty) {
                String phoneNumbers = String.join(", ", Arrays.copyOfRange(column, 1, column.length));
                phoneNumbers = phoneNumbers.replaceAll("\\s+", " ").trim();
                phoneBookEntries.add(new PhoneBookEntry(column[0].trim(), phoneNumbers));
            }
        });
        return phoneBookEntries;
    }

}
