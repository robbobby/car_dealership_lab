import Customer.Customer;
import Dealership.Dealership;
import Vehicle.Engine;
import Vehicle.Vehicle;
import Vehicle.VehicleType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class DealershipTest {
    Dealership dealership;
    Vehicle vehicle;
    Engine engine;
    ArrayList<Vehicle> vehicles;
    Customer customer;
    Customer customer2;

    @Before
    public void setUp(){
        engine = new Engine("M52B25", 2500);
        vehicle = new Vehicle(engine, VehicleType.PETROL, 1999.99d, "red");
        vehicles = new ArrayList<Vehicle>(Arrays.asList(vehicle));
        dealership = new Dealership(10299.00d, null);
        customer = new Customer(10000, null);
        customer2 = new Customer(100, null);
    }
    @Test
    public void hasEmptyCarList() {
        assertEquals(0, dealership.getVehicleCount());
    }
    @Test public void hasMoney() {
        assertEquals(10299.00d, dealership.getTill(), 0.01);
    }
    @Test public void canAddCar() {
        dealership.addVehicle(vehicle);
        assertEquals(1, dealership.getVehicleCount());
    }
    @Test public void canRemoveVehicle() {
        dealership.addVehicle(vehicle);
        assertTrue(dealership.removeVehicle(vehicle));
        assertEquals(0, dealership.getVehicleCount());
    }
    @Test public void canRemoveVehicle_() {
        dealership.addVehicle(vehicle);
        assertEquals(vehicle, dealership.removeVehicle(0));
        assertEquals(0, dealership.getVehicleCount());
    }

    @Test public void canSellCarToCustomerWithEnoughMoney(){
        dealership.addVehicle(vehicle);
        assertEquals(1, dealership.getVehicleCount());
        assertEquals(0, customer.getVehicleCount());
        assertTrue(dealership.sellCarToCustomer(customer, vehicle));
        assertEquals(0, dealership.getVehicleCount());
        assertEquals(1, customer.getVehicleCount());

    }

    @Test public void cantSellCarToCustomerWithNotEnoughMoney(){
        dealership.addVehicle(vehicle);
        assertEquals(1, dealership.getVehicleCount());
        assertEquals(0, customer.getVehicleCount());
        assertFalse(dealership.sellCarToCustomer(customer2, vehicle));
        assertEquals(1, dealership.getVehicleCount());
        assertEquals(0, customer.getVehicleCount());
    }
}
