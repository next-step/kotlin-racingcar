package racingcar

fun main() {
    val carNumber = readCarNumber()
    val tryCount = readTryCount()
    val game = Game(carNumber, tryCount)
    val gameResults = game.run()
    printGameResult(gameResults)
}
