package ua.ithillel.hw19;

public class TestClassIncorrect {
	@BeforeSuiteCustom
	public void bfc() {
		System.out.println("bfc invoked");
	}
	
	@AfterSuiteCustom
	public void asc() {
		System.out.println("asc invoked");
	}
	
	@AfterSuiteCustom
	public void asc1() {
		System.out.println("asc1 invoked");
	}
	
	@TestCustom(priority = 1)
	public void test1() {
		System.out.println("test1 invoked");			
	}
}
