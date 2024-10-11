<h1>ProyectoConsultaMedicaJava</h1>

<h4 align="justify">Este es un pequeño proyecto realizado íntegramente en Java. Para ello, creamos una serie de clases que implementan el concepto de herencia, lo que nos ayuda con los atributos de todas las personas involucradas en el sistema. 
</h4>
<h4 align="justify">La idea pricipal es implementar un menú por consola en el que puedas seleccionar una opción que suponga una de las acciones disponibles en el menú. Distinguimos 6 clases en el proyecto: 
</h4>
<h2>CLASES
</h2>
<h3>Persona.java
</h3>
<h4 align="justify">La superclase Persona.java es creada con la finalidad de contener los atributos comunes de todas las personas que se encuentran registradas en nuestro sistema. Así pues, tiene 4 atributos:</br></br>
  - DNI de tipo String.</br>
  - Nombre de tipo String.</br>
  - Edad de tipo int.</br></br>
  Además, cuenta con un constructor que recibe como parametros los valores que pasaremos a esos tres atributos, un método getter por cada atributo, para devolverlos, y un método toString que devuelve la información de cada persona en forma de String. 
</h4>

<h3>Medico.java
</h3>
<h4 align="justify">La subclase Medico.java hereda de la superclase Persona.java y se crea con la finalidad de poder instanciar los distintos médicos del sistema. Al heredar de la superclase persona, hereda los tres atributos que comentamos anteriormente, además de contar con dos nuevos:</br></br>
  - numColegiado de tipo int.</br>
  - especialidad de tipo Especialidad, que es un enumerado que puede tomar los valores: DESCONOCIDA, CARDIOLOGIA, RADIOLOGIA, TRAUMATOLOGIA, ALERGOLOGIA, ROLOGIA, GINECOLOGIA y OFTALMOLOGIA.</br></br>
  Además, cuenta con un constructor que recibe como parametros los valores que pasaremos a esos dos atributos y a los otros tres que hereda de la clase persona, con métodos getters y setters para los dos atributos propios de la subclase, un método toString que devuelve la información de cada médico por pantalla, una función listarMedicos, que saca por pantalla la información de todos los médicos que tenga la lista de médicos que nos pasan como parámetro, una función encontrarMedico, que usa otra como auxiliar, que nos permite devolver un médico con el DNI que nos pasa el usuario para devolverlo a la clase principal y poder eliminarlo y una función anhadirMedico que nos permite añadir un nuevo médico al sistema pidiéndole al usuario sus datos. 
</h4>

<h3>Enfermero.java
</h3>
<h4 align="justify">La subclase Enfermero.java hereda de la superclase Persona.java y se crea con la finalidad de poder instanciar los distintos enfermeros del sistema. Al heredar de la superclase persona, hereda los tres atributos que comentamos anteriormente, además de contar con dos nuevos:</br></br>
  - IDEnfermero de tipo int.</br>
  - nivelExperiencia de tipo NivelExperiencia, que es un enumerado que puede tomar los valores: DESCONOCIDA, BAJO, MEDIO y ALTO.</br></br>
  Además, cuenta con un constructor que recibe como parametros los valores que pasaremos a esos dos atributos y a los otros tres que hereda de la clase persona, con métodos getters y setters para los dos atributos propios de la subclase, un método toString que devuelve la información de cada enfermero por pantalla, una función listarEnfermeros, que saca por pantalla la información de todos los enfermeros que tenga la lista de enfermeros que nos pasan como parámetro, una función encontrarEnfermero, que usa otra como auxiliar, que nos permite devolver un enfermero con el DNI que nos pasa el usuario para devolverlo a la clase principal y poder eliminarlo y una función anhadirEnfermero que nos permite añadir un nuevo enfermero al sistema pidiéndole al usuario sus datos. 
</h4>

<h3>Paciente.java
</h3>
<h4 align="justify">La subclase Paceinte.java hereda de la superclase Persona.java y se crea con la finalidad de poder instanciar los distintos pacientes del sistema. Al heredar de la superclase persona, hereda los tres atributos que comentamos anteriormente, además de contar con uno nuevo:</br></br>
  - numHistorialPaciente de tipo int.</br></br>
  Además, cuenta con un constructor que recibe como parametros los valores que pasaremos a este atributos y a los otros tres que hereda de la clase persona, con métodos getter y setter para el atributo propio de la subclase, un método toString que devuelve la información de cada paciente por pantalla, una función listarPacientes, que saca por pantalla la información de todos los pacientes que tenga la lista de pacientes que nos pasan como parámetro y una función anhadirPaciente que nos permite añadir un nuevo enfermero al sistema pidiéndole al usuario sus datos. </br>
  NOTA: no se implementa la funcionalidad eliminarPaciente porque a pesar de que a un paciente se le de el alta, este quedará guardado en el sistema como histórico, por lo que no existe una función buscarPaciente análoga a la de la clase Medico o Enfermero.
</h4>

<h3>Cita.java
</h3>
<h4 align="justify">La clase Cita.java se crea con la finalidad de poder instanciar las distintas citas del sistema. Cuenta con seis atributos:</br></br>
  - IDCita de tipo int.</br>
  - medico de tipo Medico.</br>
  - paciente de tipo Paciente.</br>
  - enfermero de tipo Enfermero.</br>
  - fecha de tipo LocalDate.</br>
  - motivo de tipo String.</br></br>
  Además, cuenta con un constructor que recibe como parametros los valores que pasaremos a estos atributos, con métodos getter y setter para el atributo IDCita, un método toString que devuelve la información de cada cita por pantalla, una función listarCitas, que saca por pantalla la información de todos las citas que tenga la lista de citas que nos pasan como parámetro y una función encontrarCita, que usa otra como auxiliar, que nos permite devolver una cita con el ID que nos pasa el usuario para devolverla a la clase principal y poder eliminarla  
</h4>

<h3>GestionConsulta.java
</h3>
<h4 align="justify">La clase GestionConsulta es la clase que orquesta la lógica de las clases para hacer que el programa funcione correctamente. Cuenta con seis variables globales:</br></br>
  - fechaEspecifica de tipo LocalDate.</br>
  - ultimoIDPaciente de tipo int.</br>
  - opcion de tipo int.</br>
  - salir de tipo boolean.</br>
  - scanner de tipo Scanner.</br>
  - cont de tipo boolean.</br></br>
  En esta clase, creamos dos médicos, dos enfermeros, un paciente y dos citas y los metemos en los array correspondientes que hemos creado (medicos (lista de médicos), enfermeros (lista de enfermeros), pacientes (lista de pacientes) y citas (lista de citas)).</br>
  Creamos el menú a través de la variable de control salir, lo que nos permite acceder a la funcionalidad que el usuario elija de las 12 posibles:</br></br>
  - Aladir un paciente nuevo.</br>
  - Añadir un médico nuevo.</br>
  - Añadir un enfermero nuevo.</br>
  - Listar los pacientes.</br>
  - Listar las citas.</br>
  - Listar los médicos. </br>
  - Listar los enfermeros. </br>
  - Eliminar un médico.</br>
  - Eliminar una cita por ID.</br>
  - Listar personal (medicos y enfermeros) al completo.</br>
  - Salir </br></br>
  En esta clase se encuentra además la función listarPersonal, la que recibe como parámetros una lista de medicos y una lista de pacientes y devuelve la información por pantalla.
</h4>


