package com.dam.migestor.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dam.migestor.R
import com.dam.migestor.ui.onboarding.screens.FirstScreen
import com.dam.migestor.ui.onboarding.screens.SecondScreen
import com.dam.migestor.ui.onboarding.screens.ThirdScreen
import kotlinx.android.synthetic.main.fragment_view_pager.view.*

/*Fuentes:  Presentación de la app a usuarios que acceden por primera vez. OnBoarding.
            https://developer.android.com/training/tv/playback/onboarding?hl=es
            https://www.youtube.com/watch?v=COZ3j8Dwlog&list=WL&index=2

*/

class ViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)
//lista de Fragments que controlamos con el componente 'Navigation'
        val fragmentList = arrayListOf<Fragment>(
                FirstScreen(),
                SecondScreen(),
                ThirdScreen()
        )

        val adapter = ViewPagerAdapter(
                fragmentList, requireActivity().supportFragmentManager,
                lifecycle
        )
        view.viewPager.adapter = adapter

        return view
    }
}