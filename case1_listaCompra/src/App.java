import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
Tienes un carrito de la compra donde puedas añadir, leer, modificar, borrar y BUSCAR elementos.
Crear menú con opciones. Si opción = ‘salir’ u opción 0, se acaba el programa.
Se propone que sean objetos Comida: nombre, origen, peso, precio.
Se aconseja en este caso realizar un switch dentro de un while. El switch sobre las opciones del menú del tipo:
1- Añadir comida (implica añadir por teclado todas las características del objeto)
2- Mostrar lista completa

3- Mostrar un producto específico por nombre (implica opción buscar)

4- Modificar por nombre. ¿Cuál quieres modificar? (implica opción buscar)

5- Borrar elemento por nombre (implica opción buscar)

0- Salir

Para buscar, se aconseja el método equalsIgnoreCase().

+EXTRA: posibilidad de mover un elemento a otro lugar de la lista, sin borrar el que había

*EXTRA: calcular precio final del producto según su peso y precio/Kg


 */
public class App {

    public static void main(String[] args) throws Exception {
       
        Scanner teclado = new Scanner(System.in);
        ArrayList <Producto> productos = new ArrayList<>();
        boolean activo=true;
        while (activo) {
            menu();
            int option = teclado.nextInt();
            teclado.nextLine();
            switch (option) {
                case 1:
                    separador();
                    System.out.println("AÑADIR PRODUCTO");
                    System.out.println("Indica su nombre");
                    String nombreProducto=teclado.nextLine();
                    System.out.println("Indica el origen ");
                    String origenProducto=teclado.nextLine();
                    System.out.println("¿cuántos gramos quieres?");
                    double pesoProducto=teclado.nextDouble();
                    System.out.println("Qué precio tiene el KG?");
                    double precioProducto=teclado.nextDouble();
                    productos.add(new Producto(nombreProducto, origenProducto, pesoProducto, precioProducto));
                    System.out.println("¡Poducto añadido!");
                    separador();
                    break;
                case 2:
                    separador();
                    System.out.println("VER LISTA");
                    verLista(productos);
                    separador();
                    break;
                case 3:
                    separador();
                    System.out.println("VER PRODUCTO");
                    System.out.println("¿Qué producto quieres ver?");
                    String productSearch=teclado.nextLine();
                    for (int i=0; i<productos.size(); i++){
                        if(productos.get(i).getNombre().equalsIgnoreCase(productSearch)){
                            System.out.println(">>>> " + productos.get(i).getNombre() + " | Origen: " + productos.get(i).getOrigen() + "| Peso: " + productos.get(i).getPeso() + "| Precio: " + productos.get(i).getPrecio() + "€" );
                            separador();
                        }
                    
                    }
                    break;
                case 4:
                    separador();
                    System.out.println("MODIFICAR NOMBRE");
                    System.out.println("¿Qué producto quieres modificar?");
                    String productoBuscado=teclado.nextLine();
                    boolean encontrado = false;
                    for (int i=0; i<productos.size(); i++){
                        if(productos.get(i).getNombre().equalsIgnoreCase(productoBuscado)){
                            encontrado=true;
                            System.out.println("Indica el nuevo nombre");
                            productos.get(i).setNombre(teclado.nextLine());
                            System.out.println("--PRODUCTO MODIFICADO");
                            System.out.println(">>>> " + productos.get(i).getNombre() + " | Origen: " + productos.get(i).getOrigen() + "| Peso: " + productos.get(i).getPeso() + "| Precio: " + productos.get(i).getPrecio() + "€" );
                        } 
                        
                        }
                        if (!encontrado) {
                            System.out.println("No hemos econtrado el produxto");
                        }
                        
                    separador();
                    
                    break;
                case 5:
                separador();
                    System.out.println("ELIMINAR PRODUCTO");
                    System.out.println("¿Qué producto quieres eliminar?");
                    for (int i=0; i<productos.size();i++){
                        if(productos.get(i).getNombre().equalsIgnoreCase(teclado.nextLine())){
                            System.out.println("Seguro que quieres eliminar " + productos.get(i).getNombre() + " de la lista? (SI/NO)");
                            if (teclado.nextLine().equalsIgnoreCase("SI")) {
                                productos.remove(i);
                            System.out.println("Producto eliminado");
                            System.out.println("Esta es la lista actual:");
                            verLista(productos);
                            separador();
                            } else {System.out.println("error");}
                        }
                        else {System.out.println("No está en la lista");}

                    }
                    break;
                
                case 6: 
                    separador();
                    System.out.println("ORDENAR LISTA");
                    System.out.println("Qué producto quieres modificar de posición?");
                    String prodToMove = teclado.nextLine();
                    System.out.println("Qué posición tiene que ocupar?");
                    int position = teclado.nextInt();
                    for (int i=0; i<productos.size();i++){
                        if(productos.get(i).getNombre().equalsIgnoreCase(prodToMove)){
                            position=position-1;
                            Collections.swap(productos, i, position);
                        }
                    }
                    teclado.nextLine();
                    verLista(productos);
                    separador();
                    break;
                case 0: 
                    separador();
                    activo=false;
                    System.out.println("FIN");
                    separador();
                    break;
                
                default:
                separador();
                System.out.println("ERROR, INDICA UNA OPCIÓN DEL MENÚ");
                separador();
                    break;
            }
        }
        teclado.close();
    }
    
    public static void menu()
    {
        System.out.println("CARRITO DE LA COMPRA\n");
        System.out.println("Indica que quieres realizar:");
        System.out.println("- 1.Añadir comida\n- 2.Ver lista\n- 3.Ver producto\n- 4.Modificar Nombre\n- 5.Borrar elemento\n- 6.Modificar Posición\n- 0.SALIR");
    }
    public static void separador(){
        System.out.println("\n-----------\n");
    }
    public static void verLista(ArrayList<Producto> productos){
        double totalCompra=0;
        for(Producto x: productos){
            System.out.println("- " + x.getNombre() + " | Origen: " + x.getOrigen() + "| Peso (g): " + x.getPeso() + "| Precio/Kg: " + x.getPrecio() + "€ | TOTAL: " + String.format("%.2f",Precio.precioTotal(x.getPrecio(),x.getPeso())) + "€" );
            totalCompra=totalCompra+Precio.precioTotal(x.getPrecio(),x.getPeso());
        }
        System.out.println("\nTOTAL CESTA: " + String.format("%.2f",totalCompra) + "€");
    }
    
}
