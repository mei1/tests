package test;

public abstract class Mazda extends Accessories implements Car {

	@Override
	public String engine() {
		return "1000cc";
	}

	@Override
	public String steering() {
		return "average";
	}

}
