/**
* This file provides simple End User License Agreement
* It shows a simple dialog with the license text, and two buttons.
* If user clicks on 'cancel' button, app closes and user will not be granted access to app.
* If user clicks on 'accept' button, app access is allowed and this choice is saved in preferences
* so next time this will not show, until next upgrade.
*/
package id.angsanley.musicplus;

import id.angsanley.musicplus.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;

public class MusicEULA {
private String EULA_PREFIX = "musiceula";
private Activity mContext;

public MusicEULA(Activity context) {
mContext = context;
}

private PackageInfo getPackageInfo() {
PackageInfo info = null;
try {
info = mContext.getPackageManager().getPackageInfo(
mContext.getPackageName(), PackageManager.GET_ACTIVITIES);
} catch (PackageManager.NameNotFoundException e) {
e.printStackTrace();
}
return info;
}

public void show() {
PackageInfo versionInfo = getPackageInfo();

		// The eulaKey changes every time you increment the version number in
		// the AndroidManifest.xml
		final String eulaKey = EULA_PREFIX + versionInfo.versionCode;
		final SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(mContext);

boolean bAlreadyAccepted = prefs.getBoolean(eulaKey, false);
if (bAlreadyAccepted == false) {

// EULA title
String title = mContext.getString(R.string.freemp3_button) + " powered by AngSanley Music";

// EULA text
String message = mContext.getString(R.string.musiceula);

// Disable orientation changes, to prevent parent activity
// reinitialization
mContext.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

AlertDialog.Builder builder = new AlertDialog.Builder(mContext)
.setTitle(title)
.setCancelable(false)
.setMessage(message)
.setPositiveButton(R.string.accept,
new Dialog.OnClickListener() {

@Override
public void onClick(
DialogInterface dialogInterface, int i) {
// Mark this version as read.
SharedPreferences.Editor editor = prefs
.edit();
editor.putBoolean(eulaKey, true);
editor.commit();

// Close dialog
dialogInterface.dismiss();
}
})
.setNegativeButton(android.R.string.cancel,
new Dialog.OnClickListener() {

@Override
public void onClick(DialogInterface dialog,
int which) {
// Close the activity as they have declined
// the EULA
mContext.finish();
}

});
builder.create().show();
}
}
}