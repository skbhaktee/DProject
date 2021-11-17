package util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HmapTest {

	public static void main(String[] args) {

		HashMap<String, String> hmap = new HashMap<String, String>();

		hmap.put("UserName", "Steve1");
		hmap.put("UserName", "Steve2");
		hmap.put("UserName", "Steve3");
		hmap.put("UserName", "Steve4");
		hmap.put("UserName", "Steve5");
		hmap.put("UserName", "Steve6");
		hmap.put("Password", "Steve7");

		for (Entry m : hmap.entrySet()) {
			System.out.println(m.getKey() + "=" + m.getValue());
		}

	}

}
