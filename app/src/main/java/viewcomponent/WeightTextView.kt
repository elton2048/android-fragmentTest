package viewcomponent

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.view.ViewManager
import android.widget.LinearLayout
import android.widget.TextView
import com.example.elton.fragmenttest.R
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.dip
import org.jetbrains.anko.textColor

/**
 * Created by elton on 25/5/2017.
 */

class WeightTextView(context: Context) : TextView(context) {
    var normalDrawable: Drawable? = null
    var selectedDrawable: Drawable? = null

    init {
        var layoutParams = LinearLayout.LayoutParams(dip(50),
                LinearLayout.LayoutParams.MATCH_PARENT, 1f)
        layoutParams.weight = 1f
        this.layoutParams = layoutParams
    }

    override fun setSelected(selected: Boolean) {
        super.setSelected(selected)

        if (selected) {
            this.backgroundColor = ContextCompat.getColor(context, R.color.colorAccent)
            this.textColor = ContextCompat.getColor(context, R.color.colorPrimary)

            if (selectedDrawable != null) {
                this.setCompoundDrawablesWithIntrinsicBounds(null, selectedDrawable, null, null)
            }
        } else {
            this.backgroundColor = ContextCompat.getColor(context, android.R.color.transparent)
            this.textColor = ContextCompat.getColor(context, R.color.colorPrimaryDark)
            if (normalDrawable != null) {
                this.setCompoundDrawablesWithIntrinsicBounds(null, normalDrawable, null, null)
            }
        }
    }

}
public inline fun ViewManager.weightTextView() = weightTextView {}
public inline fun ViewManager.weightTextView(init: WeightTextView.() -> Unit) = ankoView({ WeightTextView(it) }, 0, init)