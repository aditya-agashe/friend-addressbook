package au.com.pwc.friendphonebook.console.helper;

import au.com.pwc.friendphonebook.phonebook.helper.PhoneBookHelper;
import au.com.pwc.friendphonebook.phonebook.model.PhoneBookEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class ConsolePrintHelper {

    @Autowired
    private PhoneBookHelper phoneBookHelper;

    /**
     * This method prints the Sorted Phone Book Entries on the Console.
     * @param header The Header to be printed before the Sorted Entries
     * @param phoneBookEntries List of the unsorted Phone Book Entries to be printed
     */
    public void printSortedPhoneBookEntries(String header, List<PhoneBookEntry> phoneBookEntries) {
        phoneBookEntries = phoneBookHelper.sortPhoneBookEntriesByFriend(phoneBookEntries);
        String s = phoneBookEntries.stream().map(paper -> ("Name: " + paper.getFriendName() + "  Phone Numbers: " + paper.getPhoneNumbers())).collect(Collectors.joining("\n"));
        System.out.println(header);
        System.out.println(s);
    }

    /**
     * This method prints list of unique friend names on the Console from the two lists.
     * @param phoneBooksFirstRunEntry First List of Phone Book Entries
     * @param phoneBooksSecondRunEntry Second List of Phone Book Entries
     */
    public void printUniqueFriends(List<PhoneBookEntry> phoneBooksFirstRunEntry, List<PhoneBookEntry> phoneBooksSecondRunEntry) {
        Set<String> uniqueFriends = phoneBookHelper.getUniqueFriends(
                phoneBookHelper.getFriends(phoneBooksFirstRunEntry), phoneBookHelper.getFriends(phoneBooksSecondRunEntry));
        String s = uniqueFriends.stream().map(name -> ("Name:" + name)).collect(Collectors.joining("\n"));
        System.out.println("Unique List");
        System.out.println(s);
    }

}
