package org.houqi.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * �Զ�������ת�����ַ���ת����
 * @author HouQi
 *
 */
public class StringToDateConvert implements Converter<String, Date>{
	//��������ģ�壬�磺yyyy-MM-dd
	private String datePattern;

	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}
	// Converter<S,T>�ӿڵ�����ת������
	@Override
	public Date convert(String date) {
		SimpleDateFormat sdf=new SimpleDateFormat(this.datePattern);
		
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			System.out.println("����ת����ʽ����!");
			e.printStackTrace();
			return null;
		}
	}
	
}
