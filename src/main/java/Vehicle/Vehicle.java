package Vehicle;

public class Vehicle {
    Engine engine;
    int wheels;
    VehicleType vehicleType;
    double price;
    String colour;
    double damage;
    final double ORIGINALPRICE;

    public Vehicle(Engine engine, VehicleType vehicleType, double price, String colour) {
        this.engine = engine;
        this.wheels = 4;
        this.vehicleType = vehicleType;
        this.price = this.ORIGINALPRICE = price;
        this.colour = colour;
        this.damage = 0;
    }
    public Vehicle(Engine engine,  VehicleType vehicleType, double price, String colour, int wheels) {
        this.engine = engine;
        this.wheels = wheels;
        this.vehicleType = vehicleType;
        this.price = this.ORIGINALPRICE = price;
        this.colour = colour;
        this.damage = 0;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getWheelsCount() {
        return wheels;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColour() {
        return colour;
    }

    public double getDamage() {
        return this.ORIGINALPRICE - this.price;
    }

    public void setDamage(double damage) {
        this.price -= damage;
    }

}
