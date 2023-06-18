package main.lab1.utils;

import java.util.Comparator;

import main.lab1.DTOs.Actor;

public class ActorComparator implements Comparator<Actor>{

	@Override
	public int compare(Actor o1, Actor o2) {
		 return Float.compare(o2.getRating(), o1.getRating());
	}

}
