package consulta;

import java.util.List;
import java.util.Scanner;

public class Enfermero extends Persona{
    private int IDEnfermero;
    public enum NivelExperiencia{DESCONOCIDA,BAJO,MEDIO,ALTO};
    private NivelExperiencia nivelExperiencia;

    public Enfermero(String DNI,String nombre,int edad, int IDEnfermero, NivelExperiencia nivelExperiencia){
        super(DNI, nombre, edad);
        this.IDEnfermero=IDEnfermero;
        this.nivelExperiencia=nivelExperiencia;
    }

    public int getIDEnfermero(){
        return this.IDEnfermero;
    }

    public void setIDEnfermero(int IDEnfermero){
        this.IDEnfermero=IDEnfermero;
    }

    public NivelExperiencia getNivelExperiencia(){
        return this.nivelExperiencia;
    }

    public void setNivelExperiencia(NivelExperiencia nivelExperiencia){
        this.nivelExperiencia=nivelExperiencia;
    }

    @Override
    public String toString(){
        return (super.toString()+", Nivel de experiencia: "+this.nivelExperiencia+", ID de Enfermero: "+this.IDEnfermero);
    }
    
    public static Enfermero anhadirEnfermero() {
        Scanner sc = new Scanner(System.in);
        String miDNI = "";
        String miNombre = "";
        int miEdad = -1;
        int IDEnfermero = -1;
        Enfermero.NivelExperiencia miExperiencia = Enfermero.NivelExperiencia.DESCONOCIDA;
        boolean cont = false;

        while (!cont) {
            System.out.println("Introduce el DNI del enfermero (formato: 6 numeros y una letra): ");
            miDNI = sc.nextLine();
            if (miDNI.matches("[0-9]{6}[A-Za-z]{1}")) {
                cont = true;
            } else {
                System.out.println("Introduce un DNI válido (6 numeros y una letra).");
            }
        }

        cont = false;
        while (!cont) {
            System.out.println("Introduce el nombre del enfermero: ");
            miNombre = sc.nextLine();
            if (miNombre.matches("[A-Za-z ]+")) {
                cont = true;
            } else {
                System.out.println("Introduce un nombre del enfermero válido.");
            }
        }

        cont = false;
        while (!cont) {
            System.out.println("Introduce la edad del enfermero: ");
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
            System.out.println("Introduce el ID del enfermero: ");
            if (sc.hasNextInt()) {
                IDEnfermero = sc.nextInt();
                sc.nextLine(); 
                if (IDEnfermero > 0) {
                    cont = true;
                } else {
                    System.out.println("El ID del enfermero debe ser positivo.");
                }
            } else {
                System.out.println("Introduce un ID de enfermero valido.");
                sc.nextLine(); 
            }
        }
        
        cont = false;
        while (!cont) {
            System.out.println("Introduce el nivel de experiencia del enfermero: ");
            for (int i = 0; i < Enfermero.NivelExperiencia.values().length; i++) {
                System.out.println(i+1+" para "+Enfermero.NivelExperiencia.values()[i]);
            }
            if (sc.hasNextInt()) {
                int valor = sc.nextInt();
                sc.nextLine(); 
                if(valor<Enfermero.NivelExperiencia.values().length+1 && valor>0){
                    cont = true;
                    miExperiencia=Enfermero.NivelExperiencia.values()[(valor-1)];
                }
                else{
                    System.out.println("Debes introducir una de las opciones.");
                }
            } else {
                System.out.println("Introduce la experiencia.");
                sc.nextLine(); 
            }
        }

        return new Enfermero(miDNI, miNombre, miEdad, IDEnfermero, miExperiencia);
    }
    
    public static Enfermero encontrarEnfermero(List<Enfermero> enfermeros) {
        Scanner sc = new Scanner(System.in);
        String miDNI;
        Enfermero enfermeroEncontrado = null;
        boolean dniValido = false;

        while (!dniValido) {
            System.out.println("Introduce el DNI del enfermero a eliminar: ");
            miDNI = sc.nextLine().trim();

            if (miDNI.matches("[0-9]{8}[A-Za-z]")) {
                enfermeroEncontrado = encontrarEnfermeroPorDNI(enfermeros, miDNI);

                if (enfermeroEncontrado != null) {
                    dniValido = true;
                } else {
                    System.out.println("No se ha encontrado un enfermero con ese DNI. Inténtalo de nuevo.");
                }
            } else {
                System.out.println("DNI no válido. Introduce un DNI con 8 números y una letra.");
            }
        }
    
        return enfermeroEncontrado; 
    }

    public static Enfermero encontrarEnfermeroPorDNI(List<Enfermero> enfermeros, String dniBuscado) {
        for (Enfermero enfermero : enfermeros) {
            if (enfermero.getDNI().equalsIgnoreCase(dniBuscado)) {
                return enfermero;
            }
        }
        return null; 
    }
    
    public static void listarEnfermero(List<Enfermero> enfermeros){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < enfermeros.size(); i++) {
            sb.append("\r\n"+enfermeros.get(i).toString()+"\r\n");
        }
        System.out.println(sb.toString());
    }
    
}