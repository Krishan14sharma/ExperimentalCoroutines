package experimental.com.experimental

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : Activity() {

    private lateinit var job: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        job = GlobalScope.launch(Dispatchers.Main) {
            count100()
        }
    }

    private suspend fun count100() {
        for (i in 1..100) {
            delay(1000)
            textView.text = "$i"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}
