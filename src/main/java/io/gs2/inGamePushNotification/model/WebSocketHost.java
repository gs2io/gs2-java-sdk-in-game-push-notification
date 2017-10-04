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

package io.gs2.inGamePushNotification.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * MQTT over WebSocketサーバ
 *
 * @author Game Server Services, Inc.
 *
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown=true)
public class WebSocketHost implements Serializable {

	/** エンドポイント名 */
	String endpoint;


	/**
	 * エンドポイント名を取得
	 *
	 * @return エンドポイント名
	 */
	public String getEndpoint() {
		return endpoint;
	}

	/**
	 * エンドポイント名を設定
	 *
	 * @param endpoint エンドポイント名
	 */
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

}