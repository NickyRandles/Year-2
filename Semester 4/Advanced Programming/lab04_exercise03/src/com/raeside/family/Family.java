package com.raeside.family;

import java.util.Vector;

import com.raeside.exceptions.FirstNameExistsException;
import com.raeside.exceptions.SurnameMismatchException;

public class Family {

		private Vector familyMembers = new Vector();
		private String familyName;
		
		public Family(String familyName) {
			this.familyName = familyName;
		}
		
		public void addFamilyMember(Person member) throws FirstNameExistsException, SurnameMismatchException {
			
			if(newFirstName(member.getFirstName()) && correctFamilyName(member.getFamilyName())) {
				familyMembers.addElement(member);
			}
			
			else if(newFirstName(member.getFirstName()) == false)
			{	
				throw new FirstNameExistsException("This family already has a " + member.getFirstName());
			}
			
			else if(correctFamilyName(member.getFamilyName()) == false)
			{
				throw new SurnameMismatchException("You must have surname Robinson to join this family");
			}
						
		}
		
		public String[] getFamilyMembers() {
			
			String[] names=new String[familyMembers.size()];
			
			for(int i=0; i < familyMembers.size(); i++) {
				names[i]=((Person)familyMembers.elementAt(i)).getFirstName() + " " + ((Person)familyMembers.elementAt(i)).getFamilyName();
			}
			return names;
		}
		
		public boolean newFirstName(String firstName) {
			
			for(int i=0; i < familyMembers.size(); i++) {
				if(((Person)familyMembers.elementAt(i)).getFirstName().equals(firstName)) {
					return false; //name is not new to the family
				}
			}
			return true; //the name was not found
		}
		
		public boolean correctFamilyName(String familyName) {
			
			if(familyName.equals(this.familyName)) {
				return true; //family name is correct
			}
			return false; //person's family name doesnot match
		}
}
