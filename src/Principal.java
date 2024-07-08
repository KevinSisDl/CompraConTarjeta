import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        double limite;
        while (true) {
            try{
                System.out.println("Escriba el límite de la tarjeta: ");
                limite = lectura.nextDouble();
                lectura.nextLine();
                break;
            } catch (InputMismatchException e){
                System.out.println("Error: no ingresó un valor numerico. Intente de nuevo!");
                lectura.next();
                lectura.nextLine();
            }
            
        }

        TarjetaDeCredito tarjeta = new TarjetaDeCredito(limite);

        double totalCompras = 0;
        int salir;

        do {
            System.out.println("Escriba la descripción de la compra:");
            String descripcion = lectura.nextLine();

            double valor;
            while (true) {
                try {
            System.out.println("Escriba el valor de la compra:");
            valor = lectura.nextDouble();
            lectura.nextLine();
            break;
            } catch (InputMismatchException e){
                System.out.println("Error: No ingresó un valor válido, vuelva a intentarlo!");
                lectura.next();
                lectura.nextLine();
            }
        }
            Compra compra = new Compra(valor, descripcion);
            boolean compraRealizada = tarjeta.realizarCompra(compra);

            if (compraRealizada) {
                System.out.println("Compra realizada!");
                totalCompras += valor;
                System.out.println("El saldo restante es: " + tarjeta.getSaldo());
                
            do{
                System.out.println("Escriba 0 para salir o 1 para continuar");
                salir = lectura.nextInt();
                lectura.nextLine();

                if (salir != 0 && salir != 1){
                    System.out.println("Opción no válida. intente de nuevo!");
                }
             } while (salir !=0 && salir!=1);
            } else {
                System.out.println("Saldo insuficiente!");
                salir = 0;
            }
        } while (salir!=0);

        System.out.println("***********************");
        System.out.println("COMPRAS REALIZADAS:");
        Collections.sort(tarjeta.getListaDeCompras());
        for (Compra compra : tarjeta.getListaDeCompras()) {
            System.out.println("Fecha de compra: [" + compra.getFechaFormateada() + "] Descripcion: " + compra.getDescripcion() + " -- Precio: (" + compra.getValor() + ")");
        }
        System.out.println("\n***********************");
        System.out.println("\nSaldo de la tarjeta: " +tarjeta.getSaldo());
        System.out.println("Total de compras: " + totalCompras);

        lectura.close();
    }
}