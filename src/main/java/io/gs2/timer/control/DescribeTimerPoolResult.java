package io.gs2.timer.control;

import java.util.List;

import io.gs2.timer.model.TimerPool;

/**
 * タイマー一覧取得結果。
 * 
 * @author Game Server Services, Inc.
 *
 */
public class DescribeTimerPoolResult {

	/** タイマー一覧 */
	List<TimerPool> items;
	/** 次のページを取得するためのトークン */
	String nextPageToken;
	
	/**
	 * 取得したタイマー数を取得。
	 * 
	 * @return 取得したタイマー数
	 */
	public Integer getCount() {
		return items == null ? null : items.size();
	}
	
	@Deprecated
	public void setCount(Integer count) {}
	
	/**
	 * 取得したタイマー一覧を取得。
	 * 
	 * @return タイマー一覧
	 */
	public List<TimerPool> getItems() {
		return items;
	}
	
	/**
	 * タイマー一覧を設定。
	 * 
	 * @param items タイマー一覧
	 */
	public void setItems(List<TimerPool> items) {
		this.items = items;
	}
	
	/**
	 * 次のページを取得するためのトークンを取得。
	 * 
	 * {@link DescribeTimerPoolRequest} に指定することで、次のページを取得できます。
	 * 
	 * @return トークン
	 */
	public String getNextPageToken() {
		return nextPageToken;
	}

	public void setNextPageToken(String nextPageToken) {
		this.nextPageToken = nextPageToken;
	}
}