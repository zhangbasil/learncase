package com.zhangbin.learncase.excel.annotation;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Font;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *  * 设置字体注解
 * @see Font
 * @author qinmian
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExportFontStyle {
	
	short boldweight() default Font.BOLDWEIGHT_NORMAL;
	
	short color() default HSSFColor.BLACK.index;
		
	short fontHeightInPoints() default 10;
	
	String fontName() default "微软雅黑";
	
	boolean italic() default false;
	
	boolean strikeout() default false;
	
	short typeOffset() default Font.SS_NONE;
	
	byte underline() default Font.U_NONE;
}
