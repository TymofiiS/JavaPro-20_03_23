package ua.ithillel.hw19;

public class TestClassCorrect {
	@BeforeSuiteCustom
	public void bfc() {
		System.out.println("bfc invoked");
	}
	
	@AfterSuiteCustom
	public void asc() {
		System.out.println("asc invoked");
	}
	
	@TestCustom(priority = 2)
	public void test2() {
		System.out.println("test2 invoked");			
	}
	
	@TestCustom(priority = 1)
	public void test1() {
		System.out.println("test1 invoked");			
	}
	
	@TestCustom(priority = 1)
	public void test1_1() {
		System.out.println("test1_1 invoked");			
	}
}
