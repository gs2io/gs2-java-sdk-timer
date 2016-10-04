package io.gs2.timer.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * タイマープール
 * 
 * @author Game Server Services, Inc.
 *
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown=true)
public class TimerPool implements Serializable {

	/** タイマープールID */
	String timerPoolId;
	/** オーナーID */
	String ownerId;
	/** タイマープール名 */
	String name;
	/** 説明文 */
	String description;
	/** 作成日時 */
	Long createAt;
	
	/**
	 * タイマープールIDを取得
	 * 
	 * @return タイマープールID
	 */
	public String getTimerPoolId() {
		return timerPoolId;
	}
	
	/**
	 * タイマープールIDを設定
	 * 
	 * @param timerPoolId タイマープールID
	 */
	public void setTimerPoolId(String timerPoolId) {
		this.timerPoolId = timerPoolId;
	}
	
	/**
	 * オーナーIDを取得
	 * 
	 * @return オーナーID
	 */
	public String getOwnerId() {
		return ownerId;
	}
	
	/**
	 * オーナーIDを設定
	 * 
	 * @param ownerId オーナーID
	 */
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	
	/**
	 * タイマープール名を取得
	 * 
	 * @return タイマープール名
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * タイマープール名を設定
	 * 
	 * @param name タイマープール名
	 */
	public void setName(String name) {
		this.name = name;
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
	public TimerPool withDescription(String description) {
		setDescription(description);
		return this;
	}
	
	/**
	 * 作成日時を取得
	 * 
	 * @return 作成日時
	 */
	public Long getCreateAt() {
		return createAt;
	}
	
	/**
	 * 作成日時を設定
	 * 
	 * @param createAt 作成日時
	 */
	public void setCreateAt(Long createAt) {
		this.createAt = createAt;
	}
}
