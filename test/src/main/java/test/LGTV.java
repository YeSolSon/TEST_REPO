package test;

public class LGTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("엘지TV를 켠다.");
		
	}
	@Override
	public void powerOff() {
		System.out.println("엘지TV를 끈다.");
		
	}
	@Override
	public void volumeUp() {
		System.out.println("엘지TV의 볼륨을 높인다.");
		
	}
	@Override
	public void volumeDown() {
		System.out.println("엘지TV의 볼륨을 낮춘다.");
		
	}
}
