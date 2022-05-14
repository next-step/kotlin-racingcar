package racing

fun main() {
    println("자동차 대수는 몇 대인가요?")
    val carNumber = readLine()!!.toInt()
    println("시도할 횟수는 몇 회인가요?")
    val tryRound = readLine()!!.toInt()

    RacingView.result(tryRound, Racing.start(carNumber, tryRound))
}
