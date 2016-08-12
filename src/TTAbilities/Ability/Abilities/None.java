package TTAbilities.Ability.Abilities;

import org.bukkit.Location;
import org.bukkit.event.block.Action;

import TTAbilities.Ability.Ability;
import TTCore.Entity.Living.Human.Player.TTPlayer;

public class None implements Ability{

	@Override
	public String getName() {
		return "None";
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
		return false;
	}

	@Override
	public boolean onJump(TTPlayer player, Location before, Location after) {
		return false;
	}

}
