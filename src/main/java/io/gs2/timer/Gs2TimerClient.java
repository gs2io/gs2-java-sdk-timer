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

package io.gs2.timer;

import java.util.ArrayList;
import java.util.List;

import io.gs2.util.EncodingUtil;
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
import io.gs2.model.IGs2Credential;
import io.gs2.timer.control.*;

/**
 * GS2 Timer API クライアント
 *
 * @author Game Server Services, Inc.
 *
 */
public class Gs2TimerClient extends AbstractGs2Client<Gs2TimerClient> {

	public static String ENDPOINT = "timer";

	/**
	 * コンストラクタ。
	 *
	 * @param credential 認証情報
	 */
	public Gs2TimerClient(IGs2Credential credential) {
		super(credential);
	}


	/**
	 * タイマーを新規作成します<br>
	 * <br>
	 * タイマーの timestamp は秒単位で指定できますが、<br>
	 * 指定した時刻以降で通常1分以内にコールバックURLは呼び出されます<br>
	 * <br>
	 * 混雑時などには数分の遅れが出ることがあります<br>
	 * <br>
	 * タイマーによるコールバックは指定されたリトライ回数試行します<br>
	 * タイムアウトなどの理由により、実際には通信が到達しているにもかかわらず、リトライが発生する可能性があります<br>
	 * <br>
	 * コールバックは同等のリクエストが複数回呼び出されても問題なく動作するように設計してください<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */

	public CreateTimerResult createTimer(CreateTimerRequest request) {

		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("callbackMethod", request.getCallbackMethod())
				.put("executeTime", request.getExecuteTime())
				.put("callbackUrl", request.getCallbackUrl());

        if(request.getRetryMax() != null) body.put("retryMax", request.getRetryMax());
        if(request.getCallbackBody() != null) body.put("callbackBody", request.getCallbackBody());
		HttpPost post = createHttpPost(
				Gs2Constant.ENDPOINT_HOST + "/timerPool/" + (request.getTimerPoolName() == null ? "null" : request.getTimerPoolName()) + "/timer",
				credential,
				ENDPOINT,
				CreateTimerRequest.Constant.MODULE,
				CreateTimerRequest.Constant.FUNCTION,
				body.toString());


		return doRequest(post, CreateTimerResult.class);

	}


	/**
	 * タイマープールを新規作成します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */

	public CreateTimerPoolResult createTimerPool(CreateTimerPoolRequest request) {

		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("name", request.getName())
				.put("description", request.getDescription());

		HttpPost post = createHttpPost(
				Gs2Constant.ENDPOINT_HOST + "/timerPool",
				credential,
				ENDPOINT,
				CreateTimerPoolRequest.Constant.MODULE,
				CreateTimerPoolRequest.Constant.FUNCTION,
				body.toString());


		return doRequest(post, CreateTimerPoolResult.class);

	}


	/**
	 * タイマーを削除します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 */

	public void deleteTimer(DeleteTimerRequest request) {

	    String url = Gs2Constant.ENDPOINT_HOST + "/timerPool/" + (request.getTimerPoolName() == null ? "null" : request.getTimerPoolName()) + "/timer/" + (request.getTimerId() == null ? "null" : request.getTimerId()) + "";



		HttpDelete delete = createHttpDelete(
				url,
				credential,
				ENDPOINT,
				DeleteTimerRequest.Constant.MODULE,
				DeleteTimerRequest.Constant.FUNCTION);


		doRequest(delete, null);

	}


	/**
	 * タイマープールを削除します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 */

	public void deleteTimerPool(DeleteTimerPoolRequest request) {

	    String url = Gs2Constant.ENDPOINT_HOST + "/timerPool/" + (request.getTimerPoolName() == null ? "null" : request.getTimerPoolName()) + "";



		HttpDelete delete = createHttpDelete(
				url,
				credential,
				ENDPOINT,
				DeleteTimerPoolRequest.Constant.MODULE,
				DeleteTimerPoolRequest.Constant.FUNCTION);


		doRequest(delete, null);

	}


	/**
	 * タイマーの一覧を取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */

	public DescribeTimerResult describeTimer(DescribeTimerRequest request) {

	    String url = Gs2Constant.ENDPOINT_HOST + "/timerPool/" + (request.getTimerPoolName() == null ? "null" : request.getTimerPoolName()) + "/timer";

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
				DescribeTimerRequest.Constant.MODULE,
				DescribeTimerRequest.Constant.FUNCTION);


		return doRequest(get, DescribeTimerResult.class);

	}


	/**
	 * タイマープールの一覧を取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */

	public DescribeTimerPoolResult describeTimerPool(DescribeTimerPoolRequest request) {

	    String url = Gs2Constant.ENDPOINT_HOST + "/timerPool";

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
				DescribeTimerPoolRequest.Constant.MODULE,
				DescribeTimerPoolRequest.Constant.FUNCTION);


		return doRequest(get, DescribeTimerPoolResult.class);

	}


	/**
	 * タイマーを取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */

	public GetTimerResult getTimer(GetTimerRequest request) {

	    String url = Gs2Constant.ENDPOINT_HOST + "/timerPool/" + (request.getTimerPoolName() == null ? "null" : request.getTimerPoolName()) + "/timer/" + (request.getTimerId() == null ? "null" : request.getTimerId()) + "";



		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				GetTimerRequest.Constant.MODULE,
				GetTimerRequest.Constant.FUNCTION);


		return doRequest(get, GetTimerResult.class);

	}


	/**
	 * タイマープールを取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */

	public GetTimerPoolResult getTimerPool(GetTimerPoolRequest request) {

	    String url = Gs2Constant.ENDPOINT_HOST + "/timerPool/" + (request.getTimerPoolName() == null ? "null" : request.getTimerPoolName()) + "";



		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				GetTimerPoolRequest.Constant.MODULE,
				GetTimerPoolRequest.Constant.FUNCTION);


		return doRequest(get, GetTimerPoolResult.class);

	}


	/**
	 * タイマープールを更新します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ
	 * @return 結果
	 */

	public UpdateTimerPoolResult updateTimerPool(UpdateTimerPoolRequest request) {

		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("description", request.getDescription());

		HttpPut put = createHttpPut(
				Gs2Constant.ENDPOINT_HOST + "/timerPool/" + (request.getTimerPoolName() == null ? "null" : request.getTimerPoolName()) + "",
				credential,
				ENDPOINT,
				UpdateTimerPoolRequest.Constant.MODULE,
				UpdateTimerPoolRequest.Constant.FUNCTION,
				body.toString());


		return doRequest(put, UpdateTimerPoolResult.class);

	}


}