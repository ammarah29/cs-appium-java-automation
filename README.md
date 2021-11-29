# ClearScore Technical Test

## Setup Guide

### 1. Install Homebrew

``/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"``

#### To update brew to the latest version:
``git -C /usr/local/Homebrew/Library/Taps/homebrew/homebrew-core fetch --unshallow``  
``brew update``

### 2. Install Node
``brew install node``

### 3. Install JDK 11
``brew install java11``

Note: For the system Java wrappers to find this JDK, symlink it  
``sudo ln -sfn /usr/local/opt/openjdk@11/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk-11.jdk``

### 4. Install Gradle
``brew install gradle``

### 5. Install Appium
``npm install -g appium``

### 6. Install Android Studio
Install and launch Android Studio for the first time to install default Android SDK and platform-tools.
https://developer.android.com/studio

If you plan to run tests on an emulator, follow this guide to set up an Android emulator:
https://developer.android.com/studio/run/managing-avds

If you plan to run tests on a physical device, follow this guide to enable USB debugging on the device:
https://developer.android.com/studio/debug/dev-options

### 7. Ensure bash/zsh profile is up-to-date
Depending on whether your default shell is bash / zsh, open a terminal window and update one of the following:
- ~/.bash_profile
- ~/.zshrc

with:

export JAVA_HOME=`/usr/libexec/java_home -v 11`  
export ANDROID_HOME=$HOME/Library/Android/sdk

export PATH=$PATH:$JAVA_HOME  
export PATH=$PATH:$ANDROID_HOME/emulator  
export PATH=$PATH:$ANDROID_HOME/tools  
export PATH=$PATH:$ANDROID_HOME/tools/bin  
export PATH=$PATH:$ANDROID_HOME/platform-tools  

_Run ``source [bash/zsh profile path]`` from the terminal window in order for the new changes to be reflected_.
## Running Guide

1. Ensure the following properties file is updated with your test device details:
``src/test/resources/properties/config.properties``  

    - _deviceName: To get your device name, you can run ``adb devices`` in a terminal window while either your device is connected via USB or an emulator is open._
    - _deviceVersion: This is the OS version of the device. It can be found under Settings > About phone_
2. In the root directory of the project, run the following command from a terminal window:
``gradle test -d --rerun-tasks``
3. Once the test suite has finished executing, a Cucumber report can be found in ``src/test/resources/reports/cucumber.html``