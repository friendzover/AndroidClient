package com.hazewritescode.friendzover.activities
import android.net.Uri
import com.hazewritescode.friendzover.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import com.nshmura.recyclertablayout.RecyclerTabLayout
import com.hazewritescode.friendzover.adapters.RegistrationPagerAdapter
import com.hazewritescode.friendzover.fragments.registration_first
import com.hazewritescode.friendzover.fragments.registration_second


class RegistrationActivity : AppCompatActivity(), registration_first.OnFragmentInteractionListener, registration_second.OnSecondFragmentInteractionListener {

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSecondFragmentInteraction(firstName: String, secondName: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        val manager = supportFragmentManager
        val mainPager: ViewPager = findViewById(R.id.registrationViewPager)
        val recyclerTabLayout = findViewById<RecyclerTabLayout>(R.id.tabLayout)

        mainPager.adapter = RegistrationPagerAdapter(manager, listOf(registration_first(),
            registration_second()
        ))
        recyclerTabLayout.setUpWithViewPager(mainPager)


        val finishButton = findViewById<Button>(R.id.submitButton)

        finishButton.setOnClickListener {

        }

    }
}
