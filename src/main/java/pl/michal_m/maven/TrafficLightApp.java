package pl.michal_m.maven;

/**
 * Program for controlling traffic lights.
 *
 */
public class TrafficLightApp
{
    public static void main( String[] args )
    {
        TrafficLights trafficLights = new TrafficLights(TrafficLightColors.GREEN);
        Thread thread = new Thread(trafficLights);
        thread.start();

        for (int i = 0; i < 9; i++) {
            System.out.println(trafficLights.getTrafficLightColors());
            trafficLights.waitingForLightChanging();
        }

        trafficLights.stopApplication();
    }
}
