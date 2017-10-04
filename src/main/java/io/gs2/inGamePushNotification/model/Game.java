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
 * ゲーム
 *
 * @author Game Server Services, Inc.
 *
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Game implements Serializable {

	/** ゲームID */
	String gameId;

	/** ゲーム名 */
	String name;

	/** 説明文 */
	String description;

	/** サービスクラス */
	String serviceClass;

	/** 作成日時(エポック秒) */
	Integer createAt;

	/** http/https を選択した際の転送先URL */
	String notificationUrl;

	/** オーナーID */
	String ownerId;

	/** 最終更新日時(エポック秒) */
	Integer updateAt;

	/** 対象がオフライン時使用する転送方式 */
	String offlineTransfer;

	/** fcm を選択した際の Firebase サーバーキー */
	String notificationFirebaseServerKey;


	/**
	 * ゲームIDを取得
	 *
	 * @return ゲームID
	 */
	public String getGameId() {
		return gameId;
	}

	/**
	 * ゲームIDを設定
	 *
	 * @param gameId ゲームID
	 */
	public void setGameId(String gameId) {
		this.gameId = gameId;
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
	 * 作成日時(エポック秒)を取得
	 *
	 * @return 作成日時(エポック秒)
	 */
	public Integer getCreateAt() {
		return createAt;
	}

	/**
	 * 作成日時(エポック秒)を設定
	 *
	 * @param createAt 作成日時(エポック秒)
	 */
	public void setCreateAt(Integer createAt) {
		this.createAt = createAt;
	}

	/**
	 * http/https を選択した際の転送先URLを取得
	 *
	 * @return http/https を選択した際の転送先URL
	 */
	public String getNotificationUrl() {
		return notificationUrl;
	}

	/**
	 * http/https を選択した際の転送先URLを設定
	 *
	 * @param notificationUrl http/https を選択した際の転送先URL
	 */
	public void setNotificationUrl(String notificationUrl) {
		this.notificationUrl = notificationUrl;
	}

	/**
	 * オーナーIDを取得
	 *
	 * @return オーナーID
	 */
	public String getOwnerId() {
		return ownerId;
	}

	/**
	 * オーナーIDを設定
	 *
	 * @param ownerId オーナーID
	 */
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * 最終更新日時(エポック秒)を取得
	 *
	 * @return 最終更新日時(エポック秒)
	 */
	public Integer getUpdateAt() {
		return updateAt;
	}

	/**
	 * 最終更新日時(エポック秒)を設定
	 *
	 * @param updateAt 最終更新日時(エポック秒)
	 */
	public void setUpdateAt(Integer updateAt) {
		this.updateAt = updateAt;
	}

	/**
	 * 対象がオフライン時使用する転送方式を取得
	 *
	 * @return 対象がオフライン時使用する転送方式
	 */
	public String getOfflineTransfer() {
		return offlineTransfer;
	}

	/**
	 * 対象がオフライン時使用する転送方式を設定
	 *
	 * @param offlineTransfer 対象がオフライン時使用する転送方式
	 */
	public void setOfflineTransfer(String offlineTransfer) {
		this.offlineTransfer = offlineTransfer;
	}

	/**
	 * fcm を選択した際の Firebase サーバーキーを取得
	 *
	 * @return fcm を選択した際の Firebase サーバーキー
	 */
	public String getNotificationFirebaseServerKey() {
		return notificationFirebaseServerKey;
	}

	/**
	 * fcm を選択した際の Firebase サーバーキーを設定
	 *
	 * @param notificationFirebaseServerKey fcm を選択した際の Firebase サーバーキー
	 */
	public void setNotificationFirebaseServerKey(String notificationFirebaseServerKey) {
		this.notificationFirebaseServerKey = notificationFirebaseServerKey;
	}

}