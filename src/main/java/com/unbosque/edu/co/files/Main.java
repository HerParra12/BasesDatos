package com.unbosque.edu.co.files;

public class Main {
	
		
	public static void main(String[] args) {
		Ventana view = new Ventana();
		Persistencia persistencia = new Persistencia();
		try {
			int menu = 0;
			do {
				menu = view.leerDato("PARCIAL BASES DE DATOS." + 
					   "\n Selecciona la opción a realizar." + 
					   "\n 1. Cantida de registros que tiene el archivo." +
					   "\n 2. Cual es la sumatoria de los salarios." +
					   "\n 3. Cantidad de personas menores a 50." +
					   "\n 4. Promedio de edad de las personas entre 45 y 70" + 
					   "\n 0. Salir.");
				
				switch(menu) {	
					case 1:
						view.mostrarInformacion("La cantidad de resgistros es: " + persistencia.cantidadRegistros());
						break;
						
					case 2:
						view.mostrarInformacion("La sumatoria de los salarios es: " + persistencia.sumaSalarios());
						break;
						
					case 3:
						view.mostrarInformacion("La cantidad de personas menores a 50 es: " + persistencia.cantidadMenorCincuenta());
						break;
						
					case 4:
						view.mostrarInformacion("Promedio de edad de las personas entre 45 y 70 es: " + persistencia.promedioEdad());
						break;
						
					case 0:
						view.mostrarInformacion("Hasta luego");
						break;
						default:
							view.warningMessage("La opción ingresada no es valida.");
							break;
				}
			}while(menu != 0);
		} catch(Exception error) {
			view.errorMessage("Hubo un error!");
			main(args);
		}
	}
}
