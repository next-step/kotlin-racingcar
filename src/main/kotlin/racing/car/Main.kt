package racing.car

import racing.car.domain.CarFactory
import racing.car.domain.RacingTrack
import racing.car.view.InputView

fun main() {
    val numberOfCars = InputView.enterCarCount()
    val numberOfRounds = InputView.enterRoundCount()
    val racingCars = CarFactory.manufactureRacingCar(numberOfCars)
    val racingTrack = RacingTrack()
    racingTrack.race(racingCars, numberOfRounds)
}
