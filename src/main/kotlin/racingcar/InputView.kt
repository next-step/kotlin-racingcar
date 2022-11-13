package racingcar

data class InputView(
    val count: Int = readln("자동차 대수는 몇 대인가요?").toInt(),
    val number: Int = readln("시도할 횟수는 몇 회인가요?").toInt(),
)

private fun readln(message: String): String {
    println(message)
    return readln()
}
