package com.example.animationbitmaps

import android.app.Activity
import android.graphics.*
import android.graphics.Color.argb
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : Activity() {

    lateinit var myImageView : ImageView
    lateinit var myBlankBitmap: Bitmap
    lateinit var nobitaBitmap: Bitmap
    lateinit var myCanvas: Canvas
    lateinit var myPaint: Paint

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val widthInPixels = 2000
        val heightInPixels = 1000

        myBlankBitmap = Bitmap.createBitmap(widthInPixels, heightInPixels,Bitmap.Config.ARGB_8888)

        nobitaBitmap = BitmapFactory.decodeResource(resources, R.drawable.nobita)

        myCanvas = Canvas(myBlankBitmap)

        myImageView = ImageView(this)
        myPaint = Paint()

        myCanvas.drawColor(argb(255 , 0 , 0, 255))

        drawRotatedBitmap()
        drawEnlargedBitmap()
        drawShrunkenBitmap()

        myImageView.setImageBitmap(myBlankBitmap)
        setContentView(myImageView)

    }

    fun drawRotatedBitmap(){

        var rotation = 0f
        var horizontalPosition = 350
        var verticalPosition = 25
        val matrix = Matrix()

        var rotatedBitmap : Bitmap

        rotation = 0f
        while(rotation < 360){

            matrix.reset()
            matrix.preRotate(rotation)
            rotatedBitmap = Bitmap
                    .createBitmap(nobitaBitmap,0,0,nobitaBitmap.width-1,nobitaBitmap.height-1,matrix , true)

            myCanvas.drawBitmap(
                    rotatedBitmap,
                    horizontalPosition.toFloat(),
                    verticalPosition.toFloat(),
                    myPaint
            )
            horizontalPosition+=120
            verticalPosition += 70
            rotation += 30f
        }
    }

    fun drawEnlargedBitmap(){

        nobitaBitmap = Bitmap
                .createScaledBitmap(nobitaBitmap,
                        300, 400, false)
        myCanvas.drawBitmap(nobitaBitmap, 25f , 25f, myPaint)
    }

    fun drawShrunkenBitmap(){

        nobitaBitmap = Bitmap
                .createScaledBitmap(nobitaBitmap,
                        50,75,false)
        myCanvas.drawBitmap(nobitaBitmap, 250f, 25f, myPaint)
    }
}
