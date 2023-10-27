package game

class RacingCarGame() {

    private val carCountQuestion = "자동차 대수는 몇 대인가요?"
    private val retryCountQuestion = "시도할 회수는 몇 회인가요?"

    fun start() {
        ConsoleTextPrinter.printText(carCountQuestion)
        val carCount = ConsoleInputReader.readInput().toInt()
        ConsoleTextPrinter.printText(retryCountQuestion)
        val retryCount = ConsoleInputReader.readInput().toInt()
        val cars = Cars.fromCarCount(carCount)
        cars.advance(retryCount)
    }
}

fun main() {
    val racingCarGame = RacingCarGame()
    racingCarGame.start()
}
