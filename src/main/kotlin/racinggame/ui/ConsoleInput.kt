package racinggame.ui

fun inputCarAmount(): String {
    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    return readLine() ?: throw IllegalArgumentException("null을 입력하였습니다.")
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
