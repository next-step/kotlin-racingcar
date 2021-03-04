package racinggame.car.domain

import racinggame.record.domain.Recorder

class RacingCars(private val cars: List<RacingCar>) {
    fun move(trialAmount: Int, recorder: Recorder) {
        repeat(trialAmount) { time ->
            cars.move()
            recorder.record(cars, time)
        }
    }
}

fun Iterable<RacingCar>.toRacingCars(): RacingCars {
    return RacingCars(toList())
}

private fun Iterable<RacingCar>.move() {
    forEach { it.move() }
}
