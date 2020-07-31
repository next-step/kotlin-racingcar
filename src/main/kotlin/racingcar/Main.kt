package racingcar

fun main() {

    val cars = RacingCars(getCarName())

    val playTime = getPlayTime()

    val game = Game(cars)

    repeat(playTime) {
        printCurrentLocation(game.playGameOnce())
    }

    printWinner(game.winner())
}
