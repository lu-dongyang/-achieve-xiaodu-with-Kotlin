package com.example.huadongtest.huadong

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.huadongtest.huadong.FirstBlank
import com.example.huadongtest.huadong.SecondBlank
import com.example.huadongtest.huadong.ThirdBlank

class PageAdapter(fm:FragmentManager) :FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when(position){
            0->{return FirstBlank()
            }
            1->{return SecondBlank()
            }
            2->{return ThirdBlank()
            }
            3->{
                return FourthBlank()
            }

            else ->{return FirstBlank()
            }

        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0->{return "乐"}
            1->{return  "句"}
            2->{return  "文"}
            3->{return  "书"}
        }
        return super.getPageTitle(position)
    }

    override fun getCount(): Int {

        return 4
    }
}