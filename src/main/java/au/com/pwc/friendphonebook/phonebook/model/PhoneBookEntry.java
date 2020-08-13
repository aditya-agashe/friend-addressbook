package au.com.pwc.friendphonebook.phonebook.model;

/**
 * This is a normal pojo made up of friend name and comma separated friend's phone numbers
 */
public class PhoneBookEntry {

    private String friendName;
    private String phoneNumbers;

    public PhoneBookEntry(String friendName, String phoneNumbers) {
        this.friendName = friendName;
        this.phoneNumbers = phoneNumbers;
    }

    public String getFriendName() {
        return friendName;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }
}
