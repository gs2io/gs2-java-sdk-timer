package io.gs2.timer.control;

import io.gs2.control.Gs2BasicRequest;
import io.gs2.timer.Gs2Timer;

/**
 * タイマープールの取得リクエスト。
 * 
 * @author Game Server Services, Inc.
 *
 */
@SuppressWarnings("serial")
public class GetTimerPoolRequest extends Gs2BasicRequest<GetTimerPoolRequest> {

	public static class Constant extends Gs2Timer.Constant {
		public static final String FUNCTION = "GetTimerPool";
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
	public GetTimerPoolRequest withTimerPoolName(String timerPoolName) {
		setTimerPoolName(timerPoolName);
		return this;
	}
}
