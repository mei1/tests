package test;

public class BMW extends Accessories implements Car  {

	@Override
	public String engine() {
		return "3000cc";
	}

	@Override
	public String steering() {
		return "good";
	}

	@Override
	public String ac() {
		return "500w";
	}

}
