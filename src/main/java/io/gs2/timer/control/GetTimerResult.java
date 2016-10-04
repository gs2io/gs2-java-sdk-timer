package io.gs2.timer.control;

import io.gs2.timer.model.Timer;

/**
 * タイマー取得結果。
 * 
 * @author Game Server Services, Inc.
 *
 */
public class GetTimerResult {

	/** タイマー */
	Timer item;
	
	/**
	 * 取得したタイマーを取得。
	 * 
	 * @return タイマー
	 */
	public Timer getItem() {
		return item;
	}
	
	/**
	 * タイマーを設定。
	 * 
	 * @param item タイマー
	 */
	public void setItem(Timer item) {
		this.item = item;
	}
}
