package cnrs.oodes.demo;

import cnrs.oodes.DES;
import cnrs.oodes.Event;

class ClientLeaveDesk extends Event<Office>
{
	final Desk desk;

	public ClientLeaveDesk(DES<Office> simulation, double date, Desk c)
	{
		super(simulation, date);
		this.desk = c;
	}

	@Override
	protected void execute()
	{
		Office shop = getSimulation().getSystem();

		if ( ! shop.queue.isEmpty())
		{
			desk.customer = shop.queue.remove(0);
			double d = future(getSimulation().getPRNG().nextDouble() * 3);
			getSimulation().getEventQueue().add(new ClientLeaveDesk(getSimulation(),
					d, desk));
		}
	}



	@Override
	public String toString()
	{
		return "casher freed, accepting new client";
	}

}