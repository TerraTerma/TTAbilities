package TTAbilities.Ability;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bukkit.Location;
import org.bukkit.event.block.Action;

import TTAbilities.Ability.Abilities.Dasher;
import TTAbilities.Ability.Abilities.None;
import TTCore.Entity.Living.Human.Player.TTPlayer;

public interface Ability {
	
	public static List<Class<? extends Ability>> ABILITIES = new ArrayList<>();
	
	public static Class<Dasher> DASHER = addAbility(Dasher.class);
	public static Class<None> NONE = addAbility(None.class);
	
	public String getName();
	public boolean onSneak(TTPlayer player, boolean isAboutToSneak);
	public boolean onSprint(TTPlayer player, boolean isAboutToSprint);
	public boolean onShiftClick(TTPlayer player, Action action, Location loc);
	public boolean onJump(TTPlayer player, Location before, Location after);
	
	public static <T extends Ability> Class<T> addAbility(Class<T> ability){
		ABILITIES.add(ability);
		return ability;
	}
	
	public static <T extends Ability> T createAbility(Class<T> ability){
		try {
			return ability.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Optional<Class<? extends Ability>> getAbilityClass(String name){
		return ABILITIES.stream().filter(a -> a.getSimpleName().equals(name)).findFirst();
	}

}
