import Vehicle.Vehicle;
import org.junit.Before;
import Vehicle.VehicleType;
import Vehicle.Engine;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VehicleTest {
    Engine engine;
    Vehicle vehicle;
    @Before public void setUp() {
        engine = new Engine("M52B25", 2500);
        vehicle = new Vehicle(engine, VehicleType.PETROL, 1999.99d, "red");
    }
    @Test public void hasEngine() {
        assertEquals(engine, vehicle.getEngine());
    }
    @Test public void hasType() {
        assertEquals(VehicleType.PETROL, vehicle.getVehicleType());
    }
    @Test public void hasPrice() {
        assertEquals(1999.99d, vehicle.getPrice(), 0.01);
    }
    @Test public void hasColour() {
        assertEquals("red", vehicle.getColour());
    }
    @Test public void hasDefaultWheelNumberOf4() {
        assertEquals(4, vehicle.getWheelsCount());
    }
    @Test public void canHaveDamage() {
        vehicle.setDamage(50.00d);
        assertEquals(1949.99, vehicle.getPrice(), 0.01);
    }
}
