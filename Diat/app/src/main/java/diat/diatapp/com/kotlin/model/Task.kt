package diat.diatapp.com.kotlin.model

import java.util.*

/**
 * Created by Eric on 2/8/2019.
 */

class Task(val title: String, val desc: String, val duration: Int?, val datesCompleted: List<Date>, val totalDaysCompleted: Int, val dayInterval: Int?) {

//    constructor(parcel: Parcel?) {
//        parcel.read
//    }
//
//    override fun describeContents(): Int {
//
//    }
//
//    override fun writeToParcel(p0: Parcel?, p1: Int) {
//
//    }
//
//    companion object CREATOR : Parcelable.Creator<Task> {
//        override fun createFromParcel(parcel: Parcel?): Task {
//            return Task(parcel)
//        }
//
//        override fun newArray(size: Int): Array<Task?> {
//            return arrayOfNulls(size)
//        }
//    }
}