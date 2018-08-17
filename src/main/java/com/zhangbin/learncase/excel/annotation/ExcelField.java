package com.zhangbin.learncase.excel.annotation;

import com.zhangbin.learncase.excel.emun.DataType;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelField {

	String headName() default "";
	
	String dataFormat() default "";
	
	String dateFormat() default "";
	
	DataType dataType() default DataType.None;
	
	boolean required() default false;
	
	int sort() default 100;
	
	short width() default -1;
	
	boolean autoWidth() default true;
		
	Class<?> exportProcessor() default Void.class;
	
	Class<?> importProcessor() default Void.class;
}
