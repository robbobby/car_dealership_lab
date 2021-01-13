package behaviours;

import Vehicle.Vehicle;

public interface IManageCars {

    boolean addVehicle(Vehicle vehicle);

    boolean removeVehicle(Vehicle vehicle);

    Vehicle removeVehicle(int index);

    int getVehicleCount();
}
