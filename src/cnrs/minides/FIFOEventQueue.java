package cnrs.oodes;

import java.util.ArrayList;

public class FIFOEventQueue<S> implements EventQueue<S>
{
	private final AA q = new AA();

	private class AA extends ArrayList<Event<S>>
	{
		@Override
		public void removeRange(int fromIndex, int toIndex)
		{
			super.removeRange(fromIndex, toIndex);
		}
	}

	private int indexOfFirst = 0;

	@Override
	public void add(Event<S> e)
	{
		q.add(e);
	}

	@Override
	public Event<S> getNextEvent()
	{
		Event<S> e = q.get(indexOfFirst++);

		if (indexOfFirst == 1000)
		{
			q.removeRange(0, indexOfFirst);
			indexOfFirst = 0;
		}

		return e;
	}
	

	@Override
	public int size()
	{
		return q.size() - indexOfFirst;
	}

}