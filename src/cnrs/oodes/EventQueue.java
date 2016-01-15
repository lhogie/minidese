package cnrs.oodes;

public interface EventQueue<S>
{

	void add(Event<S> e);

	Event<S> getNextEvent();

	int size();
}