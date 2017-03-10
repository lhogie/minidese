package cnrs.oodes;

public class TerminationEvent extends Event
{

	public TerminationEvent(DES s, double date)
	{
		super(s, date);
	}

	@Override
	protected void execute()
	{
		throw new IllegalStateException("this event should never be executed");
	}

}
