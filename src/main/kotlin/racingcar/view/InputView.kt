package racingcar.view

fun inputCarCount(): Int {
    println("자동차 대수는 몇 대인가요?")
    return runCatching { readlnOrNull()!!.toInt() }
        .getOrElse { retryInputCarCount() }
}

fun inputRaceCount(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return runCatching { readlnOrNull()!!.toInt() }
        .getOrElse { retryInputRaceCount() }
}

private fun retryInputCarCount(): Int {
    println("자동차 대수를 잘못 입력했습니다. 다시 입력해주세요.")
    return inputCarCount()
}

fun retryInputRaceCount(): Int {
    println("시도할 횟수를 잘못 입력했습니다. 다시 입력해주세요.")
    return inputRaceCount()
}
