package racingcar.view

fun inputCarNumber(): Int {
    return try {
        val carNumber = readLine()
        if (carNumber.isNullOrBlank()) {
            throw IllegalArgumentException("차량의 갯수에는 공백이나 null 입력이 불가능합니다.")
        }

        carNumber.toInt()
    } catch (e: IllegalArgumentException) {
        println(e.message)
        inputCarNumber()
    }
}
