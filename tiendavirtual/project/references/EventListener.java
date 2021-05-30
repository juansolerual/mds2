package tiendavirtual;

import com.google.common.eventbus.Subscribe;

public class EventListener {

    private static int eventsHandled;

    @Subscribe
    public void stringEvent(String event) {
        eventsHandled++;
    }
}