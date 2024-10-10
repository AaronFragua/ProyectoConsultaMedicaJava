import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GestionConsulta {

    public static void main(String[] args) {
        LocalDate fechaEspecifica = LocalDate.of(2024, 10, 10);
        int ultimoIDPaciente = 4567;
        boolean salir = false;
        int opcion=0;
        boolean cont=false;
        Scanner scanner = new Scanner(System.in);
        
        //Creamos un par de medicos
        Medico m1 = new Medico("54273876A","Juan Fernandez Gonzalez", 56, 739572, Medico.Especialidad.CARDIOLOGIA);
        Medico m2 = new Medico("97536998B","Andrea Alvarez Alonso", 32, 911563, Medico.Especialidad.TRAUMATOLOGIA);
        
        //Creamos un paciente
        Paciente p1 = new Paciente("87398600Z", "Fernandez Diaz Pondal",55, 766540);
        
        //Creamos un par de enfermeros
        Enfermero e1 = new Enfermero("57644400A","David Anta Gonzalez", 26, 821278, Enfermero.NivelExperiencia.BAJO);
        Enfermero e2 = new Enfermero("98755650I","Lucas Paz Alonso", 52, 198000, Enfermero.NivelExperiencia.ALTO);
        
        //Creamos un par de citas
        Cita c1 = new Cita(4932,m1,p1, e2, fechaEspecifica, "Revision de marcapasos");
        Cita c2 = new Cita(8909,m2,p1, e1, fechaEspecifica, "Revision de fracturas");
        
        //Creamos las listas de medicos, pacientes, enfermeros y citas
        List<Medico> medicos = new ArrayList<>();
        List<Paciente> pacientes = new ArrayList<>();
        List<Enfermero> enfermeros = new ArrayList<>();
        List<Cita> citas = new ArrayList<>();
        
        //AÃƒÂ±adimos los medicos, pacientes, enfermeros y citas
        medicos.add(m1);
        medicos.add(m2);
        pacientes.add(p1);
        enfermeros.add(e1);
        enfermeros.add(e2);
        citas.add(c1);
        citas.add(c2);
        
        
        while (!salir){
            System.out.println("//////////////////////////////////////////");
            System.out.println("///// BIENVENIDO A LA CLINICA MEDICA /////");
            System.out.println("//////////////////////////////////////////");
            System.out.println("///// Introduce la opcion a realizar /////");
            System.out.println("///// 1. Anhadir un paciente /////////////");
            System.out.println("///// 2. Anhadir un medico ///////////////");
            System.out.println("///// 3. Anhadir un enfermero ////////////");
            System.out.println("///// 4. Listar pacientes  //////////////");
            System.out.println("///// 5. Listar citas ///////////////////");
            System.out.println("///// 6. Listar medicos /////////////////");
            System.out.println("///// 7. Listar enfermeros //////////////");
            System.out.println("///// 8. Eliminar un medico /////////////");
            System.out.println("///// 9. Eliminar un enfermero //////////");
            System.out.println("///// 10. Eliminar una cita /////////////");
            System.out.println("///// 11. Listar personal completo///////");
            System.out.println("///// 12. Salir//////////////////////////");
            System.out.println("/////////////////////////////////////////");

            
            if (scanner.hasNextInt()){
                opcion = scanner.nextInt();
                switch(opcion){
                    case 1: pacientes.add(Paciente.anhadirPaciente(ultimoIDPaciente));
                        ultimoIDPaciente+=1;
                        break;
                    case 2: medicos.add(Medico.anhadirMedico());
                        break;
                    case 3: enfermeros.add(Enfermero.anhadirEnfermero());
                        break;
                    case 4: Paciente.listarPaciente(pacientes);
                        break;
                    case 5: Cita.listarCita(citas);
                        break;
                    case 6: Medico.listarMedico(medicos);
                        break;
                    case 7: Enfermero.listarEnfermero(enfermeros);
                        break;
                    case 8: Medico.listarMedico(medicos);
                            medicos.remove(Medico.encontrarMedico(medicos));
                            System.out.println("Medico eliminado.");
                        break;
                    case 9: Enfermero.listarEnfermero(enfermeros);
                            enfermeros.remove(Enfermero.encontrarEnfermero(enfermeros));
                            System.out.println("Enfermero eliminado.");
                        break;
                    case 10: Cita.listarCita(citas);
                             citas.remove(Cita.encontrarCita(citas));
                             System.out.println("Cita eliminada");
                        break;
                    case 11: listarPersonal(medicos, enfermeros);
                        break;
                    case 12: salir=true;
                        break;
                    default: System.out.println("Por favor, introduce un numero valido (del 1 al 13).");
                }
            }else{
                System.out.println("Por favor introduce una opcion valida.");
                scanner.next();
            }
        }
        scanner.close();
    }
    public static void listarPersonal(List<Medico> medicos, List<Enfermero> enfermeros){
        StringBuilder sb = new StringBuilder();
        sb.append("Medicos:"+"\r\n");
        for (int i = 0; i < medicos.size(); i++) {
            sb.append(medicos.get(i).toString()+"\t\n");
        }
        sb.append("Enfermeros:"+"\r\n");
        for (int i = 0; i < enfermeros.size(); i++) {
            sb.append(enfermeros.get(i).toString()+"\t\n");
        }
        System.out.println(sb.toString());
    }
}


