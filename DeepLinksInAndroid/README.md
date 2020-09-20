# DeepLinksInAndroid
Deep Links to App in Android Sample

## AndroidManifest.xml

```xml
<activity android:name=".MainActivity">
    <intent-filter>
        <action android:name="android.intent.action.MAIN" />
        <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>
</activity>
<activity android:name=".SecondActivity">
    <intent-filter>
        <action android:name="android.intent.action.VIEW" />
        <category android:name="android.intent.category.DEFAULT" />
        <category android:name="android.intent.category.BROWSABLE" />
        
        <!-- Accepts URIs that begin with "http://www.vicky.com/” -->
        <data android:scheme="http"
                    android:host="www.vicky.com" />
    </intent-filter>
</activity>
```

## Getting clicked Deep Link URL in Java

```java
Intent intent = getIntent();
if(intent != null) {
    Uri uri = intent.getData();
    textView.setText(uri.toString());
}
```

## Reference

[Deep link to App in Android](https://developer.android.com/training/app-links/deep-linking)
