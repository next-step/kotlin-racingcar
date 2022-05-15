package racing

fun main() {
    try {
        println("자동차 대수는 몇 대인가요?")
        val carNumber = readln().toInt()
        println("시도할 횟수는 몇 회인가요?")
        val tryRound = readln().toInt()

        RacingView.result(tryRound, Racing.start(carNumber, tryRound))
    } catch (e: NumberFormatException) {
        println("숫자가 아닌 값이 들어왔습니다")
    }
}
