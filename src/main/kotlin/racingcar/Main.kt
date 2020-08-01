package racingcar

fun main() {

    val playTime = getPlayTime()

    val racingCars = RacingCars(getCarName())

    repeat(playTime) {
        printCurrentLocation(racingCars.playGameOnce())
    }

    printWinner(racingCars.getWinner())
}
