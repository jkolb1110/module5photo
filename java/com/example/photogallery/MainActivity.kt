package com.example.photogallery

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerView2: RecyclerView
    private lateinit var drawableAdapter: DrawableAdapter
    private lateinit var photoAdapter: PhotoAdapter
    private var counter = 0

    private val ids = arrayOf(
        R.drawable.pic1,
        R.drawable.pic2,
        R.drawable.pic3,
        R.drawable.pic4,
        R.drawable.pic5,
        R.drawable.pic6,
        R.drawable.pic7,
        R.drawable.pic8,
        R.drawable.pic9
    )


    private val imageUrls = listOf(
        "https://photos.fife.usercontent.google.com/pw/AP1GczOE_m7CsSQpEdKCOzpia_3eyR6HmxW1b1Df_O5tbIs7aXotHZtduQAc=w538-h956-s-no-gm?authuser=0",
        "https://photos.fife.usercontent.google.com/pw/AP1GczOE_m7CsSQpEdKCOzpia_3eyR6HmxW1b1Df_O5tbIs7aXotHZtduQAc=w538-h956-s-no-gm?authuser=0",
        "https://photos.fife.usercontent.google.com/pw/AP1GczOE_m7CsSQpEdKCOzpia_3eyR6HmxW1b1Df_O5tbIs7aXotHZtduQAc=w538-h956-s-no-gm?authuser=0"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        textView = findViewById(R.id.textView)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView2 = findViewById(R.id.recyclerView2)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnGrid = findViewById<Button>(R.id.button_grid)

        imageView.setImageResource(ids[0])
        textView.text = "1 / ${ids.size}"

        btnNext.setOnClickListener {
            counter++
            if (counter >= ids.size) {
                counter = 0
            }
            imageView.setImageResource(ids[counter])
            textView.text = "${counter + 1} / ${ids.size}"
        }

        btnBack.setOnClickListener {
            counter--
            if (counter < 0) {
                counter = ids.size - 1
            }
            imageView.setImageResource(ids[counter])
            textView.text = "${counter + 1} / ${ids.size}"
        }

        btnGrid.setOnClickListener {
            showGrid()
        }

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        drawableAdapter = DrawableAdapter(ids.toList())
        recyclerView.adapter = drawableAdapter
        recyclerView.visibility = View.GONE

        recyclerView2.layoutManager = GridLayoutManager(this, 2)
        photoAdapter = PhotoAdapter(imageUrls)
        recyclerView2.adapter = photoAdapter
        recyclerView2.visibility = View.GONE
    }

    private fun showGrid() {
        imageView.visibility = View.GONE
        textView.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
        recyclerView2.visibility = View.VISIBLE
    }
}
