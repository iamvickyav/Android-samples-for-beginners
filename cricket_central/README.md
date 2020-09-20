# cricket_central
Simple Android App to demonstrate ListView &amp; FloatingActionButton

## activity_main.xml 

[Reference activity_main.xml](https://github.com/iamvickyav/cricket_central/blob/master/app/src/main/res/layout/activity_main.xml)

### ListView

```xml
<ListView
        android:id="@+id/list_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
 ```
 
 
 ## listview_element.xml

[Reference listview_element.xml](https://github.com/iamvickyav/cricket_central/blob/master/app/src/main/res/layout/listview_element.xml)
```xml
<?xml version="1.0" encoding="utf-8"?>
<TextView xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:textSize="30sp">
</TextView>
```
 
 ## MainActivity.java
 
[Reference MainActivity java](https://github.com/iamvickyav/cricket_central/blob/master/app/src/main/java/com/iamvickyav/jarvis/cricketcentral/MainActivity.java)
 
 ### The data for ListView
 
 ```java
 String[] countries = {"India", "Australia", "New Zeland", "South Africa", "Pakistan",
            "Srilanka", "Bangladesh", "Afghanistan", "Ireland", "England", "West Indies", "Scotland",
            "UAE", "Kenya", "Nabibia", "Netherland", "USA" , "Zimbabwe", "Hong Kong", "Hong Kong",
            "Nepal", "Malaysia", "Myanmar", "Philippines", "Namibia", "Zambia",
            "Tanzania", "Singapore"};
 ```
 
 
 ### The magical Array Adapter
 ```java
  ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.listview_element, countries);
  ```

### Dependecies

```
compile 'com.android.support:appcompat-v7:26.0.1'
compile 'com.android.support:design:26.0.1'
```

 ### FloatingActionButton
 
 ```xml
 <android.support.design.widget.FloatingActionButton
        android:id="@+id/fab"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_alignParentRight="true"
        android:src="@android:drawable/arrow_up_float"
        android:visibility="gone"
        android:layout_marginRight="30dp"
        android:layout_marginBottom="30dp"/>
 ```
 
References 

https://developer.android.com/guide/topics/ui/floating-action-button
https://developer.android.com/reference/android/R.drawable


