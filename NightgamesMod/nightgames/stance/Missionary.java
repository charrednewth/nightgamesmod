package nightgames.stance;


import nightgames.characters.Attribute;
import nightgames.characters.Character;
import nightgames.characters.body.BodyPart;
import nightgames.characters.body.PussyPart;
import nightgames.combat.Combat;
import nightgames.global.Global;

public class Missionary extends MaledomSexStance {

	public Missionary(Character top, Character bottom) {
		super(top, bottom,Stance.missionary);
	}

	@Override
	public String describe() {
		if(top.human()){
			return "You are penetrating "+bottom.name()+" in traditional Missionary position.";
		}
		else{
			return top.name()+"";
		}
	}
	public String image() {
		return "missionary.jpg";
	}
	@Override
	public boolean mobile(Character c) {
		return c==top;
	}

	@Override
	public boolean kiss(Character c) {
		return true;
	}

	@Override
	public boolean dom(Character c) {
		return c==top;
	}

	@Override
	public boolean sub(Character c) {
		return c==bottom;
	}

	@Override
	public boolean reachTop(Character c) {
		return true;
	}

	@Override
	public boolean reachBottom(Character c) {
		return c==top;
	}

	@Override
	public boolean prone(Character c) {
		return c==bottom;
	}

	@Override
	public boolean feet(Character c) {
		return false;
	}

	@Override
	public boolean oral(Character c) {
		return false;
	}

	@Override
	public boolean behind(Character c) {
		return false;
	}
	
	@Override
	public boolean inserted(Character c) {
		return c==top;
	}

	@Override
	public Position insertRandom() {
		return new Mount(top,bottom);
	}

	public Position reverse(Combat c) {
		boolean coiled = Global.random(2) == 0;
		if (coiled) {
		c.write(bottom, Global.format("{self:SUBJECT-ACTION:wrap|wraps} {self:possessive} legs around {other:name-possessive} waist and suddenly {self:action:pull|pulls} {other:direct-object} into a deep kiss. {other:SUBJECT-ACTION:are|is} so surprised by this sneak attack that {other:subject-action:don't|doesn't} "
				+ "even notice {self:pronoun} {self:action:rolling|rolling} {other:direct-object} onto {other:possessive} back until {other:subject-action:feel|feels} {self:possessive} weight on {other:possessive} hips. {self:PRONOUN} {self:action:move|moves} {self:possessive} hips experimentally, enjoying the control "
				+ "{self:pronoun} {self:action:have|has} in cowgirl position.", bottom, top));
		return new Cowgirl(bottom, top);
		} else {
			c.write(bottom, Global.format("{self:SUBJECT-ACTION:wrap|wraps} {self:possessive} legs around {other:name-possessive} waist and suddenly {self:action:pull|pulls} {other:direct-object} into a deep kiss. {other:SUBJECT-ACTION:are|is} so surprised by this sneak attack that {other:subject-action:don't|doesn't} "
					+ "even notice {self:reflective} getting trapped until {other:subject-action:feel|feels} {self:possessive} limbs wrapped around {other:possessive} body. {self:PRONOUN} {self:action:smile|smiles} widely, enjoying the control "
				+ "{self:pronoun} {self:action:have|has} coiled around {other:direct-object}.", bottom, top));
			return new Cowgirl(bottom, top);
		}
	}

	public static Position similarInstance(Character top, Character bottom) {
		if (top.get(Attribute.Power) > 25 && Global.random(2) == 0) {
			return new UpsideDownMaledom(top, bottom);
		}
		return new Missionary(top, bottom);
	}
}