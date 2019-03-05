package cn.util;

import com.cckaihui.admin.config.ConstConfig;
import com.dms.common.util.URLUtils;

public class PathUtils {
	
	public static String getActivationCodeApplyUrl(Integer startIndex, Integer count){
		
		StringBuilder url = new StringBuilder();
		url.append(ConstConfig.APPLY_LIST_API);
		url.append("?start_index=");
		url.append(startIndex);
		url.append("&count=");
		url.append(count);
		
		return url.toString();
	}
	
	public static String getSendActivationUrl(Integer applyId){
		
		StringBuilder url = new StringBuilder();
		url.append(ConstConfig.SEND_ACTIVATION_CODE_API);
		url.append("?apply_id=");
		url.append(applyId);
		
		return url.toString();
	}
	
	public static String getDeleteActivationCodeApplyUrl(Integer applyId){
		
		StringBuilder url = new StringBuilder();
		url.append(ConstConfig.DELETE_ACTIVATION_CODE_APPLY_API);
		url.append("?apply_id=");
		url.append(applyId);
		
		return url.toString();
	}

	public static String getUserListUrl(String keyword, Integer startIndex, Integer count){
		StringBuilder url = new StringBuilder();
		url.append(ConstConfig.KUICK_USER_LIST_API);

		if (keyword != null && keyword.trim().length()!=0) {
			url.append("?keyword=");
			url.append(URLUtils.encodeURL(keyword.trim()));

			if (startIndex != null) {
				url.append("&start_index=");
				url.append(startIndex);
				url.append("&count=");
				url.append(count);
			}
		} else {
			if (startIndex != null) {
				url.append("?start_index=");
				url.append(startIndex);
				url.append("&count=");
				url.append(count);
			}
		}

		return url.toString();
	}

	public static String addUserDueTimeURL(Integer kuickUserId) {
		StringBuilder url = new StringBuilder();
		url.append(ConstConfig.API_SERVER + "/account/" + kuickUserId + "/dueTime");

		return url.toString();
	}
}
