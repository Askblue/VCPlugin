package com.askblue.vcplugin;

// The native Toast API
import android.widget.Toast;

// Cordova-required packages
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class VCPlugin extends CordovaPlugin {

  @Override
  public boolean execute(String action, JSONArray args,
    final CallbackContext callbackContext) {
      // Verify that the user sent a 'show' action
      if (!action.equals("show")) {
        callbackContext.error("\"" + action + "\" is not a recognized action.");
        return false;
      }
      
      String serverName;
      String userMail;
      String passWord;
      String personalID;

      try {
        JSONObject options = args.getJSONObject(0);
        serverName = options.getString("serverName");
        userMail = options.getString("userMail");
        passWord = options.getString("passWord");
        personalID = options.getString("personalID");
      } catch (JSONException e) {
        callbackContext.error("Error encountered: " + e.getMessage());
        return false;
      }
      // Create the toast
      Toast toast = Toast.makeText(cordova.getActivity(), serverName + " " + userMail + " " + passWord + " " + personalID , Toast.LENGTH_LONG );
      // Display toast
      toast.show();
      // Send a positive result to the callbackContext
      PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
      callbackContext.sendPluginResult(pluginResult);
      return true;
  }
}
