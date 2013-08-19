package no.bekk.xtend.steg1

public class Demo1 {	
	def static void main(String[] args) {
		val navn = #["Holger Ludvigsen", "Hans Hansen", "Kari Karidatter", "Henrik Wingerei"]
		
		val braFolk = navn.map[
			val split = it.split(" ")
			new Person(split.get(0), split.get(1))
		].filter[it.fornavn.startsWith('H')]
			
		println(braFolk)
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