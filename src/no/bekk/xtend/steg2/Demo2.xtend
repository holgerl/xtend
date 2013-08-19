package no.bekk.xtend.steg2

public class Demo2 {	
	def static void main(String[] args) {
		val navn = #["Holger Ludvigsen", "Hans Hansen", "Kari Karidatter", "Henrik Wingerei"]
		
		val braFolk = navn.map[toPerson].filter[it.fornavn.startsWith('H')]
		println(braFolk)
		
		val ola = navn.get(1).toPerson
		val kari = navn.get(2).toPerson
	}
	
	def static toPerson(String str) {
		val split = str.split(" ")
		new Person(split.get(0), split.get(1))
	}
}

@Data
class Person {
	String fornavn
	String etternavn
	
	override toString() {
		fornavn + " " + etternavn
	}
}