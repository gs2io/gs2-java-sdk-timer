package io.gs2.timer.control;

import io.gs2.control.Gs2BasicRequest;
import io.gs2.timer.Gs2Timer;

/**
 * タイマー一覧の取得リクエスト。
 * 
 * @author Game Server Services, Inc.
 *
 */
@SuppressWarnings("serial")
public class DescribeTimerRequest extends Gs2BasicRequest<DescribeTimerRequest> {

	public static class Constant extends Gs2Timer.Constant {
		public static final String FUNCTION = "DescribeTimer";
	}

	/** タイマープール名 */
	String timerPoolName;
	/** 取得開始位置トークン */
	String pageToken;
	/** 取得件数 */
	Integer limit;

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
	public DescribeTimerRequest withTimerPoolName(String timerPoolName) {
		setTimerPoolName(timerPoolName);
		return this;
	}
	/**
	 * 取得開始位置トークンを取得。
	 * 
	 * @return 取得開始位置トークン
	 */
	public String getPageToken() {
		return pageToken;
	}
	
	/**
	 * 取得開始位置トークンを設定。
	 * 
	 * @param pageToken 取得開始位置トークン
	 */
	public void setPageToken(String pageToken) {
		this.pageToken = pageToken;
	}
	
	/**
	 * 取得開始位置トークンを設定。
	 * 
	 * @param pageToken 取得開始位置トークン
	 * @return this
	 */
	public DescribeTimerRequest withPageToken(String pageToken) {
		setPageToken(pageToken);
		return this;
	}

	/**
	 * 取得件数を取得。
	 * 
	 * @return 取得件数
	 */
	public Integer getLimit() {
		return limit;
	}
	
	/**
	 * 取得件数を設定。
	 * 
	 * @param limit 取得件数
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
	/**
	 * 取得件数を設定。
	 * 
	 * @param limit 取得件数
	 * @return this
	 */
	public DescribeTimerRequest withLimit(Integer limit) {
		setLimit(limit);
		return this;
	}
}
