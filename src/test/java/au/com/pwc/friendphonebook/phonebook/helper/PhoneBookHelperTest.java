package au.com.pwc.friendphonebook.phonebook.helper;

import au.com.pwc.friendphonebook.phonebook.model.PhoneBookEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookHelperTest {

    private PhoneBookHelper phoneBookHelper;

    List<PhoneBookEntry> phoneBookEntries;

    @BeforeEach
    void setUp() {
        phoneBookHelper = new PhoneBookHelper();
        phoneBookEntries = new ArrayList<>();
        phoneBookEntries.add(new PhoneBookEntry("zen", "10101"));
        phoneBookEntries.add(new PhoneBookEntry("adam", "10102"));
        phoneBookEntries.add(new PhoneBookEntry("ben", "10103"));
    }

    @Test
    void shouldReturnCorrectFirstEntryAfterSort() {
        List<PhoneBookEntry> sortedPhoneBookEntries = phoneBookHelper.sortPhoneBookEntriesByFriend(phoneBookEntries);
        assertEquals("adam", sortedPhoneBookEntries.get(0).getFriendName());
    }

    @Test
    void shouldReturnCorrectSecondEntryAfterSort() {
        List<PhoneBookEntry> sortedPhoneBookEntries = phoneBookHelper.sortPhoneBookEntriesByFriend(phoneBookEntries);
        assertEquals("adam", sortedPhoneBookEntries.get(0).getFriendName());
    }

    @Test
    void shouldReturnCorrectThirdEntryAfterSort() {
        List<PhoneBookEntry> sortedPhoneBookEntries = phoneBookHelper.sortPhoneBookEntriesByFriend(phoneBookEntries);
        assertEquals("adam", sortedPhoneBookEntries.get(0).getFriendName());
    }

    @Test
    void getUniqueFriends() {
        Set<String> firstFriendSet = new HashSet<>();
        firstFriendSet.add("zen");
        firstFriendSet.add("adam");
        firstFriendSet.add("ben");
        firstFriendSet.add("ben");
        firstFriendSet.add("ben");

        Set<String> secondFriendSet = new HashSet<>();
        secondFriendSet.add("zen");
        secondFriendSet.add("phil");
        secondFriendSet.add("theo");

        assertEquals("adam,theo,ben,phil", String.join(",", phoneBookHelper.getUniqueFriends(firstFriendSet, secondFriendSet)));
    }

    @Test
    void shouldReturnCorrectFriends() {
        Set<String> friends = phoneBookHelper.getFriends(phoneBookEntries);
        assertEquals("zen,adam,ben", String.join(",", friends));
    }
}