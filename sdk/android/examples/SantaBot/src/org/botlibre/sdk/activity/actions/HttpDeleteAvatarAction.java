package org.botlibre.sdk.activity.actions;

import org.botlibre.sdk.activity.AvatarActivity;
import org.botlibre.sdk.activity.MainActivity;
import org.botlibre.sdk.config.AvatarConfig;

import android.app.Activity;

public class HttpDeleteAvatarAction extends HttpUIAction {

	AvatarConfig config;
	
	public HttpDeleteAvatarAction(Activity activity, AvatarConfig config) {
		super(activity);
		this.config = config;
	}

	@Override
	protected String doInBackground(Void... params) {
		try {
		MainActivity.connection.deleteAvatar(this.config);
		} catch (Exception exception) {
			this.exception = exception;
		}
		return "";	
	}

	@Override
	public void onPostExecute(String xml) {
		super.onPostExecute(xml);
		if (this.exception != null) {
			return;
		}
		((AvatarActivity)this.activity).resetAvatars();
    }
}