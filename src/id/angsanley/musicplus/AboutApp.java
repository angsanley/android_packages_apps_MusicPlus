package id.angsanley.musicplus;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AboutApp extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cordova_view);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.actionbar_top, menu);
		return true;
	}

}
