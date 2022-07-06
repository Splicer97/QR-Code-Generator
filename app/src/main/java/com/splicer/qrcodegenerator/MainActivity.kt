package com.splicer.qrcodegenerator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.WriterException

class MainActivity : AppCompatActivity() {
    var im: ImageView? = null
    var bGenerate: Button? = null
    var bScanner: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        im = findViewById(R.id.imageView)
        bGenerate = findViewById(R.id.button)
        bScanner = findViewById(R.id.bScan)
        bScanner?.setOnClickListener {
            startActivity(Intent(this, ScannerActivity:: class.java))
        }
        bGenerate?.setOnClickListener {
            generateQrCode("Поставь лайк если понравилось видео!!")
        }
    }

    private fun generateQrCode(text: String){
        val qrGenerator = QRGEncoder(text, null, QRGContents.Type.TEXT, 500)
        try {
            val bMap = qrGenerator.bitmap
            im?.setImageBitmap(bMap)
        } catch (e: WriterException){

        }
    }

}