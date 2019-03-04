// Empty constructor
function VCPlugin() {}

// The function that passes work along to native shells
VCPlugin.prototype.show = function(serverName, userMail, passWord, personalID, successCallback, errorCallback) {
  var options = {};
  options.serverName = serverName;
  options.userMail = userMail;
  options.passWord = passWord;
  options.personalID = personalID;

  cordova.exec(successCallback, errorCallback, 'VCPlugin', 'show', [options]);
}

// Installation constructor that binds VCPlugin to window
VCPlugin.install = function() {
  if (!window.plugins) {
    window.plugins = {};
  }
  window.plugins.VCPlugin = new VCPlugin();
  return window.plugins.VCPlugin;
};
cordova.addConstructor(VCPlugin.install);
