package io.gs2.timer.control;

import io.gs2.control.Gs2BasicRequest;
import io.gs2.timer.Gs2Timer;

/**
 * タイマープールの削除リクエスト。
 * 
 * @author Game Server Services, Inc.
 *
 */
@SuppressWarnings("serial")
public class DeleteTimerPoolRequest extends Gs2BasicRequest<DeleteTimerPoolRequest> {

	public static class Constant extends Gs2Timer.Constant {
		public static final String FUNCTION = "DeleteTimerPool";
	}
	
	/** タイマープール名 */
	String timerPoolName;
	
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
	public DeleteTimerPoolRequest withTimerPoolName(String timerPoolName) {
		setTimerPoolName(timerPoolName);
		return this;
	}
}
