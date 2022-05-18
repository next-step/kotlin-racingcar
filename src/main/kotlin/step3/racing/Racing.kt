package step3.racing

private const val NAME_SEPARATOR = ", "
private const val NAME_MAX_LENGTH = 5
fun main() {
    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    val racerNames = InputView.getStringArray(readLine(), NAME_MAX_LENGTH)
    println("시도할 횟수는 몇 회인가요?")
    val racingTime = InputView.getInt(readLine())

    val racingTrack = RacingTrack(racerNames, racingTime)
    racingTrack.start()

    val winnerNames = Referee.findWinnerNames(racingTrack.racers)
    ResultView.showWinner(winnerNames.joinToString(NAME_SEPARATOR))
}
