package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?):Pair<String?,String?>{
        val parts : List<String>? = fullName?.split(" ")
        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)

        if(firstName==null || firstName.isEmpty()) firstName = null
        if(lastName==null || lastName.isEmpty()) lastName = null

        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "):String{
        return "";
    }

    fun toInitials(firstNams:String?, lastNams:String?):String{
        return "";
    }
}