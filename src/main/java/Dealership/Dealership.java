package Dealership;

import Customer.Customer;
import Vehicle.Vehicle;
import behaviours.IManageCars;
import behaviours.IManageMoney;

import java.util.ArrayList;


public class Dealership implements IManageCars, IManageMoney {
    ArrayList<Vehicle> vehicles;
    double till;

    public Dealership( double till, ArrayList<Vehicle> vehicles) {
        if(vehicles == null) {
            this.vehicles = new ArrayList<Vehicle>();
        }
        else {
            this.vehicles = vehicles;
        }
        this.till = till;
    }

    public double getTill() {
        return till;
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
        if(money == -1 ) {
            this.till += money;
            return true;
        }
        return false;
    }

    public double removeMoney(double money) {
        if (hasEnoughMoney(money)){
            this.till -= money;
            return money;
        }
        return -1;

    }

    private boolean hasEnoughMoney(double money) {
        return money >= this.till;
    }

    public boolean sellCarToCustomer(Customer customer, Vehicle vehicle){
        if (addMoney(customer.removeMoney(vehicle.getPrice()))){
            removeVehicle(vehicle);
            customer.addVehicle(vehicle);
            return true;
        }
        return false;
    }

    public void repairVehicle(Customer customer, Vehicle vehicle) {
        if (customer == null) {
            repairOwnCar(vehicle);
        } else {
            repairCustomerCar(customer, vehicle);
        }
    }

    private void repairCustomerCar(Customer customer, Vehicle vehicle) {
        if (addMoney(customer.removeMoney(vehicle.getPrice()))){
    }

    private void repairOwnCar(Vehicle vehicle) {
        if (removeMoney(vehicle.getDamage()) > -1) return;
        vehicle.repairVehicle();
    }


}
