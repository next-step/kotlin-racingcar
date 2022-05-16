package step3.racing

fun main() {
    println("자동차 대수는 몇 대인가요?")
    val racerCount = InputView.getLong(readLine())
    println("시도할 횟수는 몇 회인가요?")
    val racingTime = InputView.getLong(readLine())
    val racingTrack = RacingTrack(racerCount, racingTime)
    racingTrack.start()
}
