import java.util.Scanner;

public class App {
  // Creamos una constante que almacena los intentos que tiene la persona
  private static final int INTENTOS = 3;
  // Creamos el objeto scanner para almacenar el numero del usurio
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws Exception {
    // Creamos la variable que almacenara el numero aleatorio
    int numeroRandom = (int) (Math.random() * 10);
    // Mensaje del bienvenida
    System.out.println("Bienvenido!, el juego consiste en ingresar un numero y, si es igual al de la maquina ganas");
    System.out.println("Buena Suerte!");
    // Almacenamos el numero que regresa la funcion;
    int numeroUsuario = solicitudNumero();
    // Llamamos a la funcion para saber si el usuario gana o pierde
    ganaOPierde(numeroUsuario, numeroRandom);

    scanner.close();
  }

  // Funcion que solicita un numero y si el numero tiene dos digitos se vuelve a
  // solicitar pero si tiene un solo digito retornaremos el numero que el usuario
  // ingreso
  private static int solicitudNumero() {
    try {
      System.out.println("Ingresa el numero");
      int numero = scanner.nextInt();
      if (numero <= 10) {
        return numero;
      } else {
        scanner.nextLine();
        System.out.println("El numero ingresado es mayor a 10");
        return solicitudNumero();
      }
    } catch (Exception e) {
      scanner.nextLine();
      System.out.println("No es un menoro menor a 10");
      return solicitudNumero();
    }
  }

  // Funcion para validar si el usuario pierde o gana
  private static void ganaOPierde(int numero, int numeroRandom) {
    // Esta varible la ocuparemos para decirle los intentos que le quedan al usuario
    // si pierde
    int intentos = INTENTOS;
    // Creamos un bucle el cual se va a repetir solo 3 veces, que son los intentos
    // que tiene el usuario
    for (int i = 1; i <= INTENTOS; i++) {
      // Mostramos el intento en que va el usuario
      System.out.println("Intento #" + i);
      // Si el numero de usuario es igual al random, se manda un mensaje y se termina
      // el programa
      if (numero == numeroRandom) {
        System.out.println("Felicidades!, Adivinaste el numero en el " + i + " intento");
        System.exit(0);
      }
      // SI no es igual se manda el mensaje y vuelve a solicitar el numero
      if (numero != numeroRandom) {
        System.out.println("LO siento no adivinaste el numero, Recuerda te quedan " + (intentos - 1) + " intentos");
        intentos -= 1;
        // Liberamos el buffer
        scanner.nextLine();
        // Volvemos a solicitar el numero y lo almacenamos en numero por que si no lo
        // hacemos asi, el numero anterior no va a cambiar
        numero = solicitudNumero();
      }
    }

    System.out.println("Lo siento no lo adivinaste!, el numero era: " + numeroRandom);
  }

}
