package com.example.threads

import android.os.AsyncTask
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private lateinit var startButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.result_text_view)
        startButton = findViewById(R.id.start_button)

        startButton.setOnClickListener {

            BackgroundTask().execute()

        }
    }
    // BackgroundTask inner class to perform the background task
    private inner class BackgroundTask : AsyncTask<Void?, Void?, String>() {
        override fun onPostExecute(result: String?) {
            //Update the UI
            resultTextView.text = result
        }

        override fun doInBackground(vararg p0: Void?): String {
            // Perform background task
            try {
                Thread.sleep(3000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            return "TASK COMPLETED"
        }
    }
}
