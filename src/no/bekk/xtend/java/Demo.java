package no.bekk.xtend.java;

import java.util.List;
import java.util.ArrayList;

public class Demo {
	public static void main(String[] args) {
		String[] navn = new String[] {"Holger Ludvigsen", "Hans Hansen", "Kari Karidatter", "Henrik Wingerei"};
		
		List<Person> braFolk = new ArrayList<Person>();
		for (String navnet : navn) {
			Person person = toPerson(navnet);
			
			if (person.getFornavn().startsWith("H")) {
				braFolk.add(person);
			}
		}
		
		System.out.println(braFolk);
		
		Person hans = toPerson(navn[1]);
		Person kari = toPerson(navn[2]); 
		
		Person gift = kari.addPerson(hans);
		System.out.println(gift);
		
	}
	
	private static Person toPerson(String str) {
		String[] split = str.split(" ");
		return new Person(split[0], split[1]);
	}
}

class Person {
	private String fornavn;
	private String etternavn;
	
	public Person(String fornavn, String etternavn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
	}
	
	public String toString() {
		return fornavn + " " + etternavn + " (" + fornavn.length() + ")";
	}
	
	public Person addPerson(Person p) {
		Person result = new Person(fornavn, p.etternavn);
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