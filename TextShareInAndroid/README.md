# TextShareInAndroid
Sharing simple text between Activity within app &amp; outside (to other apps)

***For application with multiple activities, make sure you have entry in AndroidManifest for Activity to avoid run time exceptions***

## Navigation between Activities (without any data)

```java
Intent intent = new Intent(MainActivity.this, SecondActivity.class);

startActivity(intent);
```

## Sending String data from one Activity

```java
String data = "Hi, This is my message";

Intent intent = new Intent(MainActivity.this, SecondActivity.class);
intent.putExtra("mydata", data);

startActivity(intent);
```

## Receiving String data in Another Activity

```java
Intent intent = getIntent();
if(intent != null) {
  String data = intent.getStringExtra("mydata");
  textView.setText(data);
}
```


## Sharing data to other apps

```java
String data = "Hi, This is my message";

Intent intent = new Intent();
intent.setAction(Intent.ACTION_SEND);
intent.putExtra(Intent.EXTRA_TEXT, data);
intent.setType("text/plain");

startActivity(intent);
```

## Reference
[Sending simple data to other apps in Android](https://developer.android.com/training/sharing/send)

