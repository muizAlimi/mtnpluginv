package com.fbn.mtoplugin.util

import org.springframework.stereotype.Service
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

@Service
class DateUtil {

    fun getCal(dat : String) : Calendar{
        val df: DateFormat = SimpleDateFormat("dd/MM/yyyy")
        val cal = Calendar.getInstance()
        cal.time = df.parse(dat)
        return cal;
    }

    fun getHtmlCal(dat : String) : Calendar{
        val df: DateFormat = SimpleDateFormat("yyyy-MM-dd")
        val cal = Calendar.getInstance()
        cal.time = df.parse(dat)
        return cal;
    }


    fun getToday() : Calendar{
        val cal = Calendar.getInstance()
        return cal;
    }
}