package week1.racingcar

class RacingGame {

    var numberOfCars = 0
    var timesToRace = 0

    fun start() {
        InputView().startInput().also {
            this@RacingGame.apply {
                numberOfCars = it.numberOfCars
            }
            (0 until it.timesToRace).forEach { _ ->
                race()
            }
        }
    }

    fun race() {

    }
}

fun main() {
    RacingGame().start()
}