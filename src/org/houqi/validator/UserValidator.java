package org.houqi.validator;

import org.houqi.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * ʵ��spring��volidator�ӿ�,���Զ�User�����������У�顣
 * ���ֱ�ʹ�� ValidationUtils��rejectIfEmpty��Errors��rejectvalue����
 * ��user����������У�飬@Repository���ö���ע��Ϊspring��bean����
 * @author HouQi

 *
 */
@Repository("userValidator")
public class UserValidator implements Validator{

	//��У�����ܶ�clazz���͵Ķ������У��
	@Override
	public boolean supports(Class<?> clazz) {
		//Userָ����class��������ʾ����ͽӿ��Ƿ���ͬ�����Ƿ����䳬��򳬽ӿ�
		return User.class.isAssignableFrom(clazz);
	}
	//��Ŀ��target����У�飬����У������¼��error��
	@Override
	public void validate(Object target, Errors errors) {
		/**
		 * ʹ��validationutils�е�һ����̬����rejectIfEmpty()����username���Խ���У�飬
		 * ����username��ֵΪnull����Ϊ""�Ļ�����ܾ�ͨ����֤��
		 */
		ValidationUtils.rejectIfEmpty(errors, "username", null, "�û�������Ϊ��");
		ValidationUtils.rejectIfEmpty(errors, "password", null, "���벻��Ϊ��");
		User user=(User) target;
		if(user.getUsername().length()>10){
			//ʹ��Error��rejectValue������֤
			errors.rejectValue("username", null, "�û������ܳ���ʮ���ַ�");
		}
		if(user.getPassword()!=null && !user.getPassword().equals("") && user.getPassword().length()<6){
			errors.rejectValue("password", null, "���벻�����������ַ�");
		}

	}

}
