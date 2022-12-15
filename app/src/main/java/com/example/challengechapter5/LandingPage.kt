package com.example.challengechapter5

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.challengechapter5.Helper.SliderAdapter
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator


class LandingPage : AppCompatActivity() {

    lateinit var viewPager: ViewPager
    lateinit var dot3: WormDotsIndicator
    lateinit var viewAdapter: SliderAdapter
    lateinit var ivChevron: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)
        supportActionBar?.hide()

        viewPager=findViewById(R.id.view_pager);
        dot3=findViewById(R.id.dot3);
        ivChevron=findViewById(R.id.iv_chevron)

        viewAdapter = SliderAdapter(this)
        viewPager.adapter = viewAdapter;
        viewPager.addOnPageChangeListener(changeListener)
        dot3.attachTo(viewPager);

        ivChevron.setOnClickListener(View.OnClickListener {
            viewPager.setCurrentItem(getItem(+1), true)
        })
    }

    fun login(view: View?) {
        val etName: EditText = findViewById(R.id.et_name)
        Log.d(TAG, "Edit Text Value : " + etName.text.toString())
        startActivity(Intent(this, MainActivity::class.java).putExtra("valName", etName.text.toString()))
        finish()
    }

    private fun getItem(i: Int): Int {
        if (viewPager.currentItem >= 1){
            ivChevron.visibility = View.INVISIBLE
        }
        return viewPager.currentItem + i
    }

    var changeListener: OnPageChangeListener = object : OnPageChangeListener {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
        }

        override fun onPageSelected(position: Int) {
            var currentPos = position
            if (position == 0) {
                ivChevron.visibility = View.VISIBLE
            } else if (position == 1) {
                ivChevron.visibility = View.VISIBLE
            } else if (position == 2) {
                ivChevron.visibility = View.INVISIBLE
            }
        }

        override fun onPageScrollStateChanged(state: Int) {}
    }
}