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

package io.gs2.inGamePushNotification;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.gs2.AbstractGs2Client;
import io.gs2.Gs2Constant;
import io.gs2.inGamePushNotification.control.*;
import io.gs2.model.IGs2Credential;

/**
 * GS2 InGamePushNotification API クライアント
 *
 * @author Game Server Services, Inc.
 *
 */
public class Gs2InGamePushNotificationClient extends AbstractGs2Client<Gs2InGamePushNotificationClient> {

	public static String ENDPOINT = "in-game-push-notification";

	/**
	 * コンストラクタ。
	 *
	 * @param credential 認証情報
	 */
	public Gs2InGamePushNotificationClient(IGs2Credential credential) {
		super(credential);
	}


	/**
	 * サービスクラスの一覧を取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public DescribeServiceClassResult describeServiceClass(DescribeServiceClassRequest request) {
	    String url = Gs2Constant.ENDPOINT_HOST + "/game/serviceClass";



		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				DescribeServiceClassRequest.Constant.MODULE,
				DescribeServiceClassRequest.Constant.FUNCTION);

		return doRequest(get, DescribeServiceClassResult.class);
	}


	/**
	 * Firebase のデバイストークンを設定します。<br>
	 * <br>
	 * - 消費クオータ: 10<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public SetFirebaseTokenResult setFirebaseToken(SetFirebaseTokenRequest request) {
		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("token", request.getToken());

		HttpPut put = createHttpPut(
				Gs2Constant.ENDPOINT_HOST + "/game/" + (request.getGameName() == null ? "null" : request.getGameName()) + "/user",
				credential,
				ENDPOINT,
				SetFirebaseTokenRequest.Constant.MODULE,
				SetFirebaseTokenRequest.Constant.FUNCTION,
				body.toString());

		put.setHeader("X-GS2-ACCESS-TOKEN", request.getAccessToken());
		return doRequest(put, SetFirebaseTokenResult.class);
	}


	/**
	 * ユーザステータスの一覧を取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public DescribeStatusResult describeStatus(DescribeStatusRequest request) {
		String url = Gs2Constant.ENDPOINT_HOST + "/game/" + (request.getGameName() == null ? "null" : request.getGameName()) + "/user";

		List<NameValuePair> queryString = new ArrayList<>();
		if(request.getPageToken() != null) queryString.add(new BasicNameValuePair("pageToken", String.valueOf(request.getPageToken())));
		if(request.getLimit() != null) queryString.add(new BasicNameValuePair("limit", String.valueOf(request.getLimit())));


		if(queryString.size() > 0) {
			url += "?" + URLEncodedUtils.format(queryString, "UTF-8");
		}
		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				DescribeStatusRequest.Constant.MODULE,
				DescribeStatusRequest.Constant.FUNCTION);

		return doRequest(get, DescribeStatusResult.class);
	}


	/**
	 * ゲームを新規作成します<br>
	 * <br>
	 * GS2-InGamePushNotification の使用を開始するには、まずはゲームを作成します。<br>
	 * その後、ゲームに対してMQTTに接続するためのクライアント証明書の発行を依頼をします。<br>
	 * 応答されたクライアント証明書と秘密鍵をデバイスに保存し、MQTTサーバへの接続に使用します。<br>
	 * <br>
	 * サーバサイドから ユーザに対してプッシュ通知を出すことが出来ます。<br>
	 * その際にユーザがMQTTに接続している場合はMQTTを使用して通知を出します。<br>
	 * もし、ユーザがMQTTに接続していない場合の挙動は ゲームの設定で変更できます。<br>
	 * <br>
	 * 1つ目は何もしない。<br>
	 * 2つ目は指定したURLに通知する。<br>
	 * 3つ目は Firebase Cloud Messaging を使用してモバイルプッシュ通知する。です。<br>
	 * <br>
	 * APIリクエスト以外に各デバイスがMQTTサーバに新しく接続する際に クオータを10消費する点にご注意ください。<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public CreateGameResult createGame(CreateGameRequest request) {
		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("serviceClass", request.getServiceClass())
				.put("name", request.getName())
				.put("offlineTransfer", request.getOfflineTransfer());

        if(request.getNotificationFirebaseServerKey() != null) body.put("notificationFirebaseServerKey", request.getNotificationFirebaseServerKey());
        if(request.getNotificationUrl() != null) body.put("notificationUrl", request.getNotificationUrl());
        if(request.getDescription() != null) body.put("description", request.getDescription());
		HttpPost post = createHttpPost(
				Gs2Constant.ENDPOINT_HOST + "/game",
				credential,
				ENDPOINT,
				CreateGameRequest.Constant.MODULE,
				CreateGameRequest.Constant.FUNCTION,
				body.toString());

		return doRequest(post, CreateGameResult.class);
	}


	/**
	 * ゲームの一覧を取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public DescribeGameResult describeGame(DescribeGameRequest request) {
	    String url = Gs2Constant.ENDPOINT_HOST + "/game";

        List<NameValuePair> queryString = new ArrayList<>();
        if(request.getPageToken() != null) queryString.add(new BasicNameValuePair("pageToken", String.valueOf(request.getPageToken())));
        if(request.getLimit() != null) queryString.add(new BasicNameValuePair("limit", String.valueOf(request.getLimit())));


		if(queryString.size() > 0) {
			url += "?" + URLEncodedUtils.format(queryString, "UTF-8");
		}
		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				DescribeGameRequest.Constant.MODULE,
				DescribeGameRequest.Constant.FUNCTION);

		return doRequest(get, DescribeGameResult.class);
	}

	/**
	 * ゲームの状態を取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public GetGameStatusResult getGameStatus(GetGameStatusRequest request) {
	    String url = Gs2Constant.ENDPOINT_HOST + "/game/" + (request.getGameName() == null ? "null" : request.getGameName()) + "/status";



		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				GetGameStatusRequest.Constant.MODULE,
				GetGameStatusRequest.Constant.FUNCTION);

		return doRequest(get, GetGameStatusResult.class);
	}


	/**
	 * クライアント証明書を新規作成します<br>
	 * <br>
	 * MQTTサーバに接続するためのクライアント証明書の発行を行います。<br>
	 * 1ユーザに対して発行できるクライアント証明書は同時に1つのみです。<br>
	 * 異なるデバイスでMQTTサーバにアクセスする場合、クライアント証明書を削除して取り直すようにしてください。<br>
	 * <br>
	 * - 消費クオータ: 10<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public CreateCertificateResult createCertificate(CreateCertificateRequest request) {
		ObjectNode body = JsonNodeFactory.instance.objectNode();

		HttpPost post = createHttpPost(
				Gs2Constant.ENDPOINT_HOST + "/game/" + (request.getGameName() == null ? "null" : request.getGameName()) + "/certificate",
				credential,
				ENDPOINT,
				CreateCertificateRequest.Constant.MODULE,
				CreateCertificateRequest.Constant.FUNCTION,
				body.toString());

        post.setHeader("X-GS2-ACCESS-TOKEN", request.getAccessToken());
		return doRequest(post, CreateCertificateResult.class);
	}


	/**
	 * クライアント証明書を削除します。<br>
	 * <br>
	 * - 消費クオータ: 10<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 */
	public void deleteCertificate(DeleteCertificateRequest request) {
		HttpDelete delete = createHttpDelete(
				Gs2Constant.ENDPOINT_HOST + "/game/" + (request.getGameName() == null ? "null" : request.getGameName()) + "/certificate",
				credential,
				ENDPOINT,
				DeleteCertificateRequest.Constant.MODULE,
				DeleteCertificateRequest.Constant.FUNCTION);

        delete.setHeader("X-GS2-ACCESS-TOKEN", request.getAccessToken());
		doRequest(delete, null);
	}


	/**
	 * MQTTサーバ情報を取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public GetMqttHostResult getMqttHost(GetMqttHostRequest request) {
		String url = Gs2Constant.ENDPOINT_HOST + "/game/" + (request.getGameName() == null ? "null" : request.getGameName()) + "/server/mqtt";



		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				GetMqttHostRequest.Constant.MODULE,
				GetMqttHostRequest.Constant.FUNCTION);

		get.setHeader("X-GS2-ACCESS-TOKEN", request.getAccessToken());
		return doRequest(get, GetMqttHostResult.class);
	}


	/**
	 * MQTT over Websocketサーバ情報を取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public GetWebSocketHostResult getWebSocketHost(GetWebSocketHostRequest request) {
		String url = Gs2Constant.ENDPOINT_HOST + "/game/" + (request.getGameName() == null ? "null" : request.getGameName()) + "/server/webSocket";



		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				GetWebSocketHostRequest.Constant.MODULE,
				GetWebSocketHostRequest.Constant.FUNCTION);

		get.setHeader("X-GS2-ACCESS-TOKEN", request.getAccessToken());
		return doRequest(get, GetWebSocketHostResult.class);
	}


	/**
	 * 通知を送信します。<br>
	 * <br>
	 * - 消費クオータ: 3<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public PublishResult publish(PublishRequest request) {
		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("body", request.getBody())
				.put("enableOfflineTransfer", request.getEnableOfflineTransfer())
				.put("subject", request.getSubject());

		if(request.getOfflineTransferSound() != null) body.put("offlineTransferSound", request.getOfflineTransferSound());
		HttpPost post = createHttpPost(
				Gs2Constant.ENDPOINT_HOST + "/game/" + (request.getGameName() == null ? "null" : request.getGameName()) + "/user/" + (request.getUserId() == null ? "null" : request.getUserId()) + "",
				credential,
				ENDPOINT,
				PublishRequest.Constant.MODULE,
				PublishRequest.Constant.FUNCTION,
				body.toString());

		return doRequest(post, PublishResult.class);
	}

	/**
	 * ゲームを更新します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public UpdateGameResult updateGame(UpdateGameRequest request) {
		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("serviceClass", request.getServiceClass())
				.put("offlineTransfer", request.getOfflineTransfer());

        if(request.getNotificationUrl() != null) body.put("notificationUrl", request.getNotificationUrl());
        if(request.getNotificationFirebaseServerKey() != null) body.put("notificationFirebaseServerKey", request.getNotificationFirebaseServerKey());
        if(request.getDescription() != null) body.put("description", request.getDescription());
		HttpPut put = createHttpPut(
				Gs2Constant.ENDPOINT_HOST + "/game/" + (request.getGameName() == null ? "null" : request.getGameName()) + "",
				credential,
				ENDPOINT,
				UpdateGameRequest.Constant.MODULE,
				UpdateGameRequest.Constant.FUNCTION,
				body.toString());

		return doRequest(put, UpdateGameResult.class);
	}


	/**
	 * ゲームを取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */
	public GetGameResult getGame(GetGameRequest request) {
	    String url = Gs2Constant.ENDPOINT_HOST + "/game/" + (request.getGameName() == null ? "null" : request.getGameName()) + "";



		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				GetGameRequest.Constant.MODULE,
				GetGameRequest.Constant.FUNCTION);

		return doRequest(get, GetGameResult.class);
	}


	/**
	 * ゲームを削除します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 */
	public void deleteGame(DeleteGameRequest request) {
		HttpDelete delete = createHttpDelete(
				Gs2Constant.ENDPOINT_HOST + "/game/" + (request.getGameName() == null ? "null" : request.getGameName()) + "",
				credential,
				ENDPOINT,
				DeleteGameRequest.Constant.MODULE,
				DeleteGameRequest.Constant.FUNCTION);

		doRequest(delete, null);
	}


}