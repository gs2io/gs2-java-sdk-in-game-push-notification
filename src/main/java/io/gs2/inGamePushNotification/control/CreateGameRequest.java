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

import java.util.List;
import io.gs2.inGamePushNotification.Gs2InGamePushNotification;
import io.gs2.control.Gs2BasicRequest;

/**
 * @author Game Server Services, Inc.
 */
@SuppressWarnings("serial")
public class CreateGameRequest extends Gs2BasicRequest<CreateGameRequest> {

	public static class Constant extends Gs2InGamePushNotification.Constant {
		public static final String FUNCTION = "CreateGame";
	}

	/** サービスクラス */
	private String serviceClass;

	/** Firebaseのサーバーキー */
	private String notificationFirebaseServerKey;

	/** ゲーム名 */
	private String name;

	/** オフライン転送先URL */
	private String notificationUrl;

	/** オフライン転送方式 */
	private String offlineTransfer;

	/** 説明文 */
	private String description;


	/**
	 * サービスクラスを取得
	 *
	 * @return サービスクラス
	 */
	public String getServiceClass() {
		return serviceClass;
	}

	/**
	 * サービスクラスを設定
	 *
	 * @param serviceClass サービスクラス
	 */
	public void setServiceClass(String serviceClass) {
		this.serviceClass = serviceClass;
	}

	/**
	 * サービスクラスを設定
	 *
	 * @param serviceClass サービスクラス
	 * @return this
	 */
	public CreateGameRequest withServiceClass(String serviceClass) {
		setServiceClass(serviceClass);
		return this;
	}

	/**
	 * Firebaseのサーバーキーを取得
	 *
	 * @return Firebaseのサーバーキー
	 */
	public String getNotificationFirebaseServerKey() {
		return notificationFirebaseServerKey;
	}

	/**
	 * Firebaseのサーバーキーを設定
	 *
	 * @param notificationFirebaseServerKey Firebaseのサーバーキー
	 */
	public void setNotificationFirebaseServerKey(String notificationFirebaseServerKey) {
		this.notificationFirebaseServerKey = notificationFirebaseServerKey;
	}

	/**
	 * Firebaseのサーバーキーを設定
	 *
	 * @param notificationFirebaseServerKey Firebaseのサーバーキー
	 * @return this
	 */
	public CreateGameRequest withNotificationFirebaseServerKey(String notificationFirebaseServerKey) {
		setNotificationFirebaseServerKey(notificationFirebaseServerKey);
		return this;
	}

	/**
	 * ゲーム名を取得
	 *
	 * @return ゲーム名
	 */
	public String getName() {
		return name;
	}

	/**
	 * ゲーム名を設定
	 *
	 * @param name ゲーム名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ゲーム名を設定
	 *
	 * @param name ゲーム名
	 * @return this
	 */
	public CreateGameRequest withName(String name) {
		setName(name);
		return this;
	}

	/**
	 * オフライン転送先URLを取得
	 *
	 * @return オフライン転送先URL
	 */
	public String getNotificationUrl() {
		return notificationUrl;
	}

	/**
	 * オフライン転送先URLを設定
	 *
	 * @param notificationUrl オフライン転送先URL
	 */
	public void setNotificationUrl(String notificationUrl) {
		this.notificationUrl = notificationUrl;
	}

	/**
	 * オフライン転送先URLを設定
	 *
	 * @param notificationUrl オフライン転送先URL
	 * @return this
	 */
	public CreateGameRequest withNotificationUrl(String notificationUrl) {
		setNotificationUrl(notificationUrl);
		return this;
	}

	/**
	 * オフライン転送方式を取得
	 *
	 * @return オフライン転送方式
	 */
	public String getOfflineTransfer() {
		return offlineTransfer;
	}

	/**
	 * オフライン転送方式を設定
	 *
	 * @param offlineTransfer オフライン転送方式
	 */
	public void setOfflineTransfer(String offlineTransfer) {
		this.offlineTransfer = offlineTransfer;
	}

	/**
	 * オフライン転送方式を設定
	 *
	 * @param offlineTransfer オフライン転送方式
	 * @return this
	 */
	public CreateGameRequest withOfflineTransfer(String offlineTransfer) {
		setOfflineTransfer(offlineTransfer);
		return this;
	}

	/**
	 * 説明文を取得
	 *
	 * @return 説明文
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 説明文を設定
	 *
	 * @param description 説明文
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 説明文を設定
	 *
	 * @param description 説明文
	 * @return this
	 */
	public CreateGameRequest withDescription(String description) {
		setDescription(description);
		return this;
	}

}