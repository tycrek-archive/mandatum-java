package dev.jmoore.mandatum;

import dev.jmoore.mandatum.handlers.Handler;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.GenericEvent;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Custom Map-based {@link net.dv8tion.jda.api.hooks.EventListener} for JDA
 */
public class EventListener implements net.dv8tion.jda.api.hooks.EventListener {

    // Map used to associate Event classes to Handler's
    private final Map<Class<? extends Event>, Handler<? extends Event>> handlerMap;

    /**
     * Instantiates this {@link EventListener}
     */
    public EventListener() {
        this.handlerMap = new LinkedHashMap<>();
    }

    /**
     * Associates a JDA {@link Event} class with a {@link Handler}
     *
     * @param eventClass   JDA {@link Event} class
     * @param eventHandler The {@link Handler} for the {@link Event}
     * @return This {@link EventListener} for chaining
     */
    public EventListener register(Handler<? extends Event> eventHandler, Class<? extends Event> eventClass) {
        this.handlerMap.put(eventClass, eventHandler);
        return this;
    }

    /**
     * Calls the associated {@link Handler} for the {@link Event} from handlerMap
     *
     * @param event The incoming {@link Event}
     */
    @Override
    public void onEvent(@NotNull GenericEvent event) {
        this.handlerMap.getOrDefault(event.getClass(), Handler.DEFAULT).handle(event);
    }
}
