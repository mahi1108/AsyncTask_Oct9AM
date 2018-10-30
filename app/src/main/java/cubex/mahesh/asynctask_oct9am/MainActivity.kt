package cubex.mahesh.asynctask_oct9am

import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.InputStream
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getImage.setOnClickListener {
                    var task = MyTask(iview)
                    task.execute( )
        }

        var policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
    } //  onCreate( )

    class MyTask(var iview:ImageView) : AsyncTask<Unit,Unit,Unit>( )
    {
        var isr:InputStream? = null
        override fun doInBackground(vararg p0: Unit?) {
            var u = URL("https://i1.wp.com/techlog360.com/wp-content/uploads/2018/02/Best-Android-Hacking-Apps-And-Tools.jpeg?fit=900%2C500&ssl=1")
             isr = u.openStream()
        }

        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)
            var bmp = BitmapFactory.decodeStream(isr)
            iview.setImageBitmap(bmp)
        }

    }



}  //MainActivity
