import Customer.Customer;
import Vehicle.Vehicle;
import Vehicle.Engine;
import Vehicle.VehicleType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomerTest {
        Customer customer;
        Vehicle vehicle;
        Engine engine;
        ArrayList<Vehicle> vehicles;

    @Before public void setUp(){
        engine = new Engine("M52B25", 2500);
        vehicle = new Vehicle(engine, VehicleType.PETROL, 1999.99d, "red");
        vehicles = new ArrayList<Vehicle>(Arrays.asList(vehicle));
        customer = new Customer(10299.00d, null);
    }
    @Test public void hasEmptyCarList() {
        assertEquals(0, customer.getVehicleCount());
    }
    @Test public void hasMoney() {
        assertEquals(10299.00d, customer.getMoney(), 0.01);
    }
    @Test public void canAddCar() {
        customer.addVehicle(vehicle);
        assertEquals(1, customer.getVehicleCount());
    }
    @Test public void canRemoveVehicle() {
        customer.addVehicle(vehicle);
        assertTrue(customer.removeVehicle(vehicle));
        assertEquals(0, customer.getVehicleCount());
    }
@Test public void canRemoveVehicle_() {
        customer.addVehicle(vehicle);
        assertEquals(vehicle, customer.removeVehicle(0));
        assertEquals(0, customer.getVehicleCount());
    }
}
