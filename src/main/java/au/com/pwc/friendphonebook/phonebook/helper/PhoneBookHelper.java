package au.com.pwc.friendphonebook.phonebook.helper;

import au.com.pwc.friendphonebook.phonebook.model.PhoneBookEntry;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PhoneBookHelper {

    /**
     * @param phoneBookEntries Phone Book Entries to be sorted by ascending friend names
     * @return List of Sorted Phone Book Entries by ascending friend names
     */
    public List<PhoneBookEntry> sortPhoneBookEntriesByFriend(List<PhoneBookEntry> phoneBookEntries) {
        List<PhoneBookEntry> sortedPhoneBookEntry = phoneBookEntries.stream()
                .sorted(Comparator.comparing(PhoneBookEntry::getFriendName))
                .collect(Collectors.toList());
        return sortedPhoneBookEntry;
    }

    /**
     * This method returns the unique set of friend names from the passed two sets.
     * @param initialFriends First set of friends
     * @param finalFriends Second set of friends
     * @return Unique set of friend names
     */
    public Set<String> getUniqueFriends(Set<String> initialFriends, Set<String> finalFriends) {
        Set<String> uniqueInFirst = new HashSet<>(initialFriends);
        uniqueInFirst.removeAll(finalFriends);
        Set<String> uniqueInSecond = new HashSet<>(finalFriends);
        uniqueInSecond.removeAll(initialFriends);
        uniqueInFirst.addAll(uniqueInSecond);
        return uniqueInFirst;
    }

    /**
     * This method returns a set of unique friends from the list of phone book entries
     * @param phoneBookEntries
     * @return Set of Unique Friends
     */
    public Set<String> getFriends(List<PhoneBookEntry> phoneBookEntries) {
        return phoneBookEntries.stream().map(PhoneBookEntry::getFriendName).collect(Collectors.toSet());
    }
}
