package ru.skillbranch.devintensive.extensions

fun String.truncate(length:Int=16):String{
    val valueString = this.trim()

    return if (valueString.length>length)
        valueString.substring(0,length).trim()+"..."
    else
        valueString
}

fun String.stripHtml(): String{
    //\\<.*?>
    return this
        .replace(Regex("<.*?>"), "")
        .replace(Regex("[\\s]{2,}"), " ")

}