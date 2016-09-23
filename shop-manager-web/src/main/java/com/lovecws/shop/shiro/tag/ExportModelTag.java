package com.lovecws.shop.shiro.tag;

import org.apache.velocity.tools.Scope;
import org.apache.velocity.tools.config.DefaultKey;
import org.apache.velocity.tools.config.ValidScope;

@DefaultKey("model")
@ValidScope(Scope.APPLICATION)
public class ExportModelTag {

	/**
	 * 判断是否存在model
	 * @param modelName
	 * @return
	 */
	public boolean exists(String modelName){
		if(modelName==null||"".equals(modelName)){
			return false;
		}
		return false;
	}
}
