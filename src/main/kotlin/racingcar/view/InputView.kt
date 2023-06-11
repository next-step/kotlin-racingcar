package racingcar.view

private const val NAME_DELIMITER = ","

fun inputCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    return readln().trim()
        .split(NAME_DELIMITER)
}

fun inputAttemptCount(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return runCatching { readln().toInt() }
        .getOrElse { retryInputRaceCount() }
}

private fun retryInputRaceCount(): Int {
    println("시도할 횟수는 숫자만 입력가능합니다. 다시 입력해주세요.")
    return inputAttemptCount()
}
