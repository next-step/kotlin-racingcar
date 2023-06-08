package racingcar.view

fun inputCarCount(): Int {
    println("자동차 대수는 몇 대인가요?")
    return runCatching { readlnOrNull()!!.toInt() }
        .getOrElse { retryInputCarCount() }
}

private fun retryInputCarCount(): Int {
    println("자동차 대수를 잘못 입력했습니다. 다시 입력해주세요.")
    return inputCarCount()
}
