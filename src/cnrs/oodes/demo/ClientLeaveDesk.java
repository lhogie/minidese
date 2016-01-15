package cnrs.oodes.demo;

import cnrs.oodes.DES;
import cnrs.oodes.Event;

class ClientLeaveDesk extends Event<Office>
{
	final Desk d;

	public ClientLeaveDesk(DES<Office> simulation, double date, Desk c)
	{
		super(simulation, date);
		this.d = c;
	}

	@Override
	protected void execute()
	{
		Office shop = getSimulation().getSystem();

		if (!shop.queue.isEmpty())
		{
			d.customer = shop.queue.remove(0);
			getSimulation().getEventQueue().add(new ClientLeaveDesk(getSimulation(), getOccurenceDate()  + getSimulation().getPRNG().nextInt(3) + 1, d));
		}
	}

	@Override
	public String toString()
	{
		return "casher freed, accepting new client";
	}

}