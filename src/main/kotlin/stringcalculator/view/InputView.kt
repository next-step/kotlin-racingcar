package stringcalculator.view

fun getSplitStringForCalculate() = readLine()?.split(" ")
    ?: throw IllegalArgumentException("읽은 문자열은 null 일 수 없음.")
