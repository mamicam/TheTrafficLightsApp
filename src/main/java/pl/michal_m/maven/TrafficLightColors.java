package pl.michal_m.maven;

public enum TrafficLightColors {
    GREEN(10000),
    YELLOW(1000),
    RED(11000);

    private int timeOfLighting;

    TrafficLightColors(int timeOfLighting) {
        this.timeOfLighting = timeOfLighting;
    }

    public int getDelaying() {
        return timeOfLighting;
    }
}
