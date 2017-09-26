package io.gs2.timer.control;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.gs2.timer.model.Timer;

/**
 * タイマーの作成結果。
 * 
 * @author Game Server Services, Inc.
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class CreateTimerResult {
	
	Timer item;
	
	/**
	 * タイマーを取得。
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
	
	/**
	 * タイマーを設定。
	 * 
	 * @param item タイマー
	 * @return this
	 */
	public CreateTimerResult withItem(Timer item) {
		setItem(item);
		return this;
	}
}
