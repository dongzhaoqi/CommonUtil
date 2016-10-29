public class Utils{

//scale a picture
public static void setPic(ImageView mImageView) {
    // Get the dimensions of the View
    int targetW = mImageView.getWidth();
    int targetH = mImageView.getHeight();

    // Get the dimensions of the bitmap
    BitmapFactory.Options bmOptions = new BitmapFactory.Options();
    bmOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
    int photoW = bmOptions.outWidth;
    int photoH = bmOptions.outHeight;

    // Determine how much to scale down the image
    int scaleFactor = Math.min(photoW/targetW, photoH/targetH);

    // Decode the image file into a Bitmap sized to fill the View
    bmOptions.inJustDecodeBounds = false;
    bmOptions.inSampleSize = scaleFactor;
    bmOptions.inPurgeable = true;

    Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
    mImageView.setImageBitmap(bitmap);
}

}



private Bitmap decodeSampleBitmapFromUri(String absolutePath, int reqWidth, int reqHeight) {  
        // TODO Auto-generated method stub  
        Bitmap bm = null;  
  
        // First decode with inJustDecodeBounds=true to check dimensions  
        final BitmapFactory.Options options = new BitmapFactory.Options();  
        options.inJustDecodeBounds = true;  
        BitmapFactory.decodeFile(absolutePath, options);  
  
        // Calculate inSampleSize  
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);  
  
        // Decode bitmap with inSampleSize set  
        options.inJustDecodeBounds = false;  
        bm = BitmapFactory.decodeFile(absolutePath, options);  
        return bm;  
    }  
  
  
    private int calculateInSampleSize(BitmapFactory.Options options, int reqWidth,  
                                      int reqHeight) {  
        // TODO Auto-generated method stub  
        // Raw height and width of image  
        final int height = options.outHeight;  
        final int width = options.outWidth;  
        int inSampleSize = 1;  
  
        if (height > reqHeight || width > reqWidth) {  
            if (width > height) {  
                inSampleSize = Math.round((float) height / (float) reqHeight);  
            } else {  
                inSampleSize = Math.round((float) width / (float) reqWidth);  
            }  
        }  
        return inSampleSize;  
    }  
