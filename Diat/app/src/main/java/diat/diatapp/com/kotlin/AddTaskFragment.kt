package diat.diatapp.com.kotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_add_task.*

class AddTaskFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_add_task, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        name_input.requestFocus()

        submit_new_task_button.setOnClickListener {
            var intent = Intent()
            intent.putExtra("name", name_input.text.toString())
            intent.putExtra("days_completed_so_far", days_completed_input.text.toString().toInt())
            activity.setResult(Activity.RESULT_OK, intent)
            activity.finish()
        }
    }

    companion object {
        fun buildFragment(): Fragment {
            return AddTaskFragment()
        }
    }
}