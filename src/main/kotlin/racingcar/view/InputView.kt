package racingcar.view

fun inputCarCount(): Int {
    println("자동차 대수는 몇 대인가요?")
    return runCatching { readlnOrNull()!!.toInt() }
        .getOrElse { retryInputCarCount() }
}

fun inputAttemptCount(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return runCatching { readlnOrNull()!!.toInt() }
        .getOrElse { retryInputRaceCount() }
}

private fun retryInputCarCount(): Int {
    println("자동차 대수는 숫자만 입력가능합니다. 다시 입력해주세요.")
    return inputCarCount()
}

fun retryInputRaceCount(): Int {
    println("시도할 횟수는 숫자만 입력가능합니다. 다시 입력해주세요.")
    return inputAttemptCount()
}
