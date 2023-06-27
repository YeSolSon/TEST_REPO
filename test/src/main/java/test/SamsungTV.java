package test;

public class SamsungTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("삼성TV로 전원을 켠다.");
	}
	@Override
	public void powerOff() {
		System.out.println("삼성TV로 전원을 끈다.");
	}
	@Override
	public void volumeUp() {
		System.out.println("삼성TV로 볼륨을 높인다.");
	}
	@Override
	public void volumeDown() {
		System.out.println("삼성TV로 볼륨을 줄인다.");
	}
}
