package ethebee3.basicUtils.event.events;

import ethebee3.basicUtils.event.event;
import ethebee3.basicUtils.event.listener;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;

public class eventManager
{
    private static HashMap<Class<? extends listener>, ArrayList<PrioritizedListener<? extends listener>>> listenerMap = null;

    public eventManager()
    {
        listenerMap = new HashMap<>();
    }

    public static <L extends listener, E extends event<L>> void fire(E event)
    {
        eventManager.fireImpl(event);
    }

    private static <L extends listener, E extends event<L>> void fireImpl(E event)
    {
        Class<L> listenerType = event.getListenerType();
        ArrayList<PrioritizedListener<L>> listeners = (ArrayList<PrioritizedListener<L>>) (Object) listenerMap.get(listenerType);

        if (listeners == null || listeners.isEmpty())
            return;

        ArrayList<PrioritizedListener<L>> listeners2 = new ArrayList<>(listeners);
        listeners2.removeIf(Objects::isNull);
        listeners2.sort(Comparator.comparing(listener -> Integer.MAX_VALUE - listener.getPriority()));

        ArrayList<L> listeners3 = new ArrayList<>();
        listeners2.forEach(listener -> listeners3.add(listener.getListener()));

        event.fire(listeners3);
    }

    public <L extends listener> void add(Class<L> type, L listener)
    {
        add(type, listener, 0);
    }

    public <L extends listener> void add(Class<L> type, L listener, int priority)
    {
        ArrayList<PrioritizedListener<L>> listeners = (ArrayList<PrioritizedListener<L>>) (Object) listenerMap.get(type);
        if (listeners == null)
        {
            listeners = new ArrayList<>();
            listenerMap.put(type, (ArrayList<PrioritizedListener<? extends listener>>) (Object) listeners);
        }
        listeners.add(new PrioritizedListener(listener, priority));
    }

    public <L extends listener> void remove(Class<L> type, L listener)
    {
        ArrayList<PrioritizedListener<L>> listeners = (ArrayList<PrioritizedListener<L>>) (Object) listenerMap.get(type);
        if (listeners != null)
            listeners.removeIf(l -> l.getListener().equals(listener));
    }

    private class PrioritizedListener<L extends listener>
    {
        private L listener;
        private int priority;

        public PrioritizedListener(L listener)
        {
            this(listener, 0);
        }

        public PrioritizedListener(L listener, int priority)
        {
            this.listener = listener;
            this.priority = priority;
        }

        public L getListener()
        {
            return listener;
        }

        public int getPriority()
        {
            return priority;
        }
    }
}
