# Capture Photo or Pick an Image from Gallery - Android Sample
Sample Android to demonstrate capture of photo using Android inbuilt camera app and selecting an existing picture from gallery

## Working version animated Screenshot

![Photo Basics](https://media.giphy.com/media/ddjtcTSyohx3IR04lZ/giphy.gif)

## To Capture Photo

### Open Camera using Intent
```java
Integer CAMERA_REQUEST = 101;

void openCamera() {
    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    if(takePictureIntent.resolveActivity(getPackageManager()) != null) {
       startActivityForResult(takePictureIntent, CAMERA_REQUEST);
    }
}
```

> Whenever we use startActivityForResult() method, we get call to onActivityResult() once the task is completed (in this case after picture is taken in camera


### Set the pic taken in an ImageView

```java
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
  if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
      Bundle extras = data.getExtras();
      Bitmap imageBitmap = (Bitmap) extras.get("data");
      imageView.setImageBitmap(imageBitmap);
   }
}
```

## To Pick Image from Gallery

### Open Image Picker using Intent

```java
Integer GALLERY_REQUEST = 201;

void openGallery() {
    Intent intent = new Intent();
    // Show only images, no videos or anything else
    intent.setType("image/*");
    intent.setAction(Intent.ACTION_GET_CONTENT);
    startActivityForResult(Intent.createChooser(intent, "Select Picture"), GALLERY_REQUEST);
}
```

> Whenever we use startActivityForResult() method, we get call to onActivityResult() once the task is completed (in this case after picture is chosen from Gallery


### Set the pic chosen in an ImageView
```java
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
  if (requestCode == GALLERY_REQUEST && resultCode == RESULT_OK) {
       Uri uri = data.getData();
       try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
            imageView.setImageBitmap(bitmap);
       } catch(IOException e) {
            e.printStackTrace();
       }
   }
}
```

## Reference
[Photo Basics](https://developer.android.com/training/camera/photobasics)
[Pick Image From Gallery](http://codetheory.in/android-pick-select-image-from-gallery-with-intents/)

