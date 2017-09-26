package io.gs2.timer.control;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.gs2.timer.model.TimerPool;

/**
 * タイマープール取得結果。
 * 
 * @author Game Server Services, Inc.
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class GetTimerPoolResult {

	/** タイマープール */
	TimerPool item;
	
	/**
	 * 取得したタイマープールを取得。
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
}
