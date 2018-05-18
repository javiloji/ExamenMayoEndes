package examenFinalEnDes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestCCuenta {
	private static int opcion;

	public static void main(String[] args) {
		BufferedReader dato = new BufferedReader(new InputStreamReader(
				System.in));
		CCuenta Javier;

		opcion = 0;
		Javier = new CCuenta("Rigoberta Piedra", "0000-6523-85-678912345",
				2500, 0);
		do {
			try {
				opcion = mostrarMenu(dato);

				recogerOpcion(dato, Javier, opcion);
			} catch (IOException ex) {
				Logger.getLogger(TestCCuenta.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		} while (opcion != 3);
		System.out.println("Saldo actual: " + Javier.estado());
	}

	private static void recogerOpcion(BufferedReader dato, CCuenta cuenta1, int opcion) throws IOException {
		switch (opcion) {
		case 1:
			System.out.println("Indica cantidad a ingresar: ");
			float ingresar = Integer.parseInt(dato.readLine());
			try {
				System.out.println("Ingreso en cuenta");
				ingresar(cuenta1, ingresar);
			} catch (Exception e) {
				System.out.print("Fallo al ingresar");
			}
			break;
		case 2:
			System.out.println("Indica cantidad a retirar: ");
			float retirar = Integer.parseInt(dato.readLine());
			try {
				retirar(cuenta1, retirar);
			} catch (Exception e) {
				System.out.print("Fallo al retirar");
			}
			break;
		case 3:
			System.out.println("Aaaaaaaaaadios");
		}
	}

	private static void retirar(CCuenta cuenta1, float retirar) throws Exception {
		cuenta1.retirar(retirar);
	}

	private static int mostrarMenu(BufferedReader dato) throws IOException {
		int opcion;
		System.out.println("MENU DE OPERACIONES");
		System.out.println("-------------------");
		System.out.println("1 - Ingresar");
		System.out.println("2 - Retirar");
		System.out.println("3 - Salir");
		opcion = Integer.parseInt(dato.readLine());
		return opcion;
	}

	private static void ingresar(CCuenta cuenta1, float ingresar) throws Exception {
		cuenta1.ingresando(ingresar);
	}
}
