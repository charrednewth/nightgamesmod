package nightgames.stance;


import nightgames.characters.Character;
import nightgames.characters.body.AnalPussyPart;
import nightgames.characters.body.BodyPart;
import nightgames.characters.body.PussyPart;
import nightgames.combat.Combat;
import nightgames.global.Global;

public class CoiledSex extends FemdomSexStance {

	public CoiledSex(Character top, Character bottom) {
		super(top, bottom,Stance.coiled);
	}

	public int pinDifficulty(Combat c, Character self) {
		return 8;
	}

	@Override
	public String describe() {
		if(top.human()){
			return "Your limbs are coiled around "+bottom.nameOrPossessivePronoun() + " body and " + bottom.possessivePronoun() + " cock is inside you.";
		} else {
			return "You're on top of " + top.nameDirectObject() + " with your cock trapped in her pussy and your face smothered in her cleavage.";
		}
	}

	public String image() {
		return "coiledsex.png";
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
		return c==top;
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
	public Position insertRandom() {
		return new Mount(top,bottom);
	}

	public Position reverse(Combat c) {
		c.write(bottom, Global.format("In a desperate gamble for dominance, {self:subject} piston wildly into {other:name-do}, making {other:direct-object} yelp and breaking {other:possessive} concentration. Shaking off {other:possessive} limbs coiled around {self:subject}, {self:subject} grab ahold of {other:possessive} legs and swing into a missionary position.", bottom, top));
		return new Missionary(bottom, top);
	}

	public double pheromoneMod (Character self) {
		return 10;
	}
}
