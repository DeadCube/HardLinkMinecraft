package fr.fir3rl.hardlink.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class HardLinkRequestEvent extends Event {

	private static final HandlerList handlers = new HandlerList();

	private String data = "";
	private String key = "";

	@Override
	public HandlerList getHandlers() {
	 
	return handlers;
	}
	 
	public static HandlerList getHandlerList() {
	return handlers;
	}
	

	/**
	 * Call an HardLinkRequestEvent
	 * 
	 * @param key  Identifier for this event
	 * @param data Data for this event
	 * @author Fir3rl
	 */
	public HardLinkRequestEvent(String key, String data) {
		this.data = data;
		this.key = key;
	}

	/**
	 * Get data from this event
	 * 
	 * @return data
	 */
	public String getData() {
		return this.data;
	}

	/**
	 * Get key from this event wich is a single word without spaces
	 * @return key
	 */
	public String getKey() {
		return key;
	}
}
