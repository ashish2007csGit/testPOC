package com.vuclip.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.vuclip.api.service.bean.enums.Carrier;
import com.vuclip.api.service.util.XinlabApiUtil;
import com.vuclip.model.ConstantCarrier;
import com.vuclip.model.UserVO;
import com.vuclip.service.IPValidationService;



/**
 * @author Ashish Mishra
 * 10-Sep-2016
 */
@Service("iPValidationService")
public class IPValidationServiceImpl implements IPValidationService{

	@Override
	public String validateDVSUser(UserVO user) {
		final Logger logger = LoggerFactory.getLogger(IPValidationServiceImpl.class);
		
		logger.info("Inside ValidateDVSUser service!");
		Carrier carrierFromIP = XinlabApiUtil.getCarrierFromIP(user.getUserRemoteIP());
		logger.info("carrier details Bean is {}. ",carrierFromIP);
		if(carrierFromIP !=null && (ConstantCarrier.DVS.equals(carrierFromIP.getName()) )){
			return ConstantCarrier.PASS;
		}else{
			return ConstantCarrier.FAIL;
		}
	}

}
