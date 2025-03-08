package NuevaTarea;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Scanner;
/**
 * Descripción general de la clase.
 * Más detalles sobre la clase si es necesario.
 * 
 * @author Eimy y Fio
 */
public class ArraysTiendaOnline {
	 /**
     * Método principal que inicia el programa.
     * Este es el punto de entrada del programa.
     * 
     * @param args Los argumentos de la línea de comandos.
     */
//AUTOR EIMY Y FIO
	
		
			public static void main(String[] args) {
				Scanner sc = new Scanner(System.in);
				//Pizzeria Esmilce Ruiz González y Fiorelha Pinto Rojas 1º DAM 
				String nombre[] = new String[10];
				nombre[0]="Pepperoni";
				nombre[1]="Barbacoa";
				nombre[2]="Vegana";
				nombre[3]="Carbonara";
				nombre[4]="Cuatro quesos";
				nombre[5]="Tropical";
				nombre[6]="Jamon y Queso";
				nombre[7]="Pollo";
				nombre[8]="Ternera";
				nombre[9]="Jamón Serrano";

				double precio[] = new double[10];
				precio[0]= 10.50;
				precio[1]= 11.50;
				precio[2]= 15.00;
				precio[3]= 11.00;
				precio[4]= 12.00;
				precio[5]= 12.50;
				precio[6]= 11.00;
				precio[7]= 13.00;
				precio[8]= 14.00;
				precio[9]= 14.50;

				int cantidadStock[] = new int[10];
				cantidadStock[0] = 90;
				cantidadStock[1] = 100;
				cantidadStock[2] = 87;
				cantidadStock[3] = 40;
				cantidadStock[4] = 85;
				cantidadStock[5] = 66;
				cantidadStock[6] = 75;
				cantidadStock[7] = 78;
				cantidadStock[8] = 50;
				cantidadStock[9] = 40;

				int cargo=1;//para entrar al while
				while(cargo!=3) {
					System.out.println("¡Bienvenido a la pizzeria familiar Fio y Eimy!");
					System.out.println("¿Entra como cliente o como administrador?");
					System.out.println("1-Cliente");
					System.out.println("2-Administrador");
					System.out.println("3-Salir");
					cargo = sc.nextInt();
					switch(cargo){
					case 1:
						System.out.println("Escoja del menu:");
						for (int i = 0; i < nombre.length; i++) {
							System.out.print((i + 1) + ". Pizza " + nombre[i] + " - ");
							System.out.printf("%.2f€", precio[i]+(precio[i]*0.21));
							System.out.println();
						}
						System.out.print("0. Terminar el pedido");
						System.out.println();
						System.out.println();
						//carrito productos
						int carrito[] = new int[1];
						//carrito cantidades
						int carritocan [] = new int[1];
						int cantidadtotal=0;
						double preciototal = 0;
						//comprobar que hay suficiente stock
						for(int i=0;;i++) {
							System.out.println("Introduzca su elección de pizza o termine su pedido");
							int opcion= sc.nextInt();
							if (opcion==0) {
								carrito=Arrays.copyOf(carrito, carrito.length-1);
								carritocan=Arrays.copyOf(carritocan, carritocan.length-1);
								System.out.println("¡Gracias por su pedido!");
								break;
							}
							else if (opcion>nombre.length||opcion<0) {
								System.out.println("Esa no es una opción posible");
								i--;
							}
							else {
								carrito[i] = opcion-1;
								carrito =Arrays.copyOf(carrito, carrito.length+1);
								System.out.println("¿Que cantidad desea pedir del tipo seleccionado?");
								int cantidad = sc.nextInt();
								carritocan[i] = cantidad;
								carritocan=Arrays.copyOf(carritocan, carritocan.length+1);
								cantidadStock[opcion-1]-=cantidad;
								if (cantidadStock[opcion-1]<0) {
									System.out.println("Lo siento, ya no hay más unidades. Escoja una cantidad menor o escoja otra pizza.");
									cantidadStock[opcion-1]+=cantidad;
									carrito=Arrays.copyOf(carrito, carrito.length-1);
									carritocan=Arrays.copyOf(carritocan, carritocan.length-1);
									i--;
								}
								else if (cantidad<=0) {
									System.out.println("Cantidad debe de ser como mínimo 1");
									System.out.println();
									carrito=Arrays.copyOf(carrito, carrito.length-1);
									carritocan=Arrays.copyOf(carritocan, carritocan.length-1);
									i--;
								}
								else {
									cantidadtotal+=cantidad;
									preciototal+=(precio[opcion-1]*cantidad);
								}
							}
						}

						//Facturación
						if (cantidadtotal>0) {
							//Propina
							System.out.println("¿Desea dejar propina?");
							System.out.println("1-Si");
							System.out.println("2-No");
							double propina =0;
							int decision = sc.nextInt();
							switch(decision) {
							case 1:
								System.out.println("Cantidad de la propina:");
								propina = sc.nextDouble();
								while (propina<=0) {
									System.out.println("Que buena broma :). Introduzca la cantidad de propina:");
									propina =sc.nextDouble();
								}
								System.out.println("Gracias por su apotación.");
								System.out.println();
								break;
							case 2:
								System.out.println("Tenga un buen día :).");
								System.out.println();
								break;
							default:
								System.out.println("Esa no era una opción");
							}
							//La factura
							System.out.println("El pedido:");
							for (int i=0;i<carrito.length;i++) {
								int num =carrito[i];
								System.out.print(carritocan[i]+" "+nombre[num] + " con un precio de ");
								System.out.printf("%.2f€",precio[num]);
								System.out.println();
							}
							System.out.println("Cantidad total: " + cantidadtotal +" pizza/s");
							System.out.printf("Precio sin IVA: %.2f€",preciototal);
							System.out.println();
							System.out.printf("Precio con IVA: %.2f€",preciototal+(preciototal*0.21));
							System.out.println();
							System.out.printf("Precio total: %.2f€",preciototal+(preciototal*0.21)+propina);
							System.out.println();
							System.out.println();
						}
						//Cuando no pide ninguna pizza
						else {
							System.out.println("No ha escogido ninguna pizza...Le estaremos esperando cuando tenga hambre :).");
							System.out.println();
						}
						break;

					case 2://Cargo Administrador
						System.out.println("Introduzca la contraseña:");// La contraseña es 1234
						int contraseña = sc.nextInt();
						if (contraseña!=1234) {
							for (int i =1;i<4;i++) {
								System.out.println("Contraseña incorrecta. Introducela de nuevo:");
								contraseña = sc.nextInt();
							}
							System.out.println("Acceso denegado.");
						}
						else {
							int seleccion =1;//Para entrar al while
							while(seleccion!=0) {
								System.out.println("Menu:");
								System.out.println("1-Alta de producto");
								System.out.println("2-Consulta de productos");
								System.out.println("3-Modificación de productos");
								System.out.println("4-Baja de un producto");
								System.out.println("0-Salir");
								System.out.println("¿Que acción desea realizar?");
								seleccion = sc.nextInt();
								switch(seleccion) {
								case 1:
									//Alta de producto
									System.out.println("Introduzca el nombre del nuevo producto:");
									String nuevoNombre = sc.next();
									// Verificar si el producto ya existe
									boolean existeProducto = false;
									for (int i = 0; i < nombre.length; i++) {
										if (nombre[i].equalsIgnoreCase(nuevoNombre)) {
											existeProducto = true;		
											break;
										}
									}
									if (existeProducto) {
										System.out.println("El producto ya está dado de alta. Intente con otro nombre.");
									} else {
										// Aumentar el tamaño de los arrays para añadir un nuevo producto
										nombre = Arrays.copyOf(nombre, nombre.length + 1);
										precio = Arrays.copyOf(precio, precio.length + 1);
										cantidadStock = Arrays.copyOf(cantidadStock, cantidadStock.length + 1);

										// Asignar valores al nuevo producto
										nombre[nombre.length - 1] = nuevoNombre;
										System.out.println("¿Cuál es el precio del producto?");
										precio[precio.length - 1] = sc.nextDouble();
										//Comprobación precio
										while (precio[precio.length - 1]<=0) {
											System.out.println("Ese no es un precio aceptable. Escoja otro:");
											precio[precio.length - 1] = sc.nextDouble();
										}
										System.out.println("¿Cuántas unidades están disponibles?");
										cantidadStock[cantidadStock.length - 1] = sc.nextInt();
										//Comprobación cantidad
										while (cantidadStock[cantidadStock.length - 1]<=0) {
											System.out.println("Esa no es una cantidad aceptable. Introdusca otro valor:");
											cantidadStock[cantidadStock.length - 1] = sc.nextInt();
										}

										System.out.println("Producto añadido correctamente.");
										//Lista nueva
										for (int i = 0; i < nombre.length; i++) {
											System.out.print((i + 1) + ". " + nombre[i] + " - ");
											System.out.printf("Precio: %.2f€ - ", precio[i]);
											System.out.println("Cantidad en stock: " + cantidadStock[i]);
										}
									}
									break;
								case 2:
									//Consulta producto
									System.out.println("Productos disponibles:");
									for (int i = 0; i < nombre.length; i++) {
										System.out.print((i + 1) + ". " + nombre[i] + " - ");
										System.out.printf("Precio: %.2f€ - ", precio[i]);
										System.out.println("Cantidad en stock: " + cantidadStock[i]);
									}
									break;
								case 3:
									//Modificación de productos
									System.out.println("¿Que desea modificar?");
									System.out.println("1-Precio");
									System.out.println("2-Cantidad disponible");
									int eleccion = sc.nextInt();

									switch(eleccion) {
									case 1:
										System.out.println("¿De que producto desea modificar el precio?");
										//Lista productos
										for (int i = 0; i < nombre.length; i++) {
											System.out.print((i + 1) + ". " + nombre[i]);
											System.out.println();
										}
										int producto = sc.nextInt();
										while (producto>nombre.length||producto<=0) {
											System.out.println("Ese no es un producto existente. Escoja otro:");
											producto = sc.nextInt();
										}
										int indice = producto-1;
										//Asignación de precio
										System.out.println("¿Que nuevo precio desea ponerle?");
										double nuevoPrecio = sc.nextDouble();
										precio[indice]=nuevoPrecio;
										//Comprobación precio
										while (precio[indice]<=0) {
											System.out.println("Ese no es un precio aceptable. Escoja otro:");
											precio[indice]=nuevoPrecio;
										}
										//Nueva lista
										System.out.println("Lista actualizada de precios:");
										for (int i=0;i<precio.length;i++) {
											System.out.print((i+1)+". "+ nombre[i] +" - ");
											System.out.printf("%.2f€",precio[i]);
											System.out.println();
										}
										break;
									case 2:
										System.out.println("¿De que producto desea modificar la cantidad disponible?");
										//Menu productos
										for (int i = 0; i < nombre.length; i++) {
											System.out.print((i + 1) + ". " + nombre[i]);
											System.out.println();
										}
										int producto2 = sc.nextInt();
										while (producto2>nombre.length||producto2<=0) {
											System.out.println("Ese no es un producto existente. Escoja otro:");
											producto2 = sc.nextInt();
										}
										int indice2 = producto2-1;
										//Asinación de cantidad
										System.out.println("¿Que cantidad desea ponerle?");
										int nuevaCantidad = sc.nextInt();
										//Comprobación cantidad
										while(nuevaCantidad<=0) {
											System.out.println("Esa no es una cantidad aceptable. Introdusca otro valor:");
											nuevaCantidad = sc.nextInt();
										}
										cantidadStock[indice2]= nuevaCantidad;
										//Nueva lista
										System.out.println("Lista actualizada de cantidades:");
										for (int i=0;i<cantidadStock.length;i++) {
											System.out.print((i+1) +". "+ nombre[i] +" :");
											System.out.print(cantidadStock[i]);
											System.out.println();
										}
										break;
									default:
										System.out.println("Esa no es una elección posible");//Lleva al menu de admin
									}
									break;
								case 4:
									//Baja del producto
									System.out.println("¿Que producto quiere dar de baja?");
									//Menu
									for (int i = 0; i < nombre.length; i++) {
										System.out.print((i + 1) + ". " + nombre[i]);
										System.out.println();
									}
									int producto = sc.nextInt();
									while (producto>nombre.length||producto<=0) {
										System.out.println("Ese no es un producto existente. Escoja otro:");
										producto = sc.nextInt();
									}
									int indice = producto-1;
									System.arraycopy(nombre, indice+1, nombre, indice, nombre.length-indice-1);
									nombre=Arrays.copyOf(nombre, nombre.length-1);
									//Quitar precio del producto eliminado
									System.arraycopy(precio, indice+1, precio, indice, precio.length-indice-1);
									precio=Arrays.copyOf(precio, precio.length-1);
									//Quitar cantidad del producto eliminado
									System.arraycopy(cantidadStock, indice+1, cantidadStock, indice, cantidadStock.length-indice-1);
									cantidadStock=Arrays.copyOf(cantidadStock, cantidadStock.length-1);
									//Lista actualizada de productos con sus precios y cantidades
									for (int i = 0; i < nombre.length; i++) {
										System.out.print((i + 1) + ". " + nombre[i] + " - ");
										System.out.printf("Precio: %.2f€ - ", precio[i]);
										System.out.println("Cantidad en stock: " + cantidadStock[i]);
									}
									break;
								case 0: 
									System.out.println("Saliendo...");
									break;
								default: 
									System.out.println("Esa no es una seleccion valida.");
								}
							}
						}
						break;
					case 3: 
						System.out.println("¡Gracias por su visita!");
						break;
					default:
						System.out.println("Esa no es una opción valida. Escoja otra:");
					}
				}
			}
		}
