package racing

fun inputCarName(): List<String> {
    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    return getParsingCarName()
}

fun inputTryCount(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return getInputValue()
}

fun getParsingCarName(): List<String> {
    val value = readLine()
    require(!value.isNullOrBlank()) { "입력값을 반드시 입력해야합니다." }

    val names = value.split(CAR_NAME_DELIMITER)
    names.forEach {
        require(it.length <= CAR_NAME_LENGTH_LIMIT)
    }

    return names
}

fun getInputValue(): Int {
    val value = readLine()
    require(value != null) { "입력값을 반드시 입력해야합니다." }

    try {
        val intValue = value.toInt()

        require(mustBiggerThanZero(intValue)) { "입력값은 0보다 큰 자연수이어야 합니다." }

        return intValue
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("자연수를 입력해주세요.")
    }
}

fun mustBiggerThanZero(value: Int): Boolean {
    return value > 0
}

const val CAR_NAME_LENGTH_LIMIT = 5
const val CAR_NAME_DELIMITER = ","
