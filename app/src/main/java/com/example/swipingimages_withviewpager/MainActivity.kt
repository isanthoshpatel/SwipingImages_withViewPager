package com.example.swipingimages_withviewpager

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var list = listOf<Int>(
            R.drawable.cate_blanchett,
            R.drawable.dishaloveyou,
            R.drawable.dishapatani,
            R.drawable.dishaloveyou,
            R.drawable.emma_stone,
            R.drawable.gala_gadot,
            R.drawable.jennifer_lawrence,
            R.drawable.kate_winslet_hot_pics_20111
        )

        (list.indices).onEach {
            ImageView(this).also {
                it.scaleType = ImageView.ScaleType.CENTER_CROP
                it.setBackgroundResource(R.drawable.ic_radio_button_unchecked_black_24dp)
                linearLayout.addView(it)
            }
        }

        viewpager.adapter = object : PagerAdapter() {
            override fun getCount(): Int {
                return list.size
            }

            override fun isViewFromObject(view: View, `object`: Any): Boolean {
                return view == `object`
            }


            override fun instantiateItem(container: ViewGroup, position: Int): Any {
                var imageview = ImageView(this@MainActivity)
                imageview.scaleType = ImageView.ScaleType.CENTER_CROP
                imageview.setImageResource(list.get(position))
                container.addView(imageview)


                linearLayout.getChildAt(position)
                    .setBackgroundResource(R.drawable.ic_radio_button_checked_black_24dp)
                
                return imageview
            }

            override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
                container.removeView(`object` as ImageView)

                linearLayout.getChildAt(position)
                    .setBackgroundResource(R.drawable.ic_radio_button_unchecked_black_24dp)

            }

        }


    }
}
