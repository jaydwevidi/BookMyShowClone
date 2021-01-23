package com.example.bookmyshowclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_page.*

class page : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }

    fun dummyButtonClicked(view: View){
        Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page)



        var city_selected = intent.getStringExtra("cityName")
        supportActionBar?.title = city_selected

        Toast.makeText(this, "city is $city_selected", Toast.LENGTH_SHORT).show()

        setSupportActionBar(myToolbar)
        supportActionBar?.title = city_selected
        //<style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
        //past this in styles file

        setupImageSlider()
        setupNavViewDrawer()
    }

    fun addItemsToList(list : MutableList<SliderItem>){
        list.add(SliderItem("http://www.justinmaller.com/img/projects/wallpaper/WP_Cracked_Clown-2560x1440_00000.jpg", "", 3214))
        list.add(SliderItem("http://www.justinmaller.com/img/projects/wallpaper/WP_Jaeger-2560x1440_00000.jpg", "", 3214))
        list.add(SliderItem("http://www.justinmaller.com/img/projects/wallpaper/WP_Lightning_Legend-2560x1440_00000.jpg", "", 3214))
        list.add(SliderItem("http://www.justinmaller.com/img/projects/wallpaper/WP_Gothams_Champion-2560x1440_00000.jpg", "", 3214))
    }

    fun setupNavViewDrawer(){

        var toggle = ActionBarDrawerToggle(this , drawerLayout , R.string.app_name , R.string.app_name )
        this.toggle = toggle
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> Toast.makeText(applicationContext, "asdf", Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(applicationContext , "452353" , Toast.LENGTH_LONG).show()
            }
            true
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupImageSlider(){
        var list = mutableListOf<SliderItem>()
        addItemsToList(list)

        val x = MySliderAdapter(applicationContext,list)
        imageSlider.setSliderAdapter(x)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        else
            super.onBackPressed()
    }
}