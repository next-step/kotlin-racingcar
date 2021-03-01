package racingcar

fun main() {
    val carCount = UserInput.Int("자동차 대수는 몇 대 인가요?").answer()
    val playCount = UserInput.Int("시도할 회수는 몇 회 인가요?").answer()

    val racingGame = RacingGame(carCount)
    racingGame.play(playCount)
    PositionPrinter(racingGame.positions).print()
}
