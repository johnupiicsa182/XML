package Main;

import java.util.Scanner;

import org.w3c.dom.Document;

import Metodos.xml;

public class main {

	public static void main(String[] args) {
		Scanner teclado= new Scanner(System.in);
		xml xml=new xml();
		String name;
		String job;
		Integer salary;
		System.out.println("Nombre");
		name=teclado.next();
		System.out.println("Puesto");
		job=teclado.next();
		System.out.println("Salario");
		salary=teclado.nextInt();
		xml.crear(name, job, salary);
		
	}

}
