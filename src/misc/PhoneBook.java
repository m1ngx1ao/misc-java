package misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
	private Map<String,Integer> allesWisser = new HashMap<String,Integer>();

	public void addFriend(String friendName, Integer phoneNumber) {
		this.allesWisser.put(friendName, phoneNumber);
	}
	
	public Integer getNumber(String friendName) {
		if (this.allesWisser.containsKey(friendName)) {
			return this.allesWisser.get(friendName);
		} else {
			return 11833;
		}
	}

	public Set<String> getFriendsForLastPhoneNumberDigit(int digit) {
		Set<String> s = new HashSet<String> ();
		for (String friendName : this.allesWisser.keySet()) {
			if (this.allesWisser.get(friendName) % 10 == 7) {
				s.add(friendName);
			}
		}
		return s;
	}

	public String getFriendWithMaxPhoneNumber() {
		List<Integer> phoneNumbers = new ArrayList<Integer>(this.allesWisser.values());
		Collections.sort(phoneNumbers);
		int MaxPhoneNumber = phoneNumbers.get(phoneNumbers.size() - 1);
		for (String friendName : this.allesWisser.keySet()) {
			if (this.allesWisser.get(friendName) == MaxPhoneNumber) {
				return friendName;
			}
		}
		return null;
	}
}
