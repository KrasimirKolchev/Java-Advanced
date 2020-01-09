package DefiningClassesEx.CarSalesman;

public class Engine {
    private String engineModel;
    private int enginePower;
    private String displacement;
    private String efficiency;

    public Engine(String engineModel, int enginePower) {
        this.engineModel = engineModel;
        this.enginePower = enginePower;
        this.displacement = "n/a";
        this.efficiency = "n/a";
    }

    public String getEngineModel() {
        return engineModel;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

}
