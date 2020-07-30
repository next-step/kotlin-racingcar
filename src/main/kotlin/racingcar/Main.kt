package racingcar

fun main() {

    val carNumber = InputView.getCarNumber()

    val playTime = InputView.getPlayTime()

    val game = Game(carNumber)

    for (time in 1..playTime) {
        val updatedCarList = game.playGameOnce()
        OutputView.printCurrentLocation(updatedCarList)
    }
}
