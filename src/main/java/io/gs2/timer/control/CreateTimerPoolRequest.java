/*
 * Copyright 2016 Game Server Services, Inc. or its affiliates. All Rights
 * Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package io.gs2.timer.control;

import org.json.JSONObject;
import java.util.List;
import io.gs2.timer.Gs2Timer;
import io.gs2.control.Gs2BasicRequest;

/**
 * @author Game Server Services, Inc.
 */
@SuppressWarnings("serial")
public class CreateTimerPoolRequest extends Gs2BasicRequest<CreateTimerPoolRequest> {

	public static class Constant extends Gs2Timer.Constant {
		public static final String FUNCTION = "CreateTimerPool";
	}

	/** タイマープールの名前 */
	private String name;

	/** タイマープールの説明 */
	private String description;


	/**
	 * タイマープールの名前を取得
	 *
	 * @return タイマープールの名前
	 */
	public String getName() {
		return name;
	}

	/**
	 * タイマープールの名前を設定
	 *
	 * @param name タイマープールの名前
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * タイマープールの名前を設定
	 *
	 * @param name タイマープールの名前
	 * @return this
	 */
	public CreateTimerPoolRequest withName(String name) {
		setName(name);
		return this;
	}

	/**
	 * タイマープールの説明を取得
	 *
	 * @return タイマープールの説明
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * タイマープールの説明を設定
	 *
	 * @param description タイマープールの説明
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * タイマープールの説明を設定
	 *
	 * @param description タイマープールの説明
	 * @return this
	 */
	public CreateTimerPoolRequest withDescription(String description) {
		setDescription(description);
		return this;
	}

}