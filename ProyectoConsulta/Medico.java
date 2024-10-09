/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consulta;

import java.util.List;
import java.util.Scanner;


public class Medico extends Persona{
    public enum Especialidad {DESCONOCIDA,CARDIOLOGIA,RADIOLOGIA,TRAUMATOLOGIA,ALERGOLOGIA,
                               UROLOGIA,GINECOLOGIA,OFTALMOLOGIA};
    private int numColegiado;
    private Especialidad especialidad;
    
    public Medico(String DNI, String nombre, int edad,int numColegiado, Especialidad especialidad){
        super(DNI, nombre, edad);
        this.numColegiado = numColegiado;
        this.especialidad = especialidad;
    }

    public int getNumColegiado(){
        return this.numColegiado;
    }

    public void setNumColegiado(int numColegiado){
        this.numColegiado = numColegiado;
    }

    public Especialidad getEspecialidad(){
        return this.especialidad;
    }

    public void setEspecialidad(Especialidad especialidad){
        this.especialidad = especialidad;
    }

    @Override
    public String toString(){
        return (super.toString()+", Especialidad: "+this.especialidad.toString()+", Numero de Colegiado: "+this.numColegiado);
    }
    
    public static Medico anhadirMedico() {
        Scanner sc = new Scanner(System.in);
        String miDNI = "";
        String miNombre = "";
        int miEdad = -1;
        int miNumColegiado = -1;
        Medico.Especialidad miEspecialidad = Medico.Especialidad.DESCONOCIDA;
        boolean cont = false;

        while (!cont) {
            System.out.println("Introduce el DNI del medico (formato: 6 numeros y una letra): ");
            miDNI = sc.nextLine();
            if (miDNI.matches("[0-9]{8}[A-Za-z]{1}")) {
                cont = true;
            } else {
                System.out.println("Introduce un DNI válido (6 numeros y una letra).");
            }
        }

        cont = false;
        while (!cont) {
            System.out.println("Introduce el nombre del medico: ");
            miNombre = sc.nextLine();
            if (miNombre.matches("[A-Za-z ]+")) {
                cont = true;
            } else {
                System.out.println("Introduce un nombre del medico válido.");
            }
        }

        cont = false;
        while (!cont) {
            System.out.println("Introduce la edad del medico: ");
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
        
        cont = false;
        while (!cont) {
            System.out.println("Introduce el numero de colegiado del medico: ");
            if (sc.hasNextInt()) {
                miNumColegiado = sc.nextInt();
                sc.nextLine(); 
                if (miNumColegiado > 0) {
                    cont = true;
                } else {
                    System.out.println("El numero de colegiado debe ser positivo.");
                }
            } else {
                System.out.println("Introduce un numero de colegiado valido.");
                sc.nextLine(); 
            }
        }
        
        cont = false;
        while (!cont) {
            System.out.println("Introduce la especialidad del medico: ");
            for (int i = 0; i < Medico.Especialidad.values().length; i++) {
                System.out.println(i+1+" para "+Medico.Especialidad.values()[i]);
            }
            if (sc.hasNextInt()) {
                int valor = sc.nextInt();
                sc.nextLine(); 
                if(valor<Medico.Especialidad.values().length+1 && valor>0){
                    cont = true;
                    miEspecialidad=Medico.Especialidad.values()[(valor-1)];
                }
                else{
                    System.out.println("Debes introducir una especialidad que este en las opciones.");
                }
            } else {
                System.out.println("Introduce una especializacion.");
                sc.nextLine(); 
            }
        }

        return new Medico(miDNI, miNombre, miEdad, miNumColegiado, miEspecialidad);
    }
    
    public static void listarMedico(List<Medico> medicos){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < medicos.size(); i++) {
            sb.append("\r\n"+medicos.get(i).toString()+"\r\n");
        }
        System.out.println(sb.toString());
    }
    
    public static Medico encontrarMedico(List<Medico> medicos) {
        Scanner sc = new Scanner(System.in);
        String miDNI;
        Medico medicoEncontrado = null;
        boolean dniValido = false;

        while (!dniValido) {
            System.out.println("Introduce el DNI del médico a eliminar: ");
            miDNI = sc.nextLine().trim();

            if (miDNI.matches("[0-9]{8}[A-Za-z]")) {
                medicoEncontrado = encontrarMedicoPorDNI(medicos, miDNI);

                if (medicoEncontrado != null) {
                    dniValido = true;
                } else {
                    System.out.println("No se ha encontrado un médico con ese DNI. Inténtalo de nuevo.");
                }
            } else {
                System.out.println("DNI no válido. Introduce un DNI con 8 números y una letra.");
            }
        }
    
        return medicoEncontrado; 
    }

    public static Medico encontrarMedicoPorDNI(List<Medico> medicos, String dniBuscado) {
        for (Medico medico : medicos) {
            if (medico.getDNI().equalsIgnoreCase(dniBuscado)) {
                return medico;
            }
        }
        return null; 
    }

}