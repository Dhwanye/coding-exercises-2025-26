package behavioural.observer;

import java.util.ArrayList;
import java.util.List;

interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String temperature);
}

class WeatherStation implements Subject {
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer o) { observers.add(o); }

    @Override
    public void removeObserver(Observer o) { observers.remove(o); }

    @Override
    public void notifyObservers(String temperature) {
        for (Observer o : observers) { o.update(temperature); }
    }

    public void setTemperature(String temperature) {
        System.out.println("WeatherStation: New temperature = " + temperature);
        notifyObservers(temperature);
    }
}

interface Observer { void update(String temperature); }

class MobileApp implements Observer {
    @Override
    public void update(String temperature) {
        System.out.println("MobileApp: Temperature updated to " + temperature);
    }
}

class DisplayBoard implements Observer {
    @Override
    public void update(String temperature) {
        System.out.println("DisplayBoard: Showing temperature " + temperature);
    }
}

public class ObserverDemo {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        station.addObserver(new MobileApp());
        station.addObserver(new DisplayBoard());

        station.setTemperature("25°C");
        station.setTemperature("30°C");
    }
}