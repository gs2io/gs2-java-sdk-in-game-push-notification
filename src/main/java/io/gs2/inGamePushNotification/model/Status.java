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
 * オンラインステータス
 *
 * @author Game Server Services, Inc.
 *
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Status implements Serializable {

	/** ステータス */
	String status;

	/** 登録日時 */
	Integer createAt;

	/** ユーザID */
	String userId;

	/** Firebaseトークン */
	String fcmToken;


	/**
	 * ステータスを取得
	 *
	 * @return ステータス
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * ステータスを設定
	 *
	 * @param status ステータス
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 登録日時を取得
	 *
	 * @return 登録日時
	 */
	public Integer getCreateAt() {
		return createAt;
	}

	/**
	 * 登録日時を設定
	 *
	 * @param createAt 登録日時
	 */
	public void setCreateAt(Integer createAt) {
		this.createAt = createAt;
	}

	/**
	 * ユーザIDを取得
	 *
	 * @return ユーザID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * ユーザIDを設定
	 *
	 * @param userId ユーザID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Firebaseトークンを取得
	 *
	 * @return Firebaseトークン
	 */
	public String getFcmToken() {
		return fcmToken;
	}

	/**
	 * Firebaseトークンを設定
	 *
	 * @param fcmToken Firebaseトークン
	 */
	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}

}