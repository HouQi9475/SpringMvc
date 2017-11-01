package org.houqi.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 自定义类型转换：字符串转日期
 * @author HouQi
 *
 */
public class StringToDateConvert implements Converter<String, Date>{
	//日期类型模板，如：yyyy-MM-dd
	private String datePattern;

	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}
	// Converter<S,T>接口的类型转换方法
	@Override
	public Date convert(String date) {
		SimpleDateFormat sdf=new SimpleDateFormat(this.datePattern);
		
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			System.out.println("日期转换格式错误!");
			e.printStackTrace();
			return null;
		}
	}
	
}
