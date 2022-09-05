package com.unbosque.edu.co.files;

import java.io.*;
import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Persistencia {
	
	private List <Persona> list;
	
	public Persistencia() {
		list = new ArrayList <> ();
		readListPerson();
	}
	
	public List <Persona> readListPerson() {
		try(ObjectInputStream stream = new ObjectInputStream(new FileInputStream("src/main/resources/archivos/Persona.dat"))){
			Persona person;
			try {
				while(true) {
					person = (Persona) stream.readObject();
					list.add(person);
				}
			} catch(EOFException fin) {}
		}catch(Exception error) {
			System.out.println("El archivo no se encontro");
		}
		return Collections.emptyList();
	}	
	
	public int cantidadRegistros() {
		return list.size();
	}
		
	public int sumaSalarios() {
		int sum = 0;
		for(Persona index : list)
			sum += index.getSalario();
		System.out.println("El salrio total es: " + sum);
		return list.stream()
				   .flatMapToInt(x -> IntStream.of(x.getSalario()))
				   .sum();
	}
		
	public long cantidadMenorCincuenta() {
		int counter = 0;
		for(Persona index : list)
			if(index.getEdad() < 50)
				counter ++;
		System.out.println("Cantidadd = " + counter);
		return list.stream()
				   .filter(persona -> persona.getEdad() < 50)
				   .count();
	}
		
	public double promedioEdad() {
		int counter = 0;
		double sum = 0;
		// ESTE LO USO PARA VERIFICAR QUE EL PROCESO ESTE BIEN
		for(Persona index : list) {
			if(index.getEdad() >= 45 && index.getEdad() <= 70) {
				sum += index.getEdad();
				counter ++;
			}
		}
		System.out.println("promedio = " + (sum / counter));
		return list.stream()
				   .filter(persona -> persona.getEdad() >= 45 && persona.getEdad() <= 70)
				   .flatMapToDouble(persona -> DoubleStream.of(persona.getEdad()))
				   .average()
				   .orElse(0);
	}	
}