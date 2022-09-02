public class Main {
	
	private static Ventana view;
	
	public Main() {
		view = new Ventana();
	}
	
	public static void main(String[] args) {
		try {
			int menu = 0;
			do {
				menu = view.leerDato("PARCIAL BASES DE DATOS." + 
					   "\n Selecciona la opción a realizar." + 
					   "\n 1. " +
					   "\n 2. " +
					   "\n 0. Salir.");
				
				switch(menu) {
					case 1:
						
						break;
						
					case 2:
						
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
