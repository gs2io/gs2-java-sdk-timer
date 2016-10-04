package io.gs2.timer;

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
import io.gs2.model.IGs2Credential;
import io.gs2.timer.control.CreateTimerPoolRequest;
import io.gs2.timer.control.CreateTimerPoolResult;
import io.gs2.timer.control.CreateTimerRequest;
import io.gs2.timer.control.CreateTimerResult;
import io.gs2.timer.control.DeleteTimerPoolRequest;
import io.gs2.timer.control.DeleteTimerRequest;
import io.gs2.timer.control.DescribeTimerPoolRequest;
import io.gs2.timer.control.DescribeTimerPoolResult;
import io.gs2.timer.control.DescribeTimerRequest;
import io.gs2.timer.control.DescribeTimerResult;
import io.gs2.timer.control.GetTimerPoolRequest;
import io.gs2.timer.control.GetTimerPoolResult;
import io.gs2.timer.control.GetTimerRequest;
import io.gs2.timer.control.GetTimerResult;
import io.gs2.timer.control.UpdateTimerPoolRequest;
import io.gs2.timer.control.UpdateTimerPoolResult;

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
	 * タイマープールを作成。<br>
	 * <br>
	 * GS2-Timer を利用するには、まずタイマープールを作成する必要があります。<br>
	 * タイマープールには複数のタイマーを格納することができます。<br>
	 * 
	 * @param request リクエストパラメータ
	 * @return 作成結果
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
	 * タイマープール一覧を取得。
	 * 
	 * @param request リクエストパラメータ
	 * @return タイマープール一覧
	 */
	public DescribeTimerPoolResult describeTimerPool(DescribeTimerPoolRequest request) {
		String url = Gs2Constant.ENDPOINT_HOST + "/timerPool";
		List<NameValuePair> queryString = new ArrayList<>();
		if(request.getLimit() != null) queryString.add(new BasicNameValuePair("limit", String.valueOf(request.getLimit())));
		if(request.getPageToken() != null) queryString.add(new BasicNameValuePair("pageToken", request.getPageToken()));
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
	 * タイマープールを取得。
	 * 
	 * @param request リクエストパラメータ
	 * @return タイマープール
	 */
	public GetTimerPoolResult getTimerPool(GetTimerPoolRequest request) {
		HttpGet get = createHttpGet(
				Gs2Constant.ENDPOINT_HOST + "/timerPool/" + request.getTimerPoolName(), 
				credential, 
				ENDPOINT,
				GetTimerPoolRequest.Constant.MODULE, 
				GetTimerPoolRequest.Constant.FUNCTION);
		return doRequest(get, GetTimerPoolResult.class);
	}

	/**
	 * タイマープールを更新。
	 * 
	 * @param request リクエストパラメータ
	 * @return タイマープール
	 */
	public UpdateTimerPoolResult updateTimerPool(UpdateTimerPoolRequest request) {
		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("description", request.getDescription());
		HttpPut put = createHttpPut(
				Gs2Constant.ENDPOINT_HOST + "/timerPool/" + request.getTimerPoolName(), 
				credential, 
				ENDPOINT,
				UpdateTimerPoolRequest.Constant.MODULE, 
				UpdateTimerPoolRequest.Constant.FUNCTION,
				body.toString());
		return doRequest(put, UpdateTimerPoolResult.class);
	}

	/**
	 * タイマープールを削除。
	 * 
	 * @param request リクエストパラメータ
	 */
	public void deleteTimerPool(DeleteTimerPoolRequest request) {
		HttpDelete delete = createHttpDelete(
				Gs2Constant.ENDPOINT_HOST + "/timerPool/" + request.getTimerPoolName(), 
				credential, 
				ENDPOINT,
				DeleteTimerPoolRequest.Constant.MODULE, 
				DeleteTimerPoolRequest.Constant.FUNCTION);
		doRequest(delete, null);
	}
	
	/**
	 * タイマーを作成。<br>
	 * <br>
	 * タイマーを作成すると、指定した時刻に指定したURLに指定したパラメータを持ったアクセスを発生させます。<br>
	 * 基本的には指定した時刻以降に60秒以内に呼び出し処理が開始されます。<br>
	 * 混雑時には60秒以上かかることがありますので、タイミングがシビアな処理には向きません。<br>
	 * <br>
	 * アカウントBANを指定した時刻付近で解除する。など、タイミングがシビアでない処理で利用することをおすすめします。<br>
	 * 
	 * @param request リクエストパラメータ
	 * @return 作成結果
	 */
	public CreateTimerResult createTimer(CreateTimerRequest request) {
		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("callbackUrl", request.getCallbackUrl())
				.put("callbackMethod", request.getCallbackMethod())
				.put("callbackBody", request.getCallbackBody())
				.put("executeTime", request.getExecuteTime())
				.put("retryMax", request.getRetryMax());
		HttpPost post = createHttpPost(
				Gs2Constant.ENDPOINT_HOST + "/timerPool/" + request.getTimerPoolName() + "/timer", 
				credential, 
				ENDPOINT,
				CreateTimerRequest.Constant.MODULE, 
				CreateTimerRequest.Constant.FUNCTION,
				body.toString());
		return doRequest(post, CreateTimerResult.class);
	}
	
	/**
	 * タイマー一覧を取得。
	 * 
	 * @param request リクエストパラメータ
	 * @return タイマー一覧
	 */
	public DescribeTimerResult describeTimer(DescribeTimerRequest request) {
		String url = Gs2Constant.ENDPOINT_HOST + "/timerPool/" + request.getTimerPoolName() + "/timer";
		List<NameValuePair> queryString = new ArrayList<>();
		if(request.getLimit() != null) queryString.add(new BasicNameValuePair("limit", String.valueOf(request.getLimit())));
		if(request.getPageToken() != null) queryString.add(new BasicNameValuePair("pageToken", request.getPageToken()));
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
	 * タイマーを取得。
	 * 
	 * @param request リクエストパラメータ
	 * @return タイマー
	 */
	public GetTimerResult getTimer(GetTimerRequest request) {
		HttpGet get = createHttpGet(
				Gs2Constant.ENDPOINT_HOST + "/timerPool/" + request.getTimerPoolName() + "/timer/" + request.getTimerId(), 
				credential, 
				ENDPOINT,
				GetTimerRequest.Constant.MODULE, 
				GetTimerRequest.Constant.FUNCTION);
		return doRequest(get, GetTimerResult.class);
	}

	/**
	 * タイマーを削除。
	 * 
	 * @param request リクエストパラメータ
	 */
	public void deleteTimer(DeleteTimerRequest request) {
		HttpDelete delete = createHttpDelete(
				Gs2Constant.ENDPOINT_HOST + "/timerPool/" + request.getTimerPoolName() + "/timer/" + request.getTimerId(), 
				credential, 
				ENDPOINT,
				DeleteTimerRequest.Constant.MODULE, 
				DeleteTimerRequest.Constant.FUNCTION);
		doRequest(delete, null);
	}
}
