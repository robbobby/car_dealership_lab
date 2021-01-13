package Customer;

import Vehicle.Vehicle;
import behaviours.IManageCars;
import behaviours.IManageMoney;

import java.util.ArrayList;

public class Customer implements IManageCars, IManageMoney {

    double money;
    ArrayList<Vehicle> vehicles;


    public Customer(double money, ArrayList<Vehicle> vehicles) {
        this.money = money;
        if(vehicles == null) {
            this.vehicles = new ArrayList<Vehicle>();
        }
        else {
            this.vehicles = vehicles;
        }
    }

    public double getMoney() {
        return money;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public boolean addVehicle(Vehicle vehicle) {
        return vehicles.add(vehicle);
    }

    public boolean removeVehicle(Vehicle vehicle) {
        return vehicles.remove(vehicle);
    }

    public Vehicle removeVehicle(int index) {
        return vehicles.remove(index);
    }

    public int getVehicleCount() {
        return this.vehicles.size();
    }


    public boolean addMoney(double money) {
        if(money == -1) {
            return false;
        }
            this.money += money;
            return true;
    }

    public double removeMoney(double money) {
        if (hasEnoughMoney(money)){
            this.money -= money;
            return money;
        }
        return -1;
    }

    private boolean hasEnoughMoney(double money) {
        return money >= this.money;
    }
}
