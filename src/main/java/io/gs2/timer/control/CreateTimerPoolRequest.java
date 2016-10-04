package io.gs2.timer.control;

import io.gs2.control.Gs2BasicRequest;
import io.gs2.timer.Gs2Timer;

/**
 * タイマープールの作成リクエスト。
 * 
 * @author Game Server Services, Inc.
 *
 */
@SuppressWarnings("serial")
public class CreateTimerPoolRequest extends Gs2BasicRequest<CreateTimerPoolRequest> {

	public static class Constant extends Gs2Timer.Constant {
		public static final String FUNCTION = "CreateTimerPool";
	}

	/** 名前 */
	String name;
	/** 説明文 */
	String description;

	/**
	 * 名前を取得。
	 * 
	 * @return 名前
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 名前を設定。
	 * 
	 * @param name 名前
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 名前を設定。
	 * 
	 * @param name 名前
	 * @return this
	 */
	public CreateTimerPoolRequest withName(String name) {
		setName(name);
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
	public CreateTimerPoolRequest withDescription(String description) {
		setDescription(description);
		return this;
	}
	
}
