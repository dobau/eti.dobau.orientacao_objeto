package eti.dobau;

import java.lang.reflect.Method;

public class DynamicCall {

	private Object objeto;
	private Method metodo;
	private Object[] args;

	public DynamicCall(Object obj, String metodo, Object... args) {
		this.objeto = obj;
		this.metodo = ReflectionUtil.getMethod(obj, metodo);
		this.args = args;
	}

	public Object execute() {
		try {
			Class classes[] = new Class[args.length];

			int i = 0;
			for (Object o : args) {
				classes[i++] = o.getClass();
			}

			metodo.setAccessible(true);
			return metodo.invoke(objeto, args);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Object getObjeto() {
		return objeto;
	}

	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}

	public Method getMetodo() {
		return metodo;
	}

	public void setMetodo(Method metodo) {
		this.metodo = metodo;
	}
	
	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}

}
