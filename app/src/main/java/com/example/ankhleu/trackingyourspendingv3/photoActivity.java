package com.example.ankhleu.trackingyourspendingv3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ankhleu.trackingyourspendingv3.R;
import com.example.ankhleu.trackingyourspendingv3.Tripadddetail;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//import static com.example.ankhleu.trackingyourspendingv3.Tripadddetail.timeget;

public class photoActivity extends Tripadddetail {



    public TextView textView2;
    public ImageView imageView2;
    public ImageView imageView3;
    public ImageView imageView4;
    public ImageView imageView5;


    protected void onCreate(Bundle savedInstanceState) {

        super.newtime = "IMG_20180202_064446.jpg";
        //IMG_20180205_015846.jpg
        //IMG_20180202_071708jpg
        //IMG_20180205_015846.jpg

        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_photo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        textView2=(TextView) findViewById(R.id.textView2);
        //textView2.setText(super.newtime.substring(4,12));
        textView2.setText(Tripadddetail.newtime.substring(4,12));


        imageView2=(ImageView) findViewById(R.id.imageView2);
        imageView3=(ImageView) findViewById(R.id.imageView3);
        imageView4=(ImageView) findViewById(R.id.imageView4);
        imageView5=(ImageView) findViewById(R.id.imageView5);

        //imageView2.setImageResource(R.drawable.bill02);
        //private ImageView imageView;
        //String fileName= Environment.getExternalStorageDirectory().getPath()+"/DCIM/Camera/"+"mountain.jpg";
        String fileName= Environment.getExternalStorageDirectory().getPath()+"/DCIM/Camera/IMG_20180202_064446.jpg";
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;//圖片寬高都為原來的二分之一，即圖片為原來的四分之一
        Bitmap b = BitmapFactory.decodeFile(fileName, options);
        imageView2.setImageBitmap(b);
        //textView2.setText(fileName);
        String fileName3= Environment.getExternalStorageDirectory().getPath()+"/DCIM/Camera/mountain.jpg";
        //options = new BitmapFactory.Options();
        BitmapFactory.Options options3 = new BitmapFactory.Options();
        options3.inSampleSize = 1;
        Bitmap b3 = BitmapFactory.decodeFile(fileName3, options3);
        imageView3.setImageBitmap(b3);

        fileName= Environment.getExternalStorageDirectory().getPath()+"/DCIM/Camera/mountain.jpg";
        b = BitmapFactory.decodeFile(fileName, options3);
        imageView4.setImageBitmap(b);
        imageView5.setImageBitmap(b);




        Log.d("path2=", Environment.getExternalStorageDirectory().getPath());


        /*
        File f = new File("IMG_20180202_071119.jpg");
        Uri photoUri = FileProvider.getUriForFile(this, this.getApplicationContext().getPackageName()
                + ".my.package.name.provider", f);
        try {
            // InputStream is = new FileInputStream(photoUri);
            InputStream is = getContentResolver().openInputStream(photoUri);
            Log.d("BMP", "Can READ:" + is.available());
            Bitmap bmp = getFitImage(is);
            imageView2.setImageBitmap(bmp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

/*        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }

        );
*/

        //Log.d("TEST=","test");
        Log.d("IMG name=",super.newtime);


    }
    /*
    public static Bitmap getFitImage(InputStream is)
    {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        byte[] bytes = new byte[0];
        try {
            bytes = readStream(is);
            //BitmapFactory.decodeStream(inputStream, null, options);
            Log.d("BMP", "byte length:" + bytes.length);
            Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);
            System.gc();
            // Log.d("BMP", "Size:" + bmp.getByteCount());
            return bmp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static byte[] readStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        outStream.close();
        inStream.close();
        return outStream.toByteArray();
    }
    */

}
