package racingcar.view

fun inputCarNumber(): Int {
    return try {
        println("자동차 대수는 몇 대인가요?")
        val carNumber = readLine()
        if (carNumber.isNullOrBlank()) {
            throw IllegalArgumentException("[ERROR] 차량의 갯수에는 공백이나 null 입력이 불가능합니다.")
        }

        carNumber.toInt()
    } catch (e: IllegalArgumentException) {
        println(e.message)
        inputCarNumber()
    }
}

fun inputTryNumber(): Int {
    return try {
        println("시도할 횟수는 몇 회인가요?")
        val tryNumber = readLine()
        if (tryNumber.isNullOrBlank()) {
            throw IllegalArgumentException("[ERROR] 시도 횟수는 공백이나 null 입력이 불가능합니다.")
        }

        tryNumber.toInt()
    } catch (e: IllegalArgumentException) {
        println(e.message)
        inputTryNumber()
    }
}
