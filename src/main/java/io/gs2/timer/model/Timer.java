package io.gs2.timer.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * タイマー
 * 
 * @author Game Server Services, Inc.
 *
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Timer implements Serializable {

	/** タイマーID */
	String timerId;
	/** タイマープールID */
	String timerPoolId;
	/** オーナーID */
	String ownerId;
	/** HTTPメソッド */
	String callbackMethod;
	/** コールバックURL */
	String callbackUrl;
	/** コールバックボディ */
	String callbackBody;
	/** 実行時間 */
	Long executeTime;
	/** 最大リトライ回数 */
	Integer retryMax;
	/** 作成日時 */
	Long createAt;
	
	/**
	 * タイマーIDを取得
	 * 
	 * @return タイマーID
	 */
	public String getTimerId() {
		return timerId;
	}
	
	/**
	 * タイマーIDを設定
	 * 
	 * @param timerId タイマーID
	 */
	public void setTimerId(String timerId) {
		this.timerId = timerId;
	}
	
	/**
	 * タイマープールIDを取得
	 * 
	 * @return タイマープールID
	 */
	public String getTimerPoolId() {
		return timerPoolId;
	}
	
	/**
	 * タイマープールIDを設定
	 * 
	 * @param timerPoolId タイマープールID
	 */
	public void setTimerPoolId(String timerPoolId) {
		this.timerPoolId = timerPoolId;
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
	 * HTTPメソッドを取得
	 * 
	 * @return HTTPメソッド
	 */
	public String getCallbackMethod() {
		return callbackMethod;
	}
	
	/**
	 * HTTPメソッドを設定
	 * 
	 * @param callbackMethod HTTPメソッド
	 */
	public void setCallbackMethod(String callbackMethod) {
		this.callbackMethod = callbackMethod;
	}
	
	/**
	 * コールバックURLを取得
	 * 
	 * @return コールバックURL
	 */
	public String getCallbackUrl() {
		return callbackUrl;
	}
	
	/**
	 * コールバックURLを設定
	 * 
	 * @param callbackUrl コールバックURL
	 */
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}
	
	/**
	 * コールバックボディを取得
	 * 
	 * @return コールバックボディ
	 */
	public String getCallbackBody() {
		return callbackBody;
	}
	
	/**
	 * コールバックボディを設定
	 * 
	 * @param callbackBody コールバックボディ
	 */
	public void setCallbackBody(String callbackBody) {
		this.callbackBody = callbackBody;
	}
	
	/**
	 * 実行時間(unixepoch)を取得
	 * 
	 * @return 実行時間(unixepoch)
	 */
	public Long getExecuteTime() {
		return executeTime;
	}
	
	/**
	 * 実行時間(unixepoch)を設定
	 * 
	 * @param executeTime 実行時間(unixepoch)
	 */
	public void setExecuteTime(Long executeTime) {
		this.executeTime = executeTime;
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
	 * 作成日時を取得
	 * 
	 * @return 作成日時
	 */
	public Long getCreateAt() {
		return createAt;
	}
	
	/**
	 * 作成日時を設定
	 * 
	 * @param createAt 作成日時
	 */
	public void setCreateAt(Long createAt) {
		this.createAt = createAt;
	}
}
