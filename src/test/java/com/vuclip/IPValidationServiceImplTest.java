package com.vuclip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vuclip.model.ConstantCarrier;
import com.vuclip.model.UserVO;
import com.vuclip.service.IPValidationService;

@Test
@ContextConfiguration(locations = { "classpath:spring-test-config.xml" })
public class IPValidationServiceImplTest extends AbstractTestNGSpringContextTests{
	@Autowired
	IPValidationService iPValidationService;


	@Test(dataProvider = "IP-DataProvider",invocationCount=1,enabled=true)
	public void validateDVSUser(UserVO user,String expectedResult) {
		String validateDVSUser = iPValidationService.validateDVSUser(user);
		Assert.assertEquals(expectedResult,validateDVSUser);
	}

	@DataProvider(name = "IP-DataProvider")
	private Object[][] setUserObject() {
		UserVO user = new UserVO();;
		user.setUserRemoteIP("1.39.1.1");
		
		UserVO user1 = new UserVO();;
		user1.setUserRemoteIP("1.39.1.2");
		
		UserVO user2 = new UserVO();;
		user2.setUserRemoteIP("-1");
		
		UserVO user3 = new UserVO();;
		user3.setUserRemoteIP("1232298298393893839389383");
		
		UserVO user4 = new UserVO();;
		user4.setUserRemoteIP("5.31.205.218");
		
		
		
		 return new Object[][] { { user,ConstantCarrier.FAIL}, { user1,ConstantCarrier.FAIL},{user2,ConstantCarrier.FAIL},{user3,ConstantCarrier.FAIL},{user4,ConstantCarrier.PASS} };
	}


}
