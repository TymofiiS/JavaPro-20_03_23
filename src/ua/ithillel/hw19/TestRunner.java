package ua.ithillel.hw19;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ua.ithillel.hw_orm.Column;


public class TestRunner {
	
	public static <T> void start(Class<T> type) {
		
		// Get executing ordered methods
		List<Method> methods = testClassOrderedMethods(type);
		
		// Create test-class object
		T obj = null;
		try {
			obj = type.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException |
				IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		// Invoke each method
		for (Method method : methods) {
			try {
				method.setAccessible(true);
				method.invoke(obj);
			} catch (IllegalAccessException | 
					IllegalArgumentException | 
					InvocationTargetException e) {
				e.printStackTrace();
			}
			finally {
				method.setAccessible(false);
			}
		}	
	}
	
	private static <T> List<Method> testClassOrderedMethods(
			Class<T> type) {
		
		// Check initial data
		if(type == null) 
			{throw new IncorrectStructure("null");}
		
		// Init result
		List<Method> result = new ArrayList<>();
		
		// Get BeforeSuiteCustom and ensure only one
		List<Method> bss = 
				Arrays.asList(type.getDeclaredMethods())
				.stream()
				.filter(x->
					x.getAnnotationsByType(BeforeSuiteCustom.class).length > 0)
				.toList();
		if(bss == null || bss.size() > 1 ) 
			{throw new IncorrectStructure("BeforeSuiteCustom count not one");}
		result.add(bss.get(0));
		
		// Get TestCustom and ensure more then zero
		List<Method> tss = 
				Arrays.asList(type.getDeclaredMethods())
				.stream()
				.filter(x->
					x.getAnnotationsByType(TestCustom.class).length > 0)
				.sorted((a,b) -> 
					Integer.compare(
						a.getAnnotation(TestCustom.class).priority(),
						b.getAnnotation(TestCustom.class).priority()))
				.toList();
		if(tss == null || tss.size() == 0 ) 
			{throw new IncorrectStructure("TestCustom not found");}
		result.addAll(tss);
		
		// Get AfterSuiteCustom and ensure only one
		List<Method> ass = 
				Arrays.asList(type.getDeclaredMethods())
				.stream()
				.filter(x->
					x.getAnnotationsByType(AfterSuiteCustom.class).length > 0)
				.toList();
		if(ass == null || ass.size() > 1 ) 
			{throw new IncorrectStructure("AfterSuiteCustom count not one");}
		result.add(ass.get(0));
		
		// Result
		return result;
	}
}
