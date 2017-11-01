package org.houqi.validator;

import org.houqi.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * 实现spring的volidator接口,可以对User对象进行数据校验。
 * 并分别使用 ValidationUtils的rejectIfEmpty和Errors的rejectvalue方法
 * 对user进行了数据校验，@Repository将该对象注释为spring的bean对象
 * @author HouQi

 *
 */
@Repository("userValidator")
public class UserValidator implements Validator{

	//该校验器能对clazz类型的对象进行校验
	@Override
	public boolean supports(Class<?> clazz) {
		//User指定的class参数所表示的类和接口是否相同，或是否是其超类或超接口
		return User.class.isAssignableFrom(clazz);
	}
	//对目标target进行校验，并将校验错误记录在error中
	@Override
	public void validate(Object target, Errors errors) {
		/**
		 * 使用validationutils中的一个静态方法rejectIfEmpty()来对username属性进行校验，
		 * 假如username的值为null或者为""的话，则拒绝通过验证。
		 */
		ValidationUtils.rejectIfEmpty(errors, "username", null, "用户名不能为空");
		ValidationUtils.rejectIfEmpty(errors, "password", null, "密码不能为空");
		User user=(User) target;
		if(user.getUsername().length()>10){
			//使用Error的rejectValue方法验证
			errors.rejectValue("username", null, "用户名不能超过十个字符");
		}
		if(user.getPassword()!=null && !user.getPassword().equals("") && user.getPassword().length()<6){
			errors.rejectValue("password", null, "密码不能少于六个字符");
		}

	}

}
