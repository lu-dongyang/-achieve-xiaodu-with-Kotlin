package com.example.huadongtest.huadong

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.huadongtest.R
import kotlinx.android.synthetic.main.fragment_first_blank.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstBlank.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstBlank : Fragment() {
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
        return inflater.inflate(R.layout.fragment_first_blank, container, false)
//        val root: View = inflater.inflate(R.layout.fragment_first_blank, container, false)
//        //调用跳转函数
//        //调用跳转函数
////        setPersonal(root)
//
//        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val btn_submit = activity!!.findViewById<View>(R.id.music_button) as Button

        btn_submit.setOnClickListener {
            val intent = Intent()
            //getActivity() 用来获取当前Activity
            intent.setClass(activity!!, music::class.java)
            startActivity(intent)
        }
    }


    /*实现从fragment跳转到Activity*/
//    fun setPersonal(view: Int) {
//
////        music_button = view.findViewById<View>(R.id.music_button)
//       music_button.setOnClickListener {
//            val intent = Intent()
//            //getActivity() 用来获取当前Activity
//            intent.setClass(activity!!, music::class.java)
//            startActivity(intent)
//        }
//    }




    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstBlank.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstBlank().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}