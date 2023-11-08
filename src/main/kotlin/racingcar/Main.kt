package racingcar

fun main() {
    val carNames = readCarNames()
    val tryCount = readTryCount()
    val game = Game(carNames, tryCount)
    val gameResults = game.run()
    printGameResult(gameResults)
}
