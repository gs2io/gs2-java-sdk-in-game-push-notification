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

import io.gs2.control.Gs2BasicRequest;
import io.gs2.inGamePushNotification.Gs2InGamePushNotification;

/**
 * @author Game Server Services, Inc.
 */
@SuppressWarnings("serial")
public class DescribeGameRequest extends Gs2BasicRequest<DescribeGameRequest> {

	public static class Constant extends Gs2InGamePushNotification.Constant {
		public static final String FUNCTION = "DescribeGame";
	}

	/** データの取得を開始する位置を指定するトークン

省略すると先頭から取得します */
	String pageToken;

	/** データの取得件数

省略すると30件取得します */
	Integer limit;


	/**
	 * データの取得を開始する位置を指定するトークン

省略すると先頭から取得しますを取得
	 *
	 * @return データの取得を開始する位置を指定するトークン

省略すると先頭から取得します
	 */
	public String getPageToken() {
		return pageToken;
	}

	/**
	 * データの取得を開始する位置を指定するトークン

省略すると先頭から取得しますを設定
	 *
	 * @param pageToken データの取得を開始する位置を指定するトークン

省略すると先頭から取得します
	 */
	public void setPageToken(String pageToken) {
		this.pageToken = pageToken;
	}

	/**
	 * データの取得を開始する位置を指定するトークン

省略すると先頭から取得しますを設定
	 *
	 * @param pageToken データの取得を開始する位置を指定するトークン

省略すると先頭から取得します
	 * @return this
	 */
	public DescribeGameRequest withPageToken(String pageToken) {
		setPageToken(pageToken);
		return this;
	}

	/**
	 * データの取得件数

省略すると30件取得しますを取得
	 *
	 * @return データの取得件数

省略すると30件取得します
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * データの取得件数

省略すると30件取得しますを設定
	 *
	 * @param limit データの取得件数

省略すると30件取得します
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	/**
	 * データの取得件数

省略すると30件取得しますを設定
	 *
	 * @param limit データの取得件数

省略すると30件取得します
	 * @return this
	 */
	public DescribeGameRequest withLimit(Integer limit) {
		setLimit(limit);
		return this;
	}

}