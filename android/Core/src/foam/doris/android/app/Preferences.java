package foam.doris.android.app;

import java.io.File;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class Preferences {
	public static boolean httpRunning = false;

	public static boolean AutoFetch = false;

	public static boolean vibrate = false;

	public static boolean ringtone = false;

	public static boolean flashLed = false;

	public static int countries = 0;

	public static int AutoUpdateDelay = 0;

	public static String LobsterId = "0";

	public static String StringId = "0";

	public static final int NOTIFICATION_ID = 1;

	public static final String PREFS_NAME = "UshahidiService";

	public static String incidentsResponse = "";

	public static String categoriesResponse = "";

	public static String savePath = "";

	public static String domain = "";

	public static String firstname = "boat";

	public static String lastname = "";

	public static String email = "";

	public static String totalReports = "";

	public static String fileName = "";

	public static int isCheckinEnabled = 0;

	public static int appRunsFirstTime = 0;

	public static int activeDeployment = 0;

	public static String activeMapName = "";

	public static int photoWidth = 1024;

	public static String deploymentLatitude = "0.0";

	public static String deploymentLongitude = "0.0";

	public static int selectedDistance = 3;

	private static SharedPreferences settings;

	private static SharedPreferences.Editor editor;

	public static String totalReportsFetched = "";

	public static String username = "";
	public static String password = "";

	public static String phonenumber = "";
	public static String ogsPluginVersion = "";
	public static String openGeoSmsUrl = "http://maps.google.com/";

    public static void loadIDs(SharedPreferences settings) {
		firstname = settings.getString("first_name_preference", "Trip001");
        Log.i("DORIS","set firstname to "+firstname);
		LobsterId = settings.getString("lobster_id_preference", "0");
		StringId = settings.getString("string_id_preference", "0");
    }

	public static void loadSettings(Context context) {
		final SharedPreferences settings = context.getSharedPreferences(
				PREFS_NAME, 0);

		final String path = context.getDir("",
				Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE)
				.toString();

		savePath = settings.getString("savePath", path);

		domain = settings.getString("Domain", Preferences.domain);
		fileName = settings.getString("FileName", "");
		firstname = settings.getString("Firstname", "Trip001");
		lastname = settings.getString("Lastname", "");
		email = settings.getString("Email", "");
		countries = settings.getInt("Countries", 0);

		LobsterId = settings.getString("LobsterId", "0");
		StringId = settings.getString("StringId", "0");
		AutoUpdateDelay = settings.getInt("AutoUpdateDelay", 5);
		AutoFetch = settings.getBoolean("AutoFetch", false);
		totalReports = settings.getString("TotalReports", "20");
		isCheckinEnabled = settings.getInt("CheckinEnabled", isCheckinEnabled);
		activeDeployment = settings.getInt("ActiveDeployment", 0);
		activeMapName = settings.getString("ActiveMapName", "");
		deploymentLatitude = settings.getString("DeploymentLatitude", "0.0");
		deploymentLongitude = settings.getString("DeploymentLongitude", "0.0");
		photoWidth = settings.getInt("PhotoWidth", 1024);
		appRunsFirstTime = settings
				.getInt("AppRunsFirstTime", appRunsFirstTime);
		username = settings.getString("username", "");
		password = settings.getString("password", "");

		selectedDistance = settings.getInt("SelectedDistance", 3);

		// @inoran
		phonenumber = settings.getString("Phonenumber", "");
		ogsPluginVersion = settings.getString("OgsPluginVersion", "");
		// make sure folder exists
		final File dir = new File(Preferences.savePath);
		dir.mkdirs();

	}

	private static boolean hasValue(String s){
		return s != null && !"".equals(s);
	}

	private static boolean hasPhoneNumber(){
		return hasValue(phonenumber);
	}

	public static boolean canReceiveOpenGeoSms(){
		return hasValue(ogsPluginVersion) && hasPhoneNumber();
	}

	public static void saveSettings(Context context) {
		settings = context.getSharedPreferences(PREFS_NAME, 0);
		editor = settings.edit();
		editor.putString("Domain", domain);
		editor.putString("FileName", fileName);
		editor.putInt("CheckinEnabled", isCheckinEnabled);
		editor.putInt("ActiveDeployment", activeDeployment);
		editor.putString("ActiveMapName", activeMapName);
		editor.putString("DeploymentLatitude", deploymentLatitude);
		editor.putString("DeploymentLongitude", deploymentLongitude);
		editor.putInt("AppRunsFirstTime", appRunsFirstTime);
		editor.putInt("SelectedDistance", selectedDistance);
		editor.putString("Phonenumber", phonenumber);
		editor.putString("OgsPluginVersion", ogsPluginVersion);
//		editor.putString("LobsterId", LobsterId);
//		editor.putString("StringId", StringId);
		editor.commit();
	}
}
