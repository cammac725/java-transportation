package transport;

import java.util.*;

public class Main
{
  public static ArrayList<AbstractVehicle> filteredList = new ArrayList<AbstractVehicle>();

  public static void printVehicles(ArrayList<AbstractVehicle> vehicles, CheckVehicle tester)
  {
    for (AbstractVehicle v : vehicles)
    {
      if (tester.test(v))
      {
        System.out.println(v.getName() + " " + v.getFuelLevel());
        filteredList.add(v);
      }
    }
  }

  public static void main(String[] args)
  {

    Horse seabiscuit = new Horse("Seabiscuit");
    Horse affirmed = new Horse("Affirmed");
    Horse joe = new Horse("Joe");

    seabiscuit.eat(10);
    affirmed.eat(25);
    for (int i = 0; i < 3; i++)
    {
      seabiscuit.move();
    }
    System.out.println("Seabiscuit " + seabiscuit.getFuel());

    System.out.println();

    System.out.println("\n*** From Abstract Class ***");
    HorseFromVehicle secretariat = new HorseFromVehicle("Secretariat", 10);
    secretariat.addFuel(10);
    System.out.println("Secretariat " + secretariat.getFuelLevel());
    System.out.println();

    HorseFromVehicle eclipse = new HorseFromVehicle("Eclipse");
    System.out.println("Eclipse " + eclipse.getFuelLevel());
    eclipse.move(10);

    System.out.println();

    Auto vw = new Auto(1, "Eurovan", 2000);
    Auto toyota = new Auto(10, "Tundra", 1998);
    Auto honda = new Auto(5, "Accord", 2003);
    vw.move();
    vw.move(5);

    HorseFromVehicle trigger = new HorseFromVehicle("Trigger", 10);
    HorseFromVehicle seattleSlew = new HorseFromVehicle("Seattle Slew", 10);
    HorseFromVehicle americanPharoah = new HorseFromVehicle("American Pharoah", 10);

    ArrayList<AbstractVehicle> myList = new ArrayList<AbstractVehicle>();
    myList.add(secretariat);
    myList.add(trigger);
    myList.add(seattleSlew);
    myList.add(americanPharoah);
    myList.add(eclipse);
    myList.add(vw);
    myList.add(toyota);
    myList.add(honda);

    System.out.println();
    System.out.println("*** This List ***");
    System.out.println(myList.toString());

    // filter the list
    // getFuelLevel() < 0
    printVehicles(myList, v -> v.getFuelLevel() < 0);
    System.out.println("\nHorse with positive fuel");
    printVehicles(myList, v -> (v.getFuelLevel() > 0) && (v instanceof HorseFromVehicle));

    
    System.out.println();
    
    // sort
    myList.sort((v1, v2) -> v1.getName().compareToIgnoreCase(v2.getName()));
    myList.forEach(v -> System.out.println(v.getName()));
    
    System.out.println();

    filteredList.sort((v1, v2) -> v1.getName().compareToIgnoreCase(v2.getName()));
    filteredList.forEach(v -> System.out.println(v.getName()));
  }
}