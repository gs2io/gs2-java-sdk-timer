package io.gs2.timer.control;

import io.gs2.control.Gs2BasicRequest;
import io.gs2.timer.Gs2Timer;

/**
 * タイマーの削除リクエスト。
 * 
 * @author Game Server Services, Inc.
 *
 */
@SuppressWarnings("serial")
public class DeleteTimerRequest extends Gs2BasicRequest<DeleteTimerRequest> {

	public static class Constant extends Gs2Timer.Constant {
		public static final String FUNCTION = "DeleteTimer";
	}

	/** タイマープール名 */
	String timerPoolName;
	/** タイマーID */
	String timerId;

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
	public DeleteTimerRequest withTimerPoolName(String timerPoolName) {
		setTimerPoolName(timerPoolName);
		return this;
	}
	/**
	 * タイマーIDを取得。
	 * 
	 * @return タイマーID
	 */
	public String getTimerId() {
		return timerId;
	}
	
	/**
	 * タイマーIDを設定。
	 * 
	 * @param timerId タイマーID
	 */
	public void setTimerId(String timerId) {
		this.timerId = timerId;
	}
	
	/**
	 * タイマーIDを設定。
	 * 
	 * @param timerId タイマーID
	 * @return this
	 */
	public DeleteTimerRequest withTimerId(String timerId) {
		setTimerId(timerId);
		return this;
	}
}
