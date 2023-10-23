package edu.temple.desserrtapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectionActivity : AppCompatActivity() {

    /**
     * Companion objects are used in Kotlin
     * as containers of public static fields
     */
    companion object {
        val ITEM_KEY = "key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set the title for the activity.
        supportActionBar?.title = getString(R.string.selector_title)
        // This is done to ensure that the activity label
        // displayed in the Android launcher is different
        //supportActionBar?.title = "Selector"
        val items = generateTestData()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)


        recyclerView.layoutManager = GridLayoutManager(this, 3)

        val clickEvent = {item: Item ->
            // Item object can be placed directly inside Intent because
            // the Item class implements the Parcelable interface
            val launchIntent = Intent(this, DisplayActivity::class.java)
                .putExtra(ITEM_KEY, item)

            startActivity(launchIntent)
        }

        recyclerView.adapter = ImageAdapter(items, clickEvent)
    }

    /**
     * Generate test info for app
     */
    fun generateTestData(): Array<Item> {
        return arrayOf(

            Item(R.drawable.ccf_original, getString(R.string.item_original)),
            Item(R.drawable.ccf_freshstrawberry, getString(R.string.item_strawberry_original)),
            Item(R.drawable.ccf_chocolatecaramelicious, getString(R.string.item_chocolate_caramelicious)),
            Item(R.drawable.ccf_pineappleupsidedown, getString(R.string.item_pineapple_upside_down)),
            Item(R.drawable.ccf_celebration, getString(R.string.item_celebration)),
            Item(R.drawable.ccf_caramelapple, getString(R.string.item_caramel_apple)),
            Item(
                R.drawable.ccf_verycherryghirardellichocolate,
                getString(R.string.item_very_cherry_ghirardelli_chocolate)
            ),
            Item(R.drawable.ccf_lowlicious, getString(R.string.item_lowlicious)),
            Item(R.drawable.ccf_cinnaboncinnamoncwirl, getString(R.string.item_cinnabon_cinnamon_swirl)),
            Item(R.drawable.ccf_godiva, getString(R.string.item_godiva_chocolate)),
            Item(R.drawable.ccf_coconutcreampie, getString(R.string.item_coconut_cream_pie)),
            Item(R.drawable.ccf_saltedcaramel, getString(R.string.item_salted_caramel))
        )
    }
}