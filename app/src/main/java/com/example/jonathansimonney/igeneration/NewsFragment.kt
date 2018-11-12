package com.example.jonathansimonney.igeneration

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_news.*
import java.time.LocalDate
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val stringResource = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [NewsFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [NewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class NewsFragment : Fragment() {
    // TODO: Rename and change types of parameters
//    private var stringResource: String? = null

    private lateinit var news: List<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.news = createFakeNews(20)
        arguments?.let {
//            stringResource = it.getString(stringResource)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun createFakeNews(howMany :Int): List<News>{
        val titles = arrayListOf<String>("les français favorables à l'immigration",
                "l'écart de saliare homme femme expliqué uniquement par les discriminations sexistes",
                "la justice complètement impartiale dans ses poursuites d'hommes politiques")

        val authors = arrayListOf<String>("Anthony", "Florent", "Chloé", "Cécile", "Antoine", "Jonathan", "Nathaël")
        val dates = arrayListOf<LocalDate>(LocalDate.of( 1985 , 1 , 1 ),
                LocalDate.of( 1885 , 5 , 1 ),
                LocalDate.of( 2015 , 1 , 13 ))

        val ret = ArrayList<News>()
        val randomizer = Random()
        for (i in 1..howMany){
            ret.add(
                    News(titles[randomizer.nextInt(titles.size)], authors[randomizer.nextInt(authors.size)], dates[randomizer.nextInt(dates.size)])
            )
        }

        return ret
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NewsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
                NewsFragment().apply {
                    arguments = Bundle().apply {
//                        putString(stringResource, param1)
                    }
                }
    }
}
