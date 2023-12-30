package test.phonebook;

import misc.PhoneBook;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasisTest {

	PhoneBook cut;
	
	@BeforeEach
	void setUp() throws Exception {
		cut = new PhoneBook();
		cut.addFriend("Alice", 11553);
		cut.addFriend("Bob", 257);
		cut.addFriend("Mallory", 6227);
		cut.addFriend("Emilia", 999);
	}

	@Test
	void init() {
	}

	@Test
	void getNumberFound() {
		assertEquals(6227, (int) cut.getNumber("Mallory"));
	}
	
	@Test
	void getNumberNotFound() {
		assertEquals(11833, (int) cut.getNumber("Sheep"));
	}
	
	@Test
	void getFriendsWithNumberEndingWithSeven() {
		Set<String> result = cut.getFriendsForLastPhoneNumberDigit(7);
		
		assertArrayEquals(
			new String[] {"Bob", "Mallory"},
			result.toArray(new String[0])
		);
	}
	
	@Test
	void friendWithMaxPhoneNumber() {
		assertEquals("Alice", cut.getFriendWithMaxPhoneNumber());
	}
	
}
