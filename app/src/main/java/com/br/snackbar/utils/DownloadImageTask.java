package com.br.snackbar.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

    public DownloadImageTask(ImageView bmImage) {
        this.bmImage = bmImage;
    }

    ImageView bmImage;

    protected void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);
    }

    @Override
    protected Bitmap doInBackground(String[] objects) {
            Bitmap mIcon11 = null;
        try {
            String urldisplay =  expandUrl(objects[0]) ;
            InputStream in = new URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }

    public String expandUrl(String shortenedUrl) throws IOException {
        URL url = new URL(shortenedUrl);
        // open connection
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);

        // stop following browser redirect
        httpURLConnection.setInstanceFollowRedirects(false);

        // extract location header containing the actual destination URL
        String expandedURL = httpURLConnection.getHeaderField("Location");
        httpURLConnection.disconnect();

        if (TextUtils.isEmpty(expandedURL)) {
            return shortenedUrl;
        }

        return expandedURL;
    }
}
