package consulta;

import java.util.List;
import java.util.Scanner;

public class Paciente extends Persona{
    private int numHistorialPaciente;

    public Paciente(String DNI, String nombre,int edad, int numHistorialPaciente){
        super(DNI, nombre, edad);
        this.numHistorialPaciente = numHistorialPaciente;
    }

    public int getNumHistorialPaciente(){
        return this.numHistorialPaciente;
    }

    public void setNumHistorialPaciente(int numHistorialPaciente){
        this.numHistorialPaciente=numHistorialPaciente;
    }

    @Override
    public String toString(){
        return (super.toString()+", Numero de historial del paciente: "+this.numHistorialPaciente);
    }
    
    
    public static Paciente anhadirPaciente(int ultimoID) {
        Scanner sc = new Scanner(System.in);
        String miDNI = "";
        String miNombre = "";
        int miEdad = -1;
        int miID = -1;
        boolean cont = false;

        while (!cont) {
            System.out.println("Introduce el DNI del paciente (formato: 6 numeros y una letra): ");
            miDNI = sc.nextLine();
            if (miDNI.matches("[0-9]{8}[A-Za-z]{1}")) {
                cont = true;
            } else {
                System.out.println("Introduce un DNI válido (6 numeros y una letra).");
            }
        }

        cont = false;
        while (!cont) {
            System.out.println("Introduce el nombre del paciente: ");
            miNombre = sc.nextLine();
            if (miNombre.matches("[A-Za-z ]+")) {
                cont = true;
            } else {
                System.out.println("Introduce un nombre de paciente válido.");
            }
        }

        cont = false;
        while (!cont) {
            System.out.println("Introduce la edad del paciente: ");
            if (sc.hasNextInt()) {
                miEdad = sc.nextInt();
                sc.nextLine(); 
                if (miEdad >= 1 && miEdad <= 110) {
                    cont = true;
                } else {
                    System.out.println("La edad debe ser entre 1 y 110 años.");
                }
            } else {
                System.out.println("Introduce una edad válida.");
                sc.nextLine(); 
            }
        }

        miID = ultimoID + 1;
        return new Paciente(miDNI, miNombre, miEdad, miID);
    }
    
    public static void listarPaciente(List<Paciente> pacientes){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pacientes.size(); i++) {
            sb.append("\r\n"+pacientes.get(i).toString()+"\r\n");
        }
        System.out.println(sb.toString());
    }

}