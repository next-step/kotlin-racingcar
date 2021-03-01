package racinggame.ui

fun inputCarAmount(): Int {
    println("자동차 대수는 몇 대인가요?")
    return readLine()!!.convertInt()
}

fun inputTrialAmount(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return readLine()!!.convertInt()
}

private fun String.convertInt(): Int = with(this) {
    try {
        toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("숫자를 입력해 주세요.")
    }
}
