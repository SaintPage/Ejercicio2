//Ángel de Jesús Mérida Jiménez Carné:23661
// El programa consiste en realizar un menu en donde los usuarios puedan ingresar su nombre y numero de visitas para reservar los tipos de habitaciones.

import java.util.Scanner;

//clase principal
public class HotelPrincipal {
    public static void main(String[] args) {
        boolean salir = false;
        //arreglo de huespedes
        Huesped huespedes[] = new Huesped[10];
        //habitaciones estandard
        Habitacion estandar[] = new Habitacion[]{
                new Habitacion("Estandar1", 100,1),
                new Habitacion("Estandar2", 100,1)
        };
        //habitaciones delux
        Habitacion delux[] = new Habitacion[]{
                new Habitacion("delux1", 350,2),
                new Habitacion("delux2", 350,2)
        };
        //habitaciones suites
        Habitacion suits[] = new Habitacion[]{
                new Habitacion("suits1", 1000,3),
                new Habitacion("suits2", 1000,3)
        };
        Habitacion reserva[] = new Habitacion[8];
        while(!salir){
            mostrarMenu();
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch (option){
                case 1:
                    System.out.println("Ingrese el nombre del huesped: ");
                    Scanner sch = new Scanner(System.in);
                    Huesped nuevo = new Huesped();
                    String nomb = sch.nextLine();
                    System.out.println("Ingrese las visitas");
                    int visitas = sch.nextInt();
                    nuevo.setNombre(nomb);
                    nuevo.setVisitas(visitas);
                    for(int i=0; i<huespedes.length; i++){
                        if(huespedes[i] == null){
                            huespedes[i] = nuevo;
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Seleccione el numero del huesped que desea alojar");
                    for(int i=0; i<huespedes.length;i++){
                        if(huespedes[i] !=null)
                            System.out.println((i+1)+" "+huespedes[i]);
                    }
                    int numHuesped = sc.nextInt() - 1;
                    if (huespedes[numHuesped] == null){
                        System.out.println("El huesped es incorrecto");
                        break;
                    }
                    mostrarCategorias();
                    int habitacionSel = sc.nextInt();
                    if(habitacionSel == 1){
                        reservarHabitacion(huespedes[numHuesped], estandar, reserva);
                    } else if (habitacionSel == 2) {
                        reservarHabitacion(huespedes[numHuesped], delux, reserva);
                    }
                    else {
                        reservarHabitacion(huespedes[numHuesped], suits, reserva);
                    }
                    break;
                case 3:
                    System.out.println("Habitaciones disponibles: ");
                    for (int i=0; i<estandar.length;i++){
                        if(!estandar[i].isOcupado()){
                            System.out.println("Habitacion: "+ estandar[i].getTipo() + " disponible");
                        }
                    }

                    for (int i=0; i<delux.length;i++){
                        if(!delux[i].isOcupado()){
                            System.out.println("Habitacion: "+ delux[i].getTipo() + " disponible");
                        }
                    }

                    for (int i=0; i<suits.length;i++){
                        if(!suits[i].isOcupado()){
                            System.out.println("Habitacion: "+ suits[i].getTipo() + " disponible");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Las habitaciones en espera son: ");
                    for (int i=0; i<reserva.length; i++){
                        if(reserva[i] != null){
                            System.out.println(reserva[i] + " del huesped: "+ reserva[i].getHuesped());
                        }
                    }
                    break;

                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("OPCION NO VALIDA");
            }
            System.out.println("-----------------------------");

        }
    }

    // Reservar habitacion, recibiendo los parametros
    public static void reservarHabitacion(Huesped huesped, Habitacion[] habitacion, Habitacion[] reserva){
        int numHabitacion = -1;
        int categoria = habitacion[0].getCategoria();
        for(int i=0; i<habitacion.length; i++){
            if(!habitacion[i].isOcupado()){
                numHabitacion = i;
                break;
            }
        }

        if((categoria == 3 && huesped.getVisitas() < 11)
                || (categoria == 2 && huesped.getVisitas() < 5) ){
            System.out.println("No pertenece a esta categoria");
            return;
        }

        if(numHabitacion == -1){
            //reservar
            for(int i=0; i<reserva.length; i++){
                if(reserva[i] == null){
                    String tipo = habitacion[0].getTipo().substring(0, habitacion[0].getTipo().length() - 1);
                    reserva[i] = new Habitacion(tipo, habitacion[0].getPrecioNoche(),categoria);
                    reserva[i].setHuesped(huesped);
                    break;
                }
            }
            System.out.println("Habitacion en espera");
            return;
        }

        Habitacion habitacionSel = habitacion[numHabitacion];
        habitacionSel.setOcupado(true);
        habitacionSel.setHuesped(huesped);
        System.out.println("Habitacion reservada");
    }

    //Mostrar las distintas categorias
    public static void mostrarCategorias(){
        System.out.println("Seleccione la categoria que desea reservar: ");
        System.out.println("1. Estandar");
        System.out.println("2. Deluxe");
        System.out.println("3. Suites");
    }

    //Parte para mostrar el menu
    public static void mostrarMenu(){
        System.out.println("Elija una opcion");
        System.out.println("1. Agregar huésped para los datos del cliente que desea realizar la reservación");
        System.out.println("2. Asignar a un huésped a una habitación, verificando las restricciones.");
        System.out.println("3. Mostrar en pantalla la lista de habitaciones disponibles.");
        System.out.println("4. Mostrar la lista de espera");
        System.out.println("5. Cerrar el programa");
    }
}