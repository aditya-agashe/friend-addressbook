# Friend Address Book 
This application allows the user to input the CSV file paths from the console. The CSV files will have a list comma separated friend names and their phone numbers.
The program then prints the list of sorted phone book entries by friend name and list of unique friends.

## Design Decisions

### Requirements
You have been asked to develop an phone book that allows a user to store (between
successive runs of the program) the name and phone numbers of their friends, with the
following functionality:

- To be able to display the list of friends and their corresponding phone numbers sorted
by their name.
- Given another phone book that may or may not contain the same friends, display the
list of friends that are unique to each phone book (the union of all the relative
complements). For example given:
    - Book1 = { “Bob”, “Mary”, “Jane” }
    - Book2 = { “Mary”, “John”, “Jane” }
    - The friends that are unique to each address book are:
    - Book1 \ Book2 = { “Bob”, “John” }


### Assumptions
- A phone book can be empty
- A phone book can have two friends with the same name. But they will be treated as one individual when listed for uniqueness.


### Rules
- The first column in CSV row has been mapped to friend name. e.g "Bob"
- The second column and onwards has been mapped as comma separated phone numbers. e.g. "0404040, 0505050"
- If a CSV record in the phone book is empty or if the first column is blank or empty the CSV record will be ignored.
- There is no check on whether the phone numbers are empty or they are numbers.


### Descoped
- Containerisation 


## Application
This solution has been implemented using spring boot.


### Prerequisites
- Java 1.8
- Maven 3.x. Classpath is setup
- IDE or commad line tool. IntelliJ was used while development. 


### Build
cd <checked out project path>
mvn clean package
The jar will be in folder <checked out project path>\target


### Run
cd <checked out project path>
mvn spring-boot:run
Pass the absolute path to CSV phone book files when prompted
Please refer to sample file phonebook1.csv under src > test > resources

