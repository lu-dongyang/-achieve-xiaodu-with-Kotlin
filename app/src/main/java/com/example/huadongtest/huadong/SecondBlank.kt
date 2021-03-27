package com.example.huadongtest.huadong

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.huadongtest.Database.database
import com.example.huadongtest.Database.databaseHelper
import com.example.huadongtest.R
import kotlinx.android.synthetic.main.fragment_first_blank.*


import kotlinx.android.synthetic.main.fragment_second_blank.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondBlank.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondBlank : Fragment() {


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_blank, container, false)
        //调用跳转函数
        //调用跳转函数
//        setPersonal(root)
//
//        return root

//        return inflater.inflate(R.layout.fragment_second_blank, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val btn_submit = activity!!.findViewById<View>(R.id.juzi) as Button

        btn_submit.setOnClickListener {
            val intent = Intent()
            //getActivity() 用来获取当前Activity
            intent.setClass(activity!!, database::class.java)
            startActivity(intent)
        }
    }
//    fun setPersonal(view: View) {
//
////        music_button = view.findViewById<View>(R.id.music_button)
//        music_button.setOnClickListener(View.OnClickListener {
//            val intent = Intent()
//            //getActivity() 用来获取当前Activity
//            intent.setClass(activity!!, database::class.java)
//            startActivity(intent)
//        })
//    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondBlank.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondBlank().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}