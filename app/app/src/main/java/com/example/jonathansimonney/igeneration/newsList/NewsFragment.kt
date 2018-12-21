package com.example.jonathansimonney.igeneration.newsList

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jonathansimonney.igeneration.R
import kotlinx.android.synthetic.main.fragment_news.*


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
class NewsFragment : Fragment(), ListAdapter.OnNewsItemClickListener {
    // TODO: Rename and change types of parameters
//    private var stringResource: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
//            stringResource = it.getString(stringResource)
        }
    }


    private fun setRecyclerView(){
        val mRecyclerView = my_recycler_news_view
        mRecyclerView.setHasFixedSize(true)
        val mLayoutManager = LinearLayoutManager(context)
        mRecyclerView.layoutManager = mLayoutManager
        loadFakeNewsFromDb(mRecyclerView)
//        val mAdapter = ListAdapter(this.news)
//        mRecyclerView.adapter = mAdapter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setRecyclerView()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun loadFakeNewsFromDb(targetRecyclerView: RecyclerView){
        val vm = ViewModelProviders.of(this).get(NewsListViewModel::class.java)

        vm.getNews().observe(this, Observer<List<News>>{
            if (it != null){
                val mAdapter = ListAdapter(it, this)
                targetRecyclerView.adapter = mAdapter

                data_loading.visibility = View.GONE
            }else{
                data_loading.visibility = View.VISIBLE
            }
        })
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

    override fun onNewsClicked(news: News) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(news.link)
        startActivity(intent)
    }
}
