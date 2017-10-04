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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.gs2.inGamePushNotification.model.Certificate;


/**
 * @author Game Server Services, Inc.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class CreateCertificateResult {

	/** クライアント証明書 */
	Certificate item;


	/**
	 * クライアント証明書を取得
	 *
	 * @return クライアント証明書
	 */
	public Certificate getItem() {
		return item;
	}

	/**
	 * クライアント証明書を設定
	 *
	 * @param item クライアント証明書
	 */
	public void setItem(Certificate item) {
		this.item = item;
	}

}