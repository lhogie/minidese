package cnrs.oodes.demo;

import java.util.ArrayList;
import java.util.List;

class Office
{
	public Office(int numberOfDesks)
	{
		for (int i = 0; i < numberOfDesks; ++i)
		{
			desks.add(new Desk());
		}
	}

	List<Desk> desks = new ArrayList<Desk>();
	List<Customer> queue = new ArrayList<Customer>();
}