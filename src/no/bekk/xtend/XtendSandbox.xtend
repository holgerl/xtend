package no.bekk.xtend

import java.util.List
import java.util.Scanner

class XtendSandbox {
	def static void main(String[] args) {
		val Scanner in = new Scanner(System.in);
      	println("Enter a string");
      	val s = in.nextLine();
      	
		val List list = if (args.isEmpty) #[1, 2] else args
		
		println(list.get(0) + s)
	}
}