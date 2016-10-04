package io.gs2.timer.control;

import io.gs2.timer.model.TimerPool;

/**
 * タイマープールの作成結果。
 * 
 * @author Game Server Services, Inc.
 *
 */
public class CreateTimerPoolResult {
	
	TimerPool item;
	
	/**
	 * タイマープールを取得。
	 * 
	 * @return タイマープール
	 */
	public TimerPool getItem() {
		return item;
	}
	
	/**
	 * タイマープールを設定。
	 * 
	 * @param item タイマープール
	 */
	public void setItem(TimerPool item) {
		this.item = item;
	}
	
	/**
	 * タイマープールを設定。
	 * 
	 * @param item タイマープール
	 * @return this
	 */
	public CreateTimerPoolResult withItem(TimerPool item) {
		setItem(item);
		return this;
	}
}
