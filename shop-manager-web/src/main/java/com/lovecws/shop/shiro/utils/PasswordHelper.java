/*
 * Copyright 2015-2102 RonCoo(http://www.roncoo.com) Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lovecws.shop.shiro.utils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.lovecws.shop.shiro.entity.BaseRealm;

/**
 * @desc 生成密码工具类
 * @author ganliang
 * @version 2016年8月29日 上午11:18:34
 */
public class PasswordHelper {

	private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

	private static String algorithmName = "md5";

	private static String hashIteration = "2";

	private static int hashIterations = Integer.valueOf(hashIteration);

	/**
	 * 加密密码
	 * @param merUser
	 */
	public static BaseRealm encryptPassword(BaseRealm realm) {
		realm.setSalt(randomNumberGenerator.nextBytes().toHex());
		String credentialsSalt = realm.getUserName() + realm.getSalt();
		String newPassword = new SimpleHash(algorithmName, realm.getPassword(),
				ByteSource.Util.bytes(credentialsSalt), hashIterations).toHex();

		realm.setPassword(newPassword);
		return realm;
	}

	/**
	 * 加密密码
	 * @param loginPwd 明文密码
	 * @param salt 密文
	 * @return
	 */
	public static String getPwd(String loginPwd, String salt) {
		String newPassword = new SimpleHash(algorithmName, loginPwd, ByteSource.Util.bytes(salt), hashIterations)
				.toHex();
		return newPassword;
	}
	
	public static void main(String[] args) {
		BaseRealm realm=new BaseRealm();
		realm.setUserName("admin");
		realm.setPassword("123");
		encryptPassword(realm);
		System.out.println(realm);
	}

}
