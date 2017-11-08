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

package io.gs2.timer.control;

import org.json.JSONObject;
import java.util.List;
import io.gs2.timer.Gs2Timer;
import io.gs2.control.Gs2BasicRequest;

/**
 * @author Game Server Services, Inc.
 */
@SuppressWarnings("serial")
public class CreateTimerRequest extends Gs2BasicRequest<CreateTimerRequest> {

	public static class Constant extends Gs2Timer.Constant {
		public static final String FUNCTION = "CreateTimer";
	}

	/** タイマープールの名前を指定します。 */
	private String timerPoolName;

	/** コールバックに利用するHTTPメソッド */
	private String callbackMethod;

	/** コールバックを実行するタイムスタンプ */
	private Integer executeTime;

	/** 最大リトライ回数 */
	private Integer retryMax;

	/** method に PUT/POST を指定したときに利用するリクエストボディ */
	private String callbackBody;

	/** コールバック先のURL */
	private String callbackUrl;


	/**
	 * タイマープールの名前を指定します。を取得
	 *
	 * @return タイマープールの名前を指定します。
	 */
	public String getTimerPoolName() {
		return timerPoolName;
	}

	/**
	 * タイマープールの名前を指定します。を設定
	 *
	 * @param timerPoolName タイマープールの名前を指定します。
	 */
	public void setTimerPoolName(String timerPoolName) {
		this.timerPoolName = timerPoolName;
	}

	/**
	 * タイマープールの名前を指定します。を設定
	 *
	 * @param timerPoolName タイマープールの名前を指定します。
	 * @return this
	 */
	public CreateTimerRequest withTimerPoolName(String timerPoolName) {
		setTimerPoolName(timerPoolName);
		return this;
	}

	/**
	 * コールバックに利用するHTTPメソッドを取得
	 *
	 * @return コールバックに利用するHTTPメソッド
	 */
	public String getCallbackMethod() {
		return callbackMethod;
	}

	/**
	 * コールバックに利用するHTTPメソッドを設定
	 *
	 * @param callbackMethod コールバックに利用するHTTPメソッド
	 */
	public void setCallbackMethod(String callbackMethod) {
		this.callbackMethod = callbackMethod;
	}

	/**
	 * コールバックに利用するHTTPメソッドを設定
	 *
	 * @param callbackMethod コールバックに利用するHTTPメソッド
	 * @return this
	 */
	public CreateTimerRequest withCallbackMethod(String callbackMethod) {
		setCallbackMethod(callbackMethod);
		return this;
	}

	/**
	 * コールバックを実行するタイムスタンプを取得
	 *
	 * @return コールバックを実行するタイムスタンプ
	 */
	public Integer getExecuteTime() {
		return executeTime;
	}

	/**
	 * コールバックを実行するタイムスタンプを設定
	 *
	 * @param executeTime コールバックを実行するタイムスタンプ
	 */
	public void setExecuteTime(Integer executeTime) {
		this.executeTime = executeTime;
	}

	/**
	 * コールバックを実行するタイムスタンプを設定
	 *
	 * @param executeTime コールバックを実行するタイムスタンプ
	 * @return this
	 */
	public CreateTimerRequest withExecuteTime(Integer executeTime) {
		setExecuteTime(executeTime);
		return this;
	}

	/**
	 * 最大リトライ回数を取得
	 *
	 * @return 最大リトライ回数
	 */
	public Integer getRetryMax() {
		return retryMax;
	}

	/**
	 * 最大リトライ回数を設定
	 *
	 * @param retryMax 最大リトライ回数
	 */
	public void setRetryMax(Integer retryMax) {
		this.retryMax = retryMax;
	}

	/**
	 * 最大リトライ回数を設定
	 *
	 * @param retryMax 最大リトライ回数
	 * @return this
	 */
	public CreateTimerRequest withRetryMax(Integer retryMax) {
		setRetryMax(retryMax);
		return this;
	}

	/**
	 * method に PUT/POST を指定したときに利用するリクエストボディを取得
	 *
	 * @return method に PUT/POST を指定したときに利用するリクエストボディ
	 */
	public String getCallbackBody() {
		return callbackBody;
	}

	/**
	 * method に PUT/POST を指定したときに利用するリクエストボディを設定
	 *
	 * @param callbackBody method に PUT/POST を指定したときに利用するリクエストボディ
	 */
	public void setCallbackBody(String callbackBody) {
		this.callbackBody = callbackBody;
	}

	/**
	 * method に PUT/POST を指定したときに利用するリクエストボディを設定
	 *
	 * @param callbackBody method に PUT/POST を指定したときに利用するリクエストボディ
	 * @return this
	 */
	public CreateTimerRequest withCallbackBody(String callbackBody) {
		setCallbackBody(callbackBody);
		return this;
	}

	/**
	 * コールバック先のURLを取得
	 *
	 * @return コールバック先のURL
	 */
	public String getCallbackUrl() {
		return callbackUrl;
	}

	/**
	 * コールバック先のURLを設定
	 *
	 * @param callbackUrl コールバック先のURL
	 */
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	/**
	 * コールバック先のURLを設定
	 *
	 * @param callbackUrl コールバック先のURL
	 * @return this
	 */
	public CreateTimerRequest withCallbackUrl(String callbackUrl) {
		setCallbackUrl(callbackUrl);
		return this;
	}

}