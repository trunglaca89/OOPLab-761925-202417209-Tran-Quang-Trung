package hust.soict.globalict.aims;

import java.util.Scanner;
import java.util.Collections;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.store.Store;

public class Aims {
    static Store store = new Store();
    static Cart cart = new Cart();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = -1;
        while (choice != 0) {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1: 
                    viewStore(); 
                    break;
                case 2: 
                    updateStore(); 
                    break;
                case 3: 
                    viewCart(); 
                    break;
                case 0: 
                    System.out.println("Goodbye!"); 
                    break;
                default: 
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    public static void viewStore() {
        store.print(); 
        int choice = -1;
        while (choice != 0) {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            
            if (choice == 1) {
                seeMediaDetails();
            } else if (choice == 2) {
                addMediaToCart();
            } else if (choice == 3) {
                playMedia();
            } else if (choice == 4) {
                viewCart();
            }
        }
    }

    public static void seeMediaDetails() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        Media media = store.search(title);

        if (media != null) {
            System.out.println(media.toString());
            mediaDetailsMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            if (choice == 1) {
                cart.addMedia(media);
            } else if (choice == 2) {
                if (media instanceof Playable) {
                    ((Playable) media).play();
                } else {
                    System.out.println("Cannot play this media!");
                }
            }
        } else {
            System.out.println("Not found!");
        }
    }

    public static void addMediaToCart() {
        System.out.print("Enter title to add to cart: ");
        String title = scanner.nextLine();
        Media media = store.search(title);
        
        if (media != null) {
            cart.addMedia(media);
            
            int dvdCount = 0;
            for (Media m : cart.getItemsOrdered()) {
                if (m instanceof DigitalVideoDisc) {
                    dvdCount++;
                }
            }
            System.out.println("Number of DVDs in cart: " + dvdCount);
        } else {
            System.out.println("Not found!");
        }
    }

    public static void playMedia() {
        System.out.print("Enter title to play: ");
        String title = scanner.nextLine();
        Media media = store.search(title);
        
        if (media != null) {
            if (media instanceof Playable) {
                ((Playable) media).play();
            } else {
                System.out.println("Cannot play this media!");
            }
        } else {
            System.out.println("Not found!");
        }
    }

    public static void updateStore() {
        System.out.println("1. Add media");
        System.out.println("2. Remove media");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        if (choice == 1) {
            System.out.println("Feature not yet implemented.");
        } else if (choice == 2) {
            System.out.print("Enter title to remove: ");
            String title = scanner.nextLine();
            Media media = store.search(title);
            if (media != null) {
                store.removeMedia(media);
            } else {
                System.out.println("Not found!");
            }
        }
    }

    public static void viewCart() {
        cart.print(); 
        int choice = -1;
        while (choice != 0) {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1: 
                    System.out.println("Feature not yet implemented."); 
                    break;
                case 2: 
                    System.out.println("1. Sort by Title");
                    System.out.println("2. Sort by Cost");
                    int sortChoice = scanner.nextInt();
                    if (sortChoice == 1) {
                        Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
                    } else if (sortChoice == 2) {
                        Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
                    }
                    cart.print();
                    break;
                case 3: 
                    System.out.print("Enter title to remove: ");
                    String title = scanner.nextLine();
                    Media media = store.search(title);
                    if (media != null) {
                        cart.removeMedia(media);
                    } else {
                        System.out.println("Not found!");
                    }
                    break;
                case 4: 
                    System.out.print("Enter title to play: ");
                    String playTitle = scanner.nextLine();
                    Media playMedia = store.search(playTitle);
                    if (playMedia != null && playMedia instanceof Playable) {
                        ((Playable) playMedia).play();
                    } else {
                        System.out.println("Cannot play!");
                    }
                    break;
                case 5: 
                    System.out.println("Order created. Cart is empty.");
                    cart.clear(); 
                    break;
                case 0: 
                    break;
            }
        }
    }
}