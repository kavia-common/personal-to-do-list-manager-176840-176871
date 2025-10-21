package org.example.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.example.app.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.root, TodoFragment())
                .commit()
        }
    }
}
