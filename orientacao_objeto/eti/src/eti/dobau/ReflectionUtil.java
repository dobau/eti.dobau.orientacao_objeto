package eti.dobau;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Clas utilitária utilizada para facilitar o uso do reflections.
 * 
 * @author dobau
 * @sine 02/05/2010
 */
public class ReflectionUtil {

	public static Method getMethod(Object obj, String metodo) {
		return getMethod(obj.getClass(), metodo, new Class[] {});
	}

	public static Method getMethod(Class<?> c, String metodo) {
		return getMethod(c, metodo, new Class[] {});
	}

	public static Method getMethod(Object obj, String metodo, Class<?>... args) {
		return getMethod(obj.getClass(), metodo, args);
	}

	public static Method getMethod(Class<?> c, String metodo, Class<?>... args) {
		try {
			return c.getMethod(metodo, args);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
	}

	public static Object call(Class<?> c, String metodo, Object... args) {
		try {
			
			Class classes[] = new Class[args.length];
			
			int i = 0;
			for (Object o : args) {
				classes[i++] = o.getClass();
			}
			
			return c.getMethod(metodo, classes).invoke(c, args);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
