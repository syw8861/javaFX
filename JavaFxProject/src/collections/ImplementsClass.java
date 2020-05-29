package collections;

interface Runnable<T>
{
	public void run(T t);
}

class Car implements Runnable<String>
{
	@Override
	public void run(String str)
	{
		System.out.println("자동차가 달린다.");
	}

}

class Bus implements Runnable<String>
{
	@Override
	public void run(String intValue)
	{
		System.out.println("버스가 달린다.");
	}
}

public class ImplementsClass
{
	// 메소드 구현
	public static void callRun(Runnable<String> runnable)
	{
		runnable.run("Hello");
	}

	public static void main(String[] args)
	{
		Runnable runnable = new Car();
		runnable.run("Car");
		runnable = new Bus();
		runnable.run("Bus");

		// 익명객체생성
		runnable = (str) -> // 람다표현식으로 익명객체생성
		{
			System.out.println("달린다");
		};
		runnable.run("Run"); // 익명객체 실행
		callRun(new Car()); // 메소드
		callRun((str)-> System.out.println("메소드 매개값 달립니다."));
	}
}