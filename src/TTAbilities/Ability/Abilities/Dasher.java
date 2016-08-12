package TTAbilities.Ability.Abilities;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.block.Action;

import TTAbilities.TTAbilitiesPlugin;
import TTAbilities.Ability.Ability;
import TTCore.Entity.Living.Human.Player.TTPlayer;

public class Dasher implements Ability{
	
	boolean ACTIVATE;
	boolean ACTIVE;
	
	@Override
	public String getName() {
		return "Dasher";
	}
	
	@Override
	public boolean onSneak(TTPlayer player, boolean isAboutToSneak) {
		return false;
	}
	
	@Override
	public boolean onSprint(TTPlayer player, boolean isAboutToSprint) {
		return false;
	}
	
	@Override
	public boolean onShiftClick(TTPlayer player, Action action, Location loc) {
		if(ACTIVATE && (action.equals(Action.RIGHT_CLICK_AIR))){
			activate(player);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean onJump(TTPlayer player, Location before, Location after) {
		return false;
	}
	
	public void activate(TTPlayer player){
		ACTIVATE = false;
		ACTIVE = true;
		player.getPlayer().setWalkSpeed(5);
		Bukkit.getScheduler().scheduleSyncDelayedTask(TTAbilitiesPlugin.getPlugin(), new Runnable(){

			@Override
			public void run() {
				player.getPlayer().setWalkSpeed(0.2f);
			}
			
		}, (20*5));
	}
	

}
