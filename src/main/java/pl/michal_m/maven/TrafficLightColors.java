package pl.michal_m.maven;

public enum TrafficLightColors {
    GREEN(1000), YELLOW(500), RED(1100);

    private int timeOfLighting;

    TrafficLightColors(int timeOfLighting) {
        this.timeOfLighting = timeOfLighting;
    }

    public int getTimeOfLighting() {
        return timeOfLighting;
    }
}
