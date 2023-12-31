package edu.temple.desserrtapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        // Set the title for the activity.
        //supportActionBar?.title = getString(R.string.app_name)
        // This can also be done in the manifest
        supportActionBar?.title = "Display-er"
        val imageView = findViewById<ImageView>(R.id.imageView)
        val textView = findViewById<TextView>(R.id.textView)

        findViewById<Button>(R.id.closeButton).setOnClickListener { finish() }

        // Fetch the intent used to launch this activity
        val item = intent.getParcelableExtra(SelectionActivity.ITEM_KEY, Item::class.java)

        /**
         * Use Item object found in intent to set view values
         *
         * Using ?.let{} is equivalent to:
         *  if (item != null) {
         *      imageView.setImageResource(item.resourceId)
         *      textView.text = item.description
         *  }
         */

        item?.resourceId?.let { imageView.setImageResource(it) }
        item?.description?.let { textView.text = it }

    }
}