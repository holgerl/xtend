package no.bekk.xtend;

import java.util.List;
import java.util.ArrayList;

public class DemoJava {
	public static void main(String[] args) {
		String[] navn = new String[] {"Holger Ludvigsen", "Ola Nordmann", "Kari Olsen", "Henrik Wingerei"};
		
		List<PersonJava> braFolk = new ArrayList<PersonJava>();
		for (String navnet : navn) {
			String[] split = navnet.split(" ");
			PersonJava person = new PersonJava(split[0], split[1]);
			
			if (person.getFornavn().startsWith("H")) {
				braFolk.add(person);
			}
		}
		
		System.out.println(braFolk);
		
		PersonJava ola = toPerson(navn[1]);
		PersonJava kari = toPerson(navn[2]); 
		
		PersonJava gift = kari.addPerson(ola);
		System.out.println(gift);
		
		PersistenceJava.save(ola);
	}
	
	private static PersonJava toPerson(String str) {
		String[] split = str.split(" ");
		return new PersonJava(split[0], split[1]);
	}
}

class PersistenceJava {
	public static void save(PersonJava p) {
		System.out.println(p.getFornavn() + " saved to database");
	}
}

class PersonJava {
	private String fornavn;
	private String etternavn;
	
	public PersonJava(String fornavn, String etternavn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
	}
	
	public String toString() {
		return fornavn + " " + etternavn;
	}
	
	public PersonJava addPerson(PersonJava p) {
		PersonJava result = new PersonJava(fornavn, p.etternavn);
		return result;
	}
	
	public String getFornavn() {
		return fornavn;
	}
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}
	public String getEtternavn() {
		return etternavn;
	}
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}
}