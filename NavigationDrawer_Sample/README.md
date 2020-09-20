# NavigationDrawer_Sample

### Support Library Dependencies

```
implementation 'com.android.support:design:28.0.0-rc01'
```

### [activity_main.xml](https://github.com/iamvickyav/NavigationDrawer_Sample/blob/master/app/src/main/res/layout/activity_main.xml)

**Add NavigationView inside DrawerLayout**
**FrameLayout below will display as main body of the screen**

```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.v4.widget.DrawerLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/my_drawer"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <FrameLayout
        android:id="@+id/content_frame"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <TextView
            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:text="Hello SRM"/>
            
    </FrameLayout>

    <android.support.design.widget.NavigationView
        android:id="@+id/nav_view"
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        android:layout_gravity="start"
        android:fitsSystemWindows="true"
        app:headerLayout="@layout/my_header"
        app:menu="@menu/my_nav_menu">

    </android.support.design.widget.NavigationView>

</android.support.v4.widget.DrawerLayout>
```
### Sample Screenshot with only Menu (app:menu="@menu/my_nav_menu" in NavigationView

<img src="https://image.ibb.co/io2iSe/Screenshot_1535048007.png" alt="NavigationDrawer_Screenshot" width="300"/>

### Sample Screenshot with only Header (app:headerLayout="@layout/my_header") in NavigationView

<img src="https://image.ibb.co/ggVWDK/Screenshot_1535048128.png" alt="NavigationDrawer_Screenshot" width="300"/>

### Sample Screenshot with both Menu & Header in NavigationView)

<img src="https://image.ibb.co/h3EBfz/Screenshot_1535047699.png" alt="NavigationDrawer_Screenshot" width="300"/>

### Adding Menu Items for NavigationDrawer under res/layout/my_nav_menu.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <group android:checkableBehavior="single">
        <item
            android:id="@+id/nav_camera"
            android:icon="@drawable/account"
            android:title="Account" />
        <item
            android:id="@+id/nav_gallery"
            android:icon="@drawable/gallery"
            android:title="Gallery" />
        <item
            android:id="@+id/nav_slideshow"
            android:icon="@drawable/settings"
            android:title="Settings" />
    </group>
</menu>
```

### Adding Header for NavigationDrawer under res/menu/my_header.xml

```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="120dp"
    android:background="@android:color/holo_green_light"
    android:padding="16dp"
    android:orientation="vertical">

    <ImageView
        android:id="@+id/img"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:src="@drawable/ic_launcher_background"/>

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Vicky AV"
        android:layout_toRightOf="@id/img"
        android:textAppearance="@style/TextAppearance.AppCompat.Body1"/>

</RelativeLayout>
```

### [MainActivity.java](https://github.com/iamvickyav/NavigationDrawer_Sample/blob/master/app/src/main/java/com/iamvickyav/jarvis/navdrawersample/MainActivity.java)

```java
public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.my_drawer);
        navigationView = findViewById(R.id.nav_view);
        textView = findViewById(R.id.textView);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                textView.setText(menuItem.getTitle());
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }
}
```

Reference : [Implementing Navigation Drawer](https://developer.android.com/training/implementing-navigation/nav-drawer)
