# ImageViewWIthPicaso with Toolbar

### Picasso Dependencies

```
implementation 'com.squareup.picasso:picasso:2.5.1'
```

### [activity_main.xml](https://github.com/sathya26d94/ImageViewWIthPicaso/blob/master/app/src/main/res/layout/activity_main.xml)

**Add ImageView in Design**

```xml
<ImageView
        android:id="@+id/imageView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true" />
```

### [MainActivity.java](https://github.com/sathya26d94/ImageViewWIthPicaso/blob/master/app/src/main/java/com/example/sathya/imagedemo/MainActivity.java) 

**We have two methods one for loading without rotation & other for with rotation**

```java
public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    String url = "https://i.pinimg.com/564x/b2/45/37/b24537a5a41ca67dacfec5f3c2655ef9.jpg";
    Float angle = 0f;
    
    private void loadImage(String url, Float rotation, ImageView imageView) {
        Picasso.with(this)
                .load(url)
                .resize(1200, 1400)
                .rotate(rotation)
                .into(imageView);
    }

    private void loadImageWithRotation(String url, Float rotation, ImageView imageView) {
        angle += rotation;
        Picasso.with(this)
                .load(url)
                .resize(1200, 1400)
                .rotate(angle)
                .into(imageView);
    }
}
```

### Adding Menus

**Change theme in AndroidManifest.xml**

```xml
 android:theme="@style/Theme.AppCompat.Light.NoActionBar"
``` 

**Add Menu in XML file**

Create a "menu" folder under res directory. So your folder structure will look like res/menu. Under menu folder, create xml file with menu items

[res/menu/my_menu.xml](https://github.com/sathya26d94/ImageViewWIthPicaso/blob/master/app/src/main/res/menu/my_menu.xml)

```xml
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <item
        android:id="@+id/rotate_right"
        android:icon="@drawable/rotate_right"
        android:title="right"
        app:showAsAction="ifRoom"/>

    <item
        android:id="@+id/rotate_left"
        android:icon="@drawable/rotate_left"
        android:title="left"
        app:showAsAction="ifRoom"/>
        
    <item android:id="@+id/action_settings"
        android:title="settings"
        app:showAsAction="never"/>
</menu>
```

**Create Menu in activity_main.xml**

activity_main.xml

```xml
<android.support.v7.widget.Toolbar
        android:id="@+id/my_toolbar"
        android:layout_width="match_parent"
        android:layout_height="?attr/actionBarSize"
        android:background="?attr/colorPrimary"
        android:elevation="4dp"
        android:theme="@style/ThemeOverlay.AppCompat.ActionBar"
        app:popupTheme="@style/ThemeOverlay.AppCompat.Light"/>
```

**Add following code in MainActivity.java to display menu bar**

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
    setSupportActionBar(myToolbar);
 
    // Remaining code will follow
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.my_menu, menu);
    return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {

    case R.id.rotate_right:
      loadImageWithRotation(url, 90f, imageView);
       return true;
    case R.id.rotate_left:
       loadImageWithRotation(url, 270f, imageView);
        return true;
  }
  return (super.onOptionsItemSelected(item));
}
```

Reference 

For Logos - https://material.io/tools/icons/?icon=rotate_right&style=baseline
For App Bar - https://developer.android.com/training/appbar/
