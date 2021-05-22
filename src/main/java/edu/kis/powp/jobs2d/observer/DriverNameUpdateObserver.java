package edu.kis.powp.jobs2d.observer;

import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.features.DriverFeature;
import edu.kis.powp.jobs2d.features.FeatureManager;
import edu.kis.powp.observer.Subscriber;

public class DriverNameUpdateObserver implements Subscriber{
    private Application app;

    public DriverNameUpdateObserver(Application app){
        this.app = app;
    }

    @Override
    public void update() {
        DriverFeature driverFeature = FeatureManager.getFeature(DriverFeature.class);
        app.updateInfo(driverFeature.getDriverManager().getCurrentDriver().toString());
    }
}
