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
  Además, cuenta con un constructor que recibe como parametros los valores que pasaremos a esos dos atributos y a los otros tres que hereda de la clase persona, con métodos getter y setters para los dos atributos propios de la csubclase, un método toString que devuelve la información de cada médico por pantalla, una función listarMedicos, que saca por pantalla la información de todos los médicos que tenga la lista de médicos que nos pasan como parámetro, una función encontrarMedico, que usa otra como auxiliar, que nos permite devolver un médico con el DNI que nos pasa el usuario para devolverlo a la clase principal y poder eliminarlo y una función anhadirMedico que nos permite añadir un nuevo médico al sistema pidiéndole al usuario sus datos. 
</h4>

<h3>Enfermero.java
</h3>
<h4 align="justify">La subclase Enfermero.java hereda de la superclase Persona.java y se crea con la finalidad de poder instanciar los distintos enfermeros del sistema. Al heredar de la superclase persona, hereda los tres atributos que comentamos anteriormente, además de contar con dos nuevos:</br></br>
  - IDEnfermero de tipo int.</br>
  - nivelExperiencia de tipo NivelExperiencia, que es un enumerado que puede tomar los valores: DESCONOCIDA, BAJO, MEDIO y ALTO.</br></br>
  Además, cuenta con un constructor que recibe como parametros los valores que pasaremos a esos dos atributos y a los otros tres que hereda de la clase persona, con métodos getter y setters para los dos atributos propios de la csubclase, un método toString que devuelve la información de cada enfermero por pantalla, una función listarEnfermeros, que saca por pantalla la información de todos los médicos que tenga la lista de médicos que nos pasan como parámetro, una función encontrarEnfermero, que usa otra como auxiliar, que nos permite devolver un enfermero con el DNI que nos pasa el usuario para devolverlo a la clase principal y poder eliminarlo y una función anhadirEnfermero que nos permite añadir un nuevo enfermero al sistema pidiéndole al usuario sus datos. 
</h4>




