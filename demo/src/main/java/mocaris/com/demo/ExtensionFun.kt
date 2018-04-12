package mocaris.com.demo

import android.widget.ImageView
import com.bumptech.glide.Glide


fun ImageView.disPlayByUrl(url: String) {
    Glide.with(context.applicationContext).load(url).into(this)
}
