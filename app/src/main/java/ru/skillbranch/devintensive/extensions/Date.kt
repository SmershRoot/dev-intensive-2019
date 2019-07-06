package ru.skillbranch.devintensive.extensions

import java.lang.Math.abs
import java.text.SimpleDateFormat
import java.util.*

const val SECONDS = 1000L
const val MINUTE = 60 * SECONDS
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"):String{
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND):Date{
    var time = this.time

    time += when(units){
        TimeUnits.SECOND -> value * SECONDS
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }

    this.time = time

    return this
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY;

    fun plural(value: Int):String{
        return formTimeOfType(this, value)
    }



}

fun Date.humanizeDiff(date:Date = Date()):String{
    val difference = this.time - date.time

    return when {
        (abs(difference)/SECONDS.toDouble()<=1) -> "только что"
        (difference/SECONDS.toDouble()<=45 && difference/SECONDS.toDouble()>1) -> "через несколько секунд"
        (difference/SECONDS.toDouble()>=-45 && difference/SECONDS.toDouble()<-1) -> "несколько секунд назад"
        (difference/SECONDS.toDouble()<=75 && difference/SECONDS.toDouble()>45) -> "через минуту"
        (difference/SECONDS.toDouble()>=-75 && difference/SECONDS.toDouble()<-45) -> "минуту назад"
        (difference/MINUTE.toDouble()<=45 && difference/SECONDS.toDouble()>75) -> "через ${Math.round(abs(difference/MINUTE.toDouble()))} ${formMinute((difference/MINUTE.toDouble()).toInt())}"
        (difference/MINUTE.toDouble()>=-45 && difference/SECONDS.toDouble()<-75) -> "${Math.round(abs(difference/MINUTE.toDouble()))} ${formMinute((difference/MINUTE.toDouble()).toInt())} назад"

        (difference/MINUTE.toDouble()<=75 && difference/MINUTE.toDouble()>45) -> "через час"
        (difference/MINUTE.toDouble()>=-75 && difference/MINUTE.toDouble()<-45) -> "час назад"

        (difference/HOUR.toDouble()<=22 && difference/MINUTE.toDouble()>75) -> "через ${Math.round(abs(difference/HOUR.toDouble()))} ${formHour((difference/HOUR.toDouble()).toInt())}"
        (difference/HOUR.toDouble()>=-22 && difference/MINUTE.toDouble()<-75) -> "${Math.round(abs(difference/HOUR.toDouble()))} ${formHour((difference/HOUR.toDouble()).toInt())} назад"

        (difference/HOUR.toDouble()<=26 && difference/HOUR.toDouble()>22) -> "через день"
        (difference/HOUR.toDouble()>=-26 && difference/HOUR.toDouble()<-22) -> "день назад"

        (difference/DAY.toDouble()<=360 && difference/HOUR.toDouble()>26) -> "через ${Math.round(abs(difference/DAY.toDouble()))} ${formDay((difference/DAY.toDouble()).toInt())}"
        (difference/DAY.toDouble()>=-360 && difference/HOUR.toDouble()<-26) -> "${Math.round(abs(difference/DAY.toDouble()))} ${formDay((difference/DAY.toDouble()).toInt())} назад"

        (difference/DAY.toDouble()>360) -> "более чем через год"
        (difference/DAY.toDouble()<-360) -> "более года назад"


        else -> "Не удалось определить"
    }
}


private fun formTimeOfType (typeTime: TimeUnits, value: Int):String{
    return when(typeTime) {
        TimeUnits.SECOND -> "$value ${formSecond(value)}"
        TimeUnits.MINUTE -> "$value ${formMinute(value)}"
        TimeUnits.HOUR -> "$value ${formHour(value)}"
        TimeUnits.DAY -> "$value ${formDay(value)}"
    }

}

private fun formSecond(countSecond:Int):String{
    when(abs(countSecond)) {
        11,12,13,14 -> return "секунд"
    }

    when(abs(countSecond%10)){
        1 -> return "секунду"
        2,3,4 -> return "секунды"
        0,5,6,7,8,9 -> return "секунд"
    }
    return formMinute(countSecond%10)
}

private fun formMinute(countMinute:Int):String{
    when(abs(countMinute)) {
        11,12,13,14 -> return "минут"
    }

    when(abs(countMinute%10)){
        1 -> return "минуту"
        2,3,4 -> return "минуты"
        0,5,6,7,8,9 -> return "минут"
    }
    return formMinute(countMinute%10)
}

private fun formHour(countHour:Int):String{
    when(abs(countHour)) {
        11,12,13,14 -> return "часов"
    }

    when(abs(countHour%10)){
        1 -> return "час"
        2,3,4 -> return "часа"
        0,5,6,7,8,9 -> return "часов"
    }
    return formHour(countHour%10)
}

private fun formDay(countDay:Int):String{
    when(abs(countDay)) {
        11,12,13,14 -> return "дней"
    }

    when(abs(countDay%10)){
        1 -> return "день"
        2,3,4 -> return "дня"
        0,5,6,7,8,9 -> return "дней"
    }
    return formDay(countDay%10)
}