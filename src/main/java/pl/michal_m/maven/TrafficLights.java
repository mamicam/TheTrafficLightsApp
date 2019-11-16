package pl.michal_m.maven;

import javax.swing.table.TableRowSorter;

public class TrafficLights implements Runnable {
    private TrafficLightColors trafficLightColors;
    private boolean stopApp = false;
    private boolean changeLight = false;

    TrafficLights(TrafficLightColors trafficLightColors) {
        this.trafficLightColors = trafficLightColors;
    }

    @Override
    public void run() {
        while (!stopApp) {
            try {
                Thread.sleep(trafficLightColors.getDelaying());
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
            changeLightColor();
        }
    }

    synchronized void changeLightColor() {
        switch (trafficLightColors) {
            case RED:
                trafficLightColors = TrafficLightColors.GREEN ;
                break;
            case YELLOW:
                trafficLightColors = TrafficLightColors.RED;
                break;
            case GREEN:
                trafficLightColors = TrafficLightColors.YELLOW;
                break;
        }

        changeLight = true;
        notify();
    }

    synchronized void waitingForLightChanging() {
        try {
            while (!changeLight) {
                wait();
            }
            changeLight = false;
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
    }

    synchronized TrafficLightColors getTrafficLightColors() {
        return trafficLightColors;
    }

    synchronized void stopApplication() {
        stopApp = true;
    }
}
