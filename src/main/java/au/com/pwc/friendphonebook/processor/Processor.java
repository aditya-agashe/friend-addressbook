package au.com.pwc.friendphonebook.processor;

import au.com.pwc.friendphonebook.phonebook.parser.CSVPhoneBookEntryParser;
import au.com.pwc.friendphonebook.console.helper.ConsolePrintHelper;
import au.com.pwc.friendphonebook.console.helper.ConsoleReadHelper;
import au.com.pwc.friendphonebook.phonebook.model.PhoneBookEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Component
public class Processor {

    @Autowired
    private ConsoleReadHelper consoleReadHelper;

    @Autowired
    private CSVPhoneBookEntryParser csvPhoneBookEntryParser;

    @Autowired
    private ConsolePrintHelper consolePrintHelper;

    /**
     * This method delegates, the job to other classes. For example:
     * Get the CSV Rows from the user input file
     * Parse the CSV Rows to List of Phone Book Entries
     * Print List of sorted Phone Book Entries
     * Print List of Unique Friends
     */
    public void process() {
        while (true) {
            // Get the CSV Rows from the user input file
            List<String[]> initialCSVRows = consoleReadHelper.readCSVRows("Please enter the path of the first CSV file: ");
            List<String[]> finalCSVRows = consoleReadHelper.readCSVRows("Please enter the path of the second CSV file: ");

            // Parse the CSV Rows to List of Phone Book Entries
            List<PhoneBookEntry> initialPhoneBookEntries = csvPhoneBookEntryParser.parse(initialCSVRows);
            List<PhoneBookEntry> finalPhoneBookEntries = csvPhoneBookEntryParser.parse(finalCSVRows);

            // Print
            consolePrintHelper.printSortedPhoneBookEntries("First List", initialPhoneBookEntries);
            consolePrintHelper.printSortedPhoneBookEntries("Second List", finalPhoneBookEntries);
            consolePrintHelper.printUniqueFriends(initialPhoneBookEntries, finalPhoneBookEntries);
        }
    }

}
