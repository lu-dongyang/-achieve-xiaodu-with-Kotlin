package com.example.huadongtest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.huadongtest.huadong.PageAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager2.adapter = PageAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager2)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //  return super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //return super.onOptionsItemSelected(item)
        //跳转页面(隐式） 登录
        when(item.itemId){
            R.id.add_item -> {val intent = Intent("com.example.huadongtest.ACTION_START")
                startActivity(intent)
                }//Toast.makeText(this,"you click add",Toast.LENGTH_SHORT).show()
            // 跳转页面 简介
            R.id.remove_item -> {val intent = Intent("com.example.huadongtest.JIANJIE_START")

                startActivity(intent)
                }  //Toast.makeText(this,"you click remove",Toast.LENGTH_SHORT).show()

            R.id.contacts ->{ val intent = Intent(this,Contacts::class.java)
                startActivity(intent)
            }
        }
        return true
    }


}