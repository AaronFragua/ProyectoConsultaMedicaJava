import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Cita{
    private int IDCita;
    private Medico medico;
    private Paciente paciente;
    private Enfermero enfermero;
    private LocalDate fecha;
    private String motivo;

    public Cita(int IDCita, Medico medico, Paciente paciente, Enfermero enfermero, LocalDate fecha, String motivo) {
        this.IDCita=IDCita;
        this.medico = medico;
        this.paciente = paciente;
        this.enfermero = enfermero;
        this.fecha = fecha;
        this.motivo = motivo;
    }
    
    public int getID(){
        return this.IDCita;
    }
    public void setID(int ID){
        this.IDCita=ID;
    }

    @Override
    public String toString() {
        return("Cita programada: "+ this.getID()+"\t\n"
                +"Medico: "+medico.toString()+"\t\n"
                +"Paciente: "+paciente.toString()+"\t\n"
                +"Enfermero: "+enfermero.toString()+"\t\n"
                +"Fecha: "+this.fecha+", Motivo: "+this.motivo);
    }
    
    public static Cita encontrarCita(List<Cita> citas) {
    Scanner sc = new Scanner(System.in);
    int miID;
    Cita citaEncontrada = null;
    boolean idValido = false;

        while (!idValido) {
            System.out.println("Introduce el ID de la cita a eliminar: ");
            String input = sc.nextLine();

            if (input.matches("\\d+")) { 
                miID = Integer.parseInt(input); 

                citaEncontrada = encontrarCitaPorID(citas, miID);
                if (citaEncontrada != null) {
                    idValido = true;
                } else {
                    System.out.println("No se ha encontrado ninguna cita con ese ID. Intentalo de nuevo.");
                }
            } else {
                System.out.println("Por favor, introduce un ID valido que contenga solo digitos.");
            }
        }

        return citaEncontrada; 
    }

    public static Cita encontrarCitaPorID(List<Cita> citas, int idBuscado) {
        for (Cita cita : citas) {
            if (cita.getID() == idBuscado) {
                return cita;
            }
        }
        return null; 
    }
    
    public static void listarCita(List<Cita> citas){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < citas.size(); i++) {
            sb.append("\r\n"+citas.get(i).toString()+"\r\n");
        }
        System.out.println(sb.toString());
    }
}
