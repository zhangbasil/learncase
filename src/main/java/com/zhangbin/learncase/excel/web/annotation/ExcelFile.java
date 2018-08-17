package com.zhangbin.learncase.excel.web.annotation;

import com.zhangbin.learncase.excel.emun.ExcelFileType;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelFile {

	String value() default "";
	
	ExcelFileType excelType() default ExcelFileType.XLS;
}
