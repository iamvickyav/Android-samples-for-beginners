# SplashScreen_UsingThemeBackground
Sample Android App to implement Splash Screen using Theme background (without timers)

> To implement Splash Screen using the older method of Timers, please refer the other Github project - [SplashScreen_UsingTimers](https://github.com/iamvickyav/SplashScreen_UsingTimer)

## Create your own Theme

To create your own customised theme, add entry in styles.xml

```xml
<style name="SplashTheme" parent="Theme.AppCompat.NoActionBar">
    <item name="android:windowBackground">@drawable/splash_bg</item>
</style>
```

You could see, we created our own theme with name as "SplashTheme" & we simply overided android:windowBackground. All other colors & properties for our theme will be inherited from Theme.AppCompat.NoActionBar theme as we specified it as parent.

## styles.xml after adding our theme

```xml
<resources>

    <!-- Base application theme. -->
    <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
    </style>

    <style name="SplashTheme" parent="Theme.AppCompat.NoActionBar">
        <item name="android:windowBackground">@drawable/splash_bg</item>
    </style>

</resources>
```

Create your own splash screen design in splash_bg.xml file under drawable folder

## splash_bg.xml

```xml
<?xml version="1.0" encoding="utf-8"?>

<layer-list xmlns:android="http://schemas.android.com/apk/res/android" android:opacity="opaque">

    <item android:drawable="@android:color/white"/>

    <item>
        <bitmap
            android:src="@drawable/avenger"
            android:gravity="center"/>
    </item>

</layer-list>
```

Here we used avenger image (drawable/avenger.png) as our app logo by specifying in android:src of bitmap. Now we have our own theme ready. 

## Apply theme in AndroidManifest.xml for your launcher activity alone

```xml
<activity android:name=".MainActivity"
         android:theme="@style/SplashTheme">
    <intent-filter>
        <action android:name="android.intent.action.MAIN" />
        <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>
</activity>
```

## Use setTheme() method to override SplashTheme with your default theme before super.onCreate() call

```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
```
## Animated Screenshot

![SplashScreen_UsingThemes](https://media.giphy.com/media/1APhK738hMsloMtwaf/giphy.gif)

## Reference
[The (Complete) Android Splash Screen Guide](https://android.jlelse.eu/the-complete-android-splash-screen-guide-c7db82bce565)

