package types;

import java.util.Collection;
import java.util.Vector;

//This is a Java class with wildcards
public class Wild {
	public Collection<?> contents() {
		Collection<String> stuff = new Vector<String>();
		stuff.add("a");
		stuff.add("b");
		stuff.add("see");
		return stuff;
	}
}