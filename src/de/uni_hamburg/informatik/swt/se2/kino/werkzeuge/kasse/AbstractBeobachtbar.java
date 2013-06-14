package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.kasse;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractBeobachtbar {
	Set<Beobachter> _beobachter;
	
	public AbstractBeobachtbar()
	{
		_beobachter = new HashSet<Beobachter>();
	}
	
	/**
	 * Fügt einen neuen Beobachter hinzu
	 * @param b Beobachter der hinzugefügt werden soll
	 * @require b != null (&& _beobachter enthält nicht bereits den Beobachter)
	 * @ensure Beobachter ist in der Menge der Beobachter gespeichert
	 */
	public void setBeobachter(Beobachter b)
	{
		//assert !_beobachter.contains(b) : "Vorbedingung verletzt, Beobachter darf nicht bereits in der Menge sein";
		assert b != null : "Beobachter darf nicht null sein";
		_beobachter.add(b);
	}

	/**
	 * Meldet jedem Beobachter, dass er auf Änderungen reagieren soll
	 */
	public void meldeAenderung()
	{
		java.util.Iterator<Beobachter> it = _beobachter.iterator();
		
		while(it.hasNext())
		{
			Beobachter b = (Beobachter) it.next();
			b.reagiereAufAenderungen();
		}
	}
}
