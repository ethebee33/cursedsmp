package ethebee3.basicUtils.event;

import java.util.ArrayList;

public abstract class event<T extends listener>
{
    public abstract void fire(ArrayList<T> listeners);

    public abstract Class<T> getListenerType();
}
