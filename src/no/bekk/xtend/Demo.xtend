package no.bekk.xtend

import static extension no.bekk.xtend.Persistence.*

public class Demo {	
	def static void main(String[] args) {
		val navn = #["Holger Ludvigsen", "Hans Hansen", "Kari Karidatter", "Henrik Wingerei"]
		
		val braFolk = navn.map[toPerson].filter[it.fornavn.startsWith('H')]
		println(braFolk)
		
		val ola = navn.get(1).toPerson
		val kari = navn.get(2).toPerson
		
		val gift = kari + ola
		println(gift)
		
		ola.save
	}

	def static toPerson(String str) {
		val split = str.split(" ")
		new Person(split.get(0), split.get(1))
	}
}

class Persistence {
	def static save(Person p) {
		println(p.fornavn + " saved to database")
	}
}

@Data
class Person {
	String fornavn
	String etternavn
	
	override toString() {
		fornavn + " " + etternavn
	}
	
	def operator_plus(Person p) {
		new Person(this.fornavn, p.etternavn);
	}
}