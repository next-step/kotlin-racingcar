package racingcar.view

fun inputCarNames(): List<String> {
    return try {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.")
        val carNames = readLine()
        if (carNames.isNullOrBlank()) {
            throw IllegalArgumentException("[ERROR] 차량의 갯수에는 공백이나 null 입력이 불가능합니다.")
        }

        carNames.split(",").map { it.trim() }
    } catch (e: IllegalArgumentException) {
        println(e.message)
        inputCarNames()
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
