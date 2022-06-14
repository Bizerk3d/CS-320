/*
 * Brennan Reed
 * SNHU CS320
 * 5/22/22
 * Contact Service class for Milestone
 */
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {
	private String uniqueId;
	private List <Contact> contactList = new ArrayList<>();
	
	// code for creating random 10 digit id
	{
		uniqueId = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}
	
	// only id
	public void newContact() {
		Contact contact = new Contact(newUniqueId());
		contactList.add(contact);
	}

	// id and first name
	public void newContact(String firstName) {
		Contact contact = new Contact(newUniqueId(), firstName);
		contactList.add(contact);
	}
	
	// id, first name, last name
	public void newContact(String firstName, String lastName) {
		Contact contact = new Contact(newUniqueId(), firstName, lastName);
		contactList.add(contact);
	}
	
	// id, first name, last name, phone number
	public void newContact(String firstName, String lastName, String phoneNumber) {
		Contact contact = new Contact(newUniqueId(), firstName, lastName, phoneNumber);
		contactList.add(contact);
	}
	
	// id, first name, last name, phone number, and address
	public void newContact(String firstName, String lastName, String phoneNumber,String address) {
		Contact contact = new Contact(newUniqueId(), firstName, lastName, phoneNumber, address);
		contactList.add(contact);
	}
	
	public void deleteContact(String id) throws Exception{
		contactList.remove(searchForContact(id));
	}
	
	public void updateFirstName(String id, String firstName) throws Exception {
		searchForContact(id).updateFirstName(firstName);	
	}
	
	public void updateLastName(String id, String lastName) throws Exception {
		searchForContact(id).updateLastName(lastName);
	}
	
	public void updatePhoneNumber(String id, String phoneNumber) throws Exception {
		searchForContact(id).updatePhoneNumber(phoneNumber);
	}
	
	public void updateAddress(String id, String address) throws Exception {
		searchForContact(id).updateAddress(address);
	}
	
	protected List<Contact> getContactList() {
		return contactList;
	}
	
	private String newUniqueId() {
		return uniqueId = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}
	
	// uses unique id to find contact
	private Contact searchForContact(String id) throws Exception {
		int index = 0;
		while (index < contactList.size()) {
			if (id.equals(contactList.get(index).getContactId())) {
				return contactList.get(index);
			}
			index++;
		}
		throw new Exception("Can't do that here!");
	}
}
