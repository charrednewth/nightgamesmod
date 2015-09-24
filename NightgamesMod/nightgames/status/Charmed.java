package nightgames.status;

import org.json.simple.JSONObject;

import nightgames.characters.Attribute;
import nightgames.characters.Character;
import nightgames.characters.Emotion;
import nightgames.combat.Combat;

public class Charmed extends DurationStatus {
	public Charmed(Character affected) {
		super("Charmed", affected, 5);
		flag(Stsflag.charmed);
	}
	
	public Charmed(Character affected, int duration) {
		this(affected);
		super.setDuration(duration);
	}

	@Override
	public String describe(Combat c) {
		if(affected.human()){
			return "You feel an irresistible attraction to her and can't imagine harming her.";
		}
		else{
			return affected.name()+" is looking at you like a lovestruck teenager.";
		}
	}

	@Override
	public boolean mindgames(){
		return true;
	}
	
	@Override
	public float fitnessModifier () {
		return - (2 + getDuration() / 2.0f);
	}

	@Override
	public int mod(Attribute a) {
		return 0;
	}

	@Override
	public void onRemove(Combat c, Character other) {
		affected.addlist.add(new Cynical(affected));
	}

	@Override
	public void tick(Combat c) {
		affected.emote(Emotion.horny,15);
		affected.loseWillpower(c, 1, 0, false, " (Charmed)");
	}

	@Override
	public int damage(Combat c, int x) {
		return 0;
	}

	@Override
	public double pleasure(Combat c, double x) {
		return 0;
	}

	@Override
	public String initialMessage(Combat c, boolean replaced) {
		return String.format("%s now charmed.\n", affected.subjectAction("are", "is"));
	}

	@Override
	public int weakened(int x) {
		return 0;
	}

	@Override
	public int tempted(int x) {
		return 3;
	}

	@Override
	public int evade() {
		return 0;
	}

	@Override
	public int escape() {
		return -10;
	}

	@Override
	public int gainmojo(int x) {
		return 0;
	}

	@Override
	public int spendmojo(int x) {
		return 0;
	}
	@Override
	public int counter() {
		return -10;
	}

	@Override
	public int value() {
		return 0;
	}
	@Override
	public Status instance(Character newAffected, Character newOther) {
		return new Charmed(newAffected);
	}
	@SuppressWarnings("unchecked")
	public JSONObject saveToJSON() {
		JSONObject obj = new JSONObject();
		obj.put("type", getClass().getSimpleName());
		return obj;
	}

	public Status loadFromJSON(JSONObject obj) {
		return new Charmed(null);
	}
}
