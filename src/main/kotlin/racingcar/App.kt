package racingcar

fun main() {
    val request = read()
    val carCount = request.inputCarCount
    val laps = request.inputLaps

    val cars = cars(carCount)
    val racingGame = RacingGame(cars, laps)

    while (racingGame.isNotEnd()) {
        racingGame.start()
    }

    val lapReports = racingGame.report()
    print(RacingGameResponse(lapReports))
}

private fun cars(carCount: Int): Cars {
    return Cars((0 until carCount).map { Car() })
}

private fun read(): RacingGameRequest {
    return InputView.input()
}

private fun print(response: RacingGameResponse) {
    ResultView.print(response)
}
