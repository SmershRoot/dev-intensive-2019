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

    fun toInitials(firstName:String?, lastName:String?):String{
        var initialFirstName = firstName?.trim()?.getOrNull(0)?.toUpperCase()
        var initialLastName = lastName?.trim()?.getOrNull(0)?.toUpperCase()


        return "${if(initialFirstName==null) "" else initialFirstName}${if(initialLastName==null) "" else initialLastName}".ifEmpty { "null" }
    }
}