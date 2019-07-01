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
        val mapTransliteration = createMapTranslitertion()

        val resultTransliteration = StringBuilder()

        for(char in payload){
//            val isUpperCase = char.isUpperCase();
            resultTransliteration.append(mapTransliteration[char].orEmpty().ifEmpty { char })
        }

        return resultTransliteration.toString().replace(" ",divider)
    }

    private fun createMapTranslitertion(): HashMap<Char,String>{
        val mapTransliteration = HashMap<Char, String>()
        mapTransliteration['а'] = "a"
        mapTransliteration['б'] = "b"
        mapTransliteration['в'] = "v"
        mapTransliteration['г'] = "g"
        mapTransliteration['д'] = "d"
        mapTransliteration['е'] = "e"
        mapTransliteration['ё'] = "e"
        mapTransliteration['ж'] = "zh"
        mapTransliteration['з'] = "z"
        mapTransliteration['и'] = "i"
        mapTransliteration['й'] = "i"
        mapTransliteration['к'] = "k"
        mapTransliteration['л'] = "l"
        mapTransliteration['м'] = "m"
        mapTransliteration['н'] = "n"
        mapTransliteration['о'] = "o"
        mapTransliteration['п'] = "p"
        mapTransliteration['р'] = "r"
        mapTransliteration['с'] = "s"
        mapTransliteration['т'] = "t"
        mapTransliteration['у'] = "u"
        mapTransliteration['ф'] = "f"
        mapTransliteration['х'] = "h"
        mapTransliteration['ц'] = "c"
        mapTransliteration['ч'] = "ch"
        mapTransliteration['ш'] = "sh"
        mapTransliteration['щ'] = "sh'"
        mapTransliteration['ъ'] = ""
        mapTransliteration['ы'] = "i"
        mapTransliteration['ь'] = ""
        mapTransliteration['э'] = "e"
        mapTransliteration['ю'] = "yu"
        mapTransliteration['я'] = "ya"

        mapTransliteration['А'] = "A"
        mapTransliteration['Б'] = "B"
        mapTransliteration['В'] = "V"
        mapTransliteration['Г'] = "G"
        mapTransliteration['Д'] = "D"
        mapTransliteration['Е'] = "E"
        mapTransliteration['Ё'] = "E"
        mapTransliteration['Ж'] = "Zh"
        mapTransliteration['З'] = "Z"
        mapTransliteration['И'] = "I"
        mapTransliteration['Й'] = "I"
        mapTransliteration['К'] = "K"
        mapTransliteration['Л'] = "L"
        mapTransliteration['М'] = "M"
        mapTransliteration['Н'] = "N"
        mapTransliteration['О'] = "O"
        mapTransliteration['П'] = "P"
        mapTransliteration['Р'] = "R"
        mapTransliteration['С'] = "S"
        mapTransliteration['Т'] = "T"
        mapTransliteration['У'] = "U"
        mapTransliteration['Ф'] = "F"
        mapTransliteration['Х'] = "H"
        mapTransliteration['Ц'] = "C"
        mapTransliteration['Ч'] = "Ch"
        mapTransliteration['Ш'] = "Sh"
        mapTransliteration['Щ'] = "Sh'"
        mapTransliteration['Ъ'] = ""
        mapTransliteration['Ы'] = "I"
        mapTransliteration['Ь'] = ""
        mapTransliteration['Э'] = "E"
        mapTransliteration['Ю'] = "Yu"
        mapTransliteration['Я'] = "Ya"

        return mapTransliteration
    }

    fun toInitials(firstName:String?, lastName:String?):String?{
        val initialFirstName = firstName?.trim()?.getOrNull(0)?.toUpperCase()
        val initialLastName = lastName?.trim()?.getOrNull(0)?.toUpperCase()


        return "${if(initialFirstName==null) "" else initialFirstName}${if(initialLastName==null) "" else initialLastName}".ifEmpty { null }
    }
}