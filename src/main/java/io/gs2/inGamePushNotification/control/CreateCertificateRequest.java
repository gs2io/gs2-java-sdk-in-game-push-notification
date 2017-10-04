/*
 * Copyright 2016 Game Server Services, Inc. or its affiliates. All Rights
 * Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package io.gs2.inGamePushNotification.control;

import io.gs2.control.Gs2UserRequest;
import io.gs2.inGamePushNotification.Gs2InGamePushNotification;

/**
 * @author Game Server Services, Inc.
 */
@SuppressWarnings("serial")
public class CreateCertificateRequest extends Gs2UserRequest<CreateCertificateRequest> {

	public static class Constant extends Gs2InGamePushNotification.Constant {
		public static final String FUNCTION = "CreateCertificate";
	}

	/** ゲームの名前 */
	String gameName;


	/**
	 * ゲームの名前を取得
	 *
	 * @return ゲームの名前
	 */
	public String getGameName() {
		return gameName;
	}

	/**
	 * ゲームの名前を設定
	 *
	 * @param gameName ゲームの名前
	 */
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	/**
	 * ゲームの名前を設定
	 *
	 * @param gameName ゲームの名前
	 * @return this
	 */
	public CreateCertificateRequest withGameName(String gameName) {
		setGameName(gameName);
		return this;
	}

}