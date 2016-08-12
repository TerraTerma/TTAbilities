package TTAbilities.Mechs;

import java.util.Optional;

import TTAbilities.Ability.Ability;
import TTAbilities.Ability.Abilities.None;
import TTCore.Mech.DataHandlers.PlayerData;
import TTCore.Mech.DataHandlers.SavableData;
import TTCore.Savers.Saver;

public class AbilityData implements SavableData, PlayerData {
	
	public static String DATA_ABILITY = "Ability";

	Ability ABILITY;
	Ability SAVE_ABILITY;
	
	public Ability getCurrentAbility(){
		return ABILITY;
	}
	
	public Ability getAbility(){
		return SAVE_ABILITY;
	}
	
	public boolean setCurrentAbility(Class<? extends Ability> ability){
		try {
			ABILITY = ability.newInstance();
			return true;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean setAbility(Class<? extends Ability> ability){
		try {
			SAVE_ABILITY = ability.newInstance();
			ABILITY = SAVE_ABILITY;
			return true;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public void save(Saver saver) {
		saver.set(SAVE_ABILITY.getClass().getSimpleName(), DATA_ABILITY);
	}

	@Override
	public boolean load(Saver saver) {
		String abilityS = saver.get(String.class, DATA_ABILITY);
		if(abilityS != null){
			Optional<Class<? extends Ability>> opAbility = Ability.getAbilityClass(abilityS);
			if(opAbility.isPresent()){
				setAbility(opAbility.get());
				return true;
			}
		}
		setAbility(None.class);
		return true;
	}

}
