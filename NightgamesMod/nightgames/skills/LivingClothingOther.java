package nightgames.skills;

import nightgames.characters.Attribute;
import nightgames.characters.Character;
import nightgames.combat.Combat;
import nightgames.combat.Result;
import nightgames.global.Global;
import nightgames.items.Item;
import nightgames.items.clothing.Clothing;

public class LivingClothingOther extends Skill {
	public LivingClothingOther(Character self) {
		super("Living Clothing: Other", self, 8);
	}

	@Override
	public boolean requirements(Combat c, Character user, Character target) {
		return user.get(Attribute.Science)>=15;
	}

	@Override
	public boolean usable(Combat c, Character target) {
		return getSelf().canAct()&&!c.getStance().mobile(target)&&c.getStance().mobile(getSelf())&&!c.getStance().inserted()&&target.torsoNude()&&getSelf().has(Item.Battery, 3);
	}

	@Override
	public String describe(Combat c) {
		return "Fabricate a living suit of tentacles to wrap around your opponent: 3 Batteries";
	}

	@Override
	public boolean resolve(Combat c, Character target) {
		getSelf().consume(Item.Battery, 3);
		if (getSelf().human()) {
			c.write(getSelf(), deal(c,0,Result.normal, target));
		} else {
			c.write(getSelf(), receive(c, 0, Result.normal, target));
		}
		getSelf().getOutfit().equip(Clothing.getByID("tentacletop"));
		getSelf().getOutfit().equip(Clothing.getByID("tentaclebottom"));
		return true;
	}

	@Override
	public Skill copy(Character user) {
		return new LivingClothingOther(user);
	}

	@Override
	public Tactics type(Combat c) {
		return Tactics.recovery;
	}

	@Override
	public String deal(Combat c, int damage, Result modifier, Character target) {
		String message;
		message = "You power up your fabricator and dial the knob to the emergency reclothing setting. "
				+ "You hit the button and dark tentacles squirm out of the device. "
				+ "You hold " + target.subject() + " down and point the tentacles at her body. "
				+ "The undulating tentacles coils around " + target.possessivePronoun()+" body and wraps itself into a living suit.";
		return message;
	}

	@Override
	public String receive(Combat c, int damage, Result modifier, Character target) {
		String message;
		message = "While holding you down, "+getSelf().subject()+" powers up " + getSelf().possessivePronoun() + " fabricator and dials the knob to the emergency reclothing setting. "
				+ Global.capitalizeFirstLetter(getSelf().pronoun()) + " hits the button and dark tentacles squirm out of the device."
						+ "The created tentacles coils around your body and wraps itself into a living suit.";
		return message;
	}

}
