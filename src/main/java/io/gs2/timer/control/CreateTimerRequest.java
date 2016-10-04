package io.gs2.timer.control;

import io.gs2.control.Gs2BasicRequest;
import io.gs2.timer.Gs2Timer;

/**
 * タイマーの作成リクエスト。
 * 
 * @author Game Server Services, Inc.
 *
 */
@SuppressWarnings("serial")
public class CreateTimerRequest extends Gs2BasicRequest<CreateTimerRequest> {

	public static class Constant extends Gs2Timer.Constant {
		public static final String FUNCTION = "CreateTimer";
	}

	/** タイマープール名 */
	String timerPoolName;
	/** コールバックメソッド */
	String callbackMethod;
	/** コールバックURL */
	String callbackUrl;
	/** コールバックボディ */
	String callbackBody;
	/** 実行時間 */
	Long executeTime;
	/** 最大リトライ回数 */
	Integer retryMax;

	/**
	 * タイマープール名を取得。
	 * 
	 * @return タイマープール名
	 */
	public String getTimerPoolName() {
		return timerPoolName;
	}
	
	/**
	 * タイマープール名を設定。
	 * 
	 * @param timerPoolName タイマープール名
	 */
	public void setTimerPoolName(String timerPoolName) {
		this.timerPoolName = timerPoolName;
	}
	
	/**
	 * タイマープール名を設定。
	 * 
	 * @param timerPoolName タイマープール名
	 * @return this
	 */
	public CreateTimerRequest withTimerPoolName(String timerPoolName) {
		setTimerPoolName(timerPoolName);
		return this;
	}

	/**
	 * コールバックメソッドを取得。
	 * 
	 * @return コールバックメソッド
	 */
	public String getCallbackMethod() {
		return callbackMethod;
	}
	
	/**
	 * コールバックメソッドを設定。
	 * 
	 * @param callbackMethod コールバックメソッド
	 */
	public void setCallbackMethod(String callbackMethod) {
		this.callbackMethod = callbackMethod;
	}
	
	/**
	 * コールバックメソッドを設定。
	 * 
	 * @param callbackMethod コールバックメソッド
	 * @return this
	 */
	public CreateTimerRequest withCallbackMethod(String callbackMethod) {
		setCallbackMethod(callbackMethod);
		return this;
	}

	/**
	 * コールバックURLを取得。
	 * 
	 * @return コールバックURL
	 */
	public String getCallbackUrl() {
		return callbackUrl;
	}
	
	/**
	 * コールバックURLを設定。
	 * 
	 * @param callbackUrl コールバックURL
	 */
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}
	
	/**
	 * コールバックURLを設定。
	 * 
	 * @param callbackUrl コールバックURL
	 * @return this
	 */
	public CreateTimerRequest withCallbackUrl(String callbackUrl) {
		setCallbackUrl(callbackUrl);
		return this;
	}

	/**
	 * コールバックボディを取得。
	 * 
	 * @return コールバックボディ
	 */
	public String getCallbackBody() {
		return callbackBody;
	}
	
	/**
	 * コールバックボディを設定。
	 * 
	 * @param callbackBody コールバックボディ
	 */
	public void setCallbackBody(String callbackBody) {
		this.callbackBody = callbackBody;
	}
	
	/**
	 * コールバックボディを設定。
	 * 
	 * @param callbackBody コールバックボディ
	 * @return this
	 */
	public CreateTimerRequest withCallbackBody(String callbackBody) {
		setCallbackBody(callbackBody);
		return this;
	}

	/**
	 * 実行時間を取得。
	 * 
	 * @return 実行時間
	 */
	public Long getExecuteTime() {
		return executeTime;
	}
	
	/**
	 * 実行時間を設定。
	 * 
	 * @param executeTime 実行時間
	 */
	public void setExecuteTime(Long executeTime) {
		this.executeTime = executeTime;
	}
	
	/**
	 * 実行時間を設定。
	 * 
	 * @param executeTime 実行時間
	 * @return this
	 */
	public CreateTimerRequest withExecuteTime(Long executeTime) {
		setExecuteTime(executeTime);
		return this;
	}

	/**
	 * 最大リトライ回数を取得。
	 * 
	 * @return 最大リトライ回数
	 */
	public Integer getRetryMax() {
		return retryMax;
	}
	
	/**
	 * 最大リトライ回数を設定。
	 * 
	 * @param retryMax 最大リトライ回数
	 */
	public void setRetryMax(Integer retryMax) {
		this.retryMax = retryMax;
	}
	
	/**
	 * 最大リトライ回数を設定。
	 * 
	 * @param retryMax 最大リトライ回数
	 * @return this
	 */
	public CreateTimerRequest withRetryMax(Integer retryMax) {
		setRetryMax(retryMax);
		return this;
	}
	
}
