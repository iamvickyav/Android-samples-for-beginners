# NavigationDrawerWithFragment

### Support Library Dependencies

```
implementation 'com.android.support:design:28.0.0-rc01'
```

### activity_main.xml

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
### Sample Screenshot with both Menu & Header in NavigationView)

<img src="https://image.ibb.co/h3EBfz/Screenshot_1535047699.png" alt="NavigationDrawer_Screenshot" width="300"/>

### Adding Menu Items for NavigationDrawer under res/layout/my_nav_menu.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <group android:checkableBehavior="single">
        <item
            android:id="@+id/nav_account"
            android:icon="@drawable/account"
            android:title="Account" />
        <item
            android:id="@+id/nav_gallery"
            android:icon="@drawable/gallery"
            android:title="Gallery" />
        <item
            android:id="@+id/nav_settings"
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

### fragment_1.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="30sp"
        android:text="Fragment 1"
        android:id="@+id/textView1"
        android:layout_centerInParent="true" />

</RelativeLayout>
```
### fragment_2.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="30sp"
        android:text="Fragment 2"
        android:id="@+id/textView2"
        android:layout_centerInParent="true" />

</RelativeLayout>
```
### fragment_3.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="30sp"
        android:text="Fragment 3"
        android:id="@+id/textView3"
        android:layout_centerInParent="true" />

</RelativeLayout>
```
### Fragment1.java
```java
public class Fragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_1, container, false);
    }
}
```

### Fragment2.java
```java
public class Fragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_2, container, false);
    }
}
```

### Fragment3.java
```java
public class Fragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_3, container, false);
    }
}
```
### MainActivity.java

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
                Fragment fragment = null;
                switch (menuItem.getItemId()) {

                    case R.id.nav_account:
                        fragment = new Fragment1();
                        break;
                    case R.id.nav_gallery:
                        fragment = new Fragment2();
                        break;
                    case R.id.nav_settings:
                        fragment = new Fragment3();
                        break;
                }

                if (fragment != null) {
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.content_frame, fragment);
                    ft.commit();
                }

                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }
}
```

Reference : [Implementing Navigation Drawer](https://developer.android.com/training/implementing-navigation/nav-drawer)
[Adding Fragments in Navigation Drawer](https://www.simplifiedcoding.net/android-navigation-drawer-example-using-fragments/#Adding-Navigation-Drawer-Activity)
