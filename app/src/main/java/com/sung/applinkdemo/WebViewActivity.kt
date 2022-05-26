//package com.sung.applinkdemo
//
//import android.annotation.SuppressLint
//import android.graphics.Bitmap
//import android.net.http.SslError
//import android.os.Bundle
//import android.view.KeyEvent
//import android.webkit.SslErrorHandler
//import android.webkit.WebView
//import android.webkit.WebViewClient
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//
//class WebViewActivity : AppCompatActivity() {
//
//    lateinit var webView: WebView
//    val context = this
//
//    @SuppressLint("SetJavaScriptEnabled")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_web_view)
//        webView = findViewById(R.id.web)
//        val url = intent.extras?.getString("web_url")
//        webView.settings.javaScriptEnabled = true
//        webView.settings.setSupportZoom(false)
//        webView.settings.domStorageEnabled = true
//        webView.webViewClient = myWebViewclient()
//        webView.loadUrl(url!!)
//
////        //  ==================== START HERE: THIS CODE BLOCK IS TO ENABLE FILE DOWNLOAD FROM THE WEB. YOU CAN COMMENT IT OUT IF YOUR APPLICATION DOES NOT REQUIRE FILE DOWNLOAD. IT WAS ADDED ON REQUEST ======//
//        webView.setDownloadListener(object : DownloadListener {
//            var fileName = MimeTypeMap.getFileExtensionFromUrl(url)
//            override fun onDownloadStart(
//                url: String, userAgent: String,
//                contentDisposition: String, mimetype: String,
//                contentLength: Long,
//            ) {
//                val request = DownloadManager.Request(
//                    Uri.parse(url))
//                request.allowScanningByMediaScanner()
//                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED) //Notify client once download is completed!
//                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName)
//                val dm = getSystemService(DOWNLOAD_SERVICE) as DownloadManager
//                dm.enqueue(request)
//                Toast.makeText(applicationContext,
//                    "Downloading File",  //To notify the Client that the file is being downloaded
//                    Toast.LENGTH_LONG).show()
//            }
//        })
//    }
//
//    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
//            webView.goBack()
//            return true
//        }
//        return super.onKeyDown(keyCode, event)
//    }
//
//
//    inner class myWebViewclient : WebViewClient() {
//        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
//            view.loadUrl(url)
//            return true
//        }
//
//        override fun onReceivedError(
//            view: WebView,
//            errorCode: Int,
//            description: String,
//            failingUrl: String,
//        ) {
//            Toast.makeText(context, "No internet connection", Toast.LENGTH_LONG)
//                .show()
//            webView.loadUrl("file:///android_asset/lost.html")
//        }
//
//        override fun onReceivedSslError(view: WebView, handler: SslErrorHandler, error: SslError) {
//            super.onReceivedSslError(view, handler, error)
//            handler.cancel()
//        }
//
//        override fun onPageStarted(view: WebView, url: String, favicon: Bitmap) {
//            super.onPageStarted(view, url, favicon)
//            // progressBar.setVisibility(View.VISIBLE);
//        }
//
//        override fun onPageFinished(view: WebView, url: String) {
//            super.onPageFinished(view, url)
//            //   progressBar.setVisibility(View.GONE);
//        }
//    }
//}