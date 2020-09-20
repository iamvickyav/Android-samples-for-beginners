# SplashScreen_UsingTimer
Sample Android App to implement Splash Screen with Timer

> To implement Splash Screen using Themes background, please refer the other Github project - [SplashScreen_UsingThemeBackground](https://github.com/iamvickyav/SplashScreen_UsingThemeBackground)

In this method, we are going to have a seperate activity for SplashScreen, which will be configured as Launcher Activity. After some delay, MainActivity will be called.

## Create activity_splash.xml
```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/gradient" >

    <ImageView
        android:id="@+id/imgLogo"
        android:layout_width="300dp"
        android:layout_height="300dp"
        android:layout_centerInParent="true"
        android:src="@drawable/iron_kid" />

    <TextView
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="10dp"
        android:textSize="40sp"
        android:gravity="center_horizontal"
        android:layout_alignParentBottom="true"
        android:text="Splash Sample App" />

</RelativeLayout>
```

> Note: The background for RelativeLayout is set as @drawable/gradient. We used our own gradient background design as background for this sample (which is not mandatory)

## Create your own gradient background (drawable/gradient.xml)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item>
        <shape>
            <gradient
                android:startColor="@color/bg_start_color"
                android:endColor="@color/bg_end_color"
                android:angle="45"/>
        </shape>
    </item>
</selector>
```

## Create corresponding color values (values/colors.xml)
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="colorPrimary">#0099ff</color>
    <color name="colorPrimaryDark">#303F9F</color>
    <color name="colorAccent">#FF4081</color>
    <color name="bg_start_color">#3399ff</color>
    <color name="bg_end_color">#ffffff</color>
</resources>
```

## Create SplashActivity.java

```java
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
```

In the above code sample, run() will be executed after delay of 2000 milliseconds(2 seconds). In run() method, we have the code to navigate from SplashActivity to MainActitivy using intent

> Note finish() is called after startActivity(intent) to avoid opening SplashActivity again if user hits back button on MainActivity

## Remote ActionBar for SplashActivity in AndroidManifest.xml
```xml
<Manifest>


<activity
  android:name=".SplashActivity"
  android:theme="@style/Theme.AppCompat.NoActionBar">
    <intent-filter>
      <action android:name="android.intent.action.MAIN" />
      <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>
</activity>
<activity android:name=".MainActivity"/>


</manifest>
```

## Animated Screenshot

![SplashScreen_UsingThemes](https://media.giphy.com/media/OSvSrFIwglZIqtcyA5/giphy.gif)

## Reference
[Gradient Background in Android](http://www.singhajit.com/gradient-color-in-android/)

[Create your gradient combination](https://www.w3schools.com/colors/colors_gradient.asp)

[How to implement Android Splash Screen](https://www.androidhive.info/2013/07/how-to-implement-android-splash-screen-2/)
