package xyz.lihang.blog.tool.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import xyz.lihang.blog.annotation.DataFinal;

public class BeanUpdateUtils {
	
	
	/**
	 * 简化Bean 修改操作
	 * 	两个Bean必须类型相同
	 * 		按照约定修改属性 
	 *  通过反射   
	 *  
	 *  @param o1 待修改的对象
	 *  @param o2 原对象
	 * @return  o1
	 */
	public static Object objClone(Object o1 ,Object o2){
		
		if(o1 == null || o2 == null ){
			return o1;
		}
		
		//判断像个对象类型是否一致
		//不一致直接返回
		if(o1.getClass()!=o2.getClass()){
			return o1;
		}
		Class clazz = o1.getClass();
		Field[] declaredFields = clazz.getDeclaredFields();
		
		//烧苗注解
		for(Field ff : declaredFields){
			//关闭安全检查
			ff.setAccessible(true);
			Annotation[] annotations = ff.getDeclaredAnnotations();
			//System.out.println(Arrays.toString(annotations));
			//是否使用了DataFinal的注解
			//使用了就跳过
			if(annotations==null || annotations.length == 0){
				try {
					ff.set(o1, ff.get(o2));
				} catch (Exception e) {
					e.printStackTrace();
				} 	
			}else{
				for(Annotation annotation : annotations){
				//	System.out.println(ff.getName() + " ------------------ " + annotation.annotationType());
					if(annotation.annotationType() != DataFinal.class){
						//将o2的值给o1
						try {
							ff.set(o1, ff.get(o2));
						} catch (Exception e) {
							e.printStackTrace();
						} 	
					}
					
				}
			}
		}
		return o1;
	}

}
