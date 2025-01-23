package ethebee3.basicUtils.event;

public abstract class cancelEvent<T extends listener> extends event<T>
{
    private boolean isCancelled = false;

    public boolean isCancelled()
    {
        return isCancelled;
    }

    public void cancel()
    {
        isCancelled = true;
    }
}