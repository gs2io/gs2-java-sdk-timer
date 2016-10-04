package io.gs2.timer.control;

import io.gs2.control.Gs2BasicRequest;
import io.gs2.timer.Gs2Timer;

/**
 * タイマープールの更新リクエスト。
 * 
 * @author Game Server Services, Inc.
 *
 */
@SuppressWarnings("serial")
public class UpdateTimerPoolRequest extends Gs2BasicRequest<UpdateTimerPoolRequest> {

	public static class Constant extends Gs2Timer.Constant {
		public static final String FUNCTION = "UpdateTimerPool";
	}

	/** タイマープール名 */
	String timerPoolName;
	/** 説明文 */
	String description;

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
	public UpdateTimerPoolRequest withTimerPoolName(String timerPoolName) {
		setTimerPoolName(timerPoolName);
		return this;
	}

	/**
	 * 説明文を取得。
	 * 
	 * @return 説明文
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * 説明文を設定。
	 * 
	 * @param description 説明文
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * 説明文を設定。
	 * 
	 * @param description 説明文
	 * @return this
	 */
	public UpdateTimerPoolRequest withDescription(String description) {
		setDescription(description);
		return this;
	}
	
}
