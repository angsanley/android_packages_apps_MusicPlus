package id.angsanley.musicplus;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.WindowManager;

import org.apache.cordova.Config;
import org.apache.cordova.DroidGap;

public class cordovaactivity extends DroidGap {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("Free Mp3 Provided by AngSanley Music");
	    super.setBooleanProperty("showTitle", true);
	    super.onCreate(savedInstanceState);
        // Show MusicEULA
		new MusicEULA(this).show();
        super.setIntegerProperty("splashscreen", R.drawable.musicsplash);
        super.setStringProperty("loadingDialog", "Please Wait, Loading...");
	    super.loadUrl("http://music.angsanley.ml/cordova/cordova");
	    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.actionbar_top, menu);
		return true;
	}

}
