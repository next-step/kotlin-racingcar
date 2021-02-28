package racinggame.car

import racinggame.record.Record
import racinggame.record.Recorder
import racinggame.record.Records

class RacingCars(private val cars: List<RacingCar>) {
    val recorder = Recorder.zero()

    fun move(trialAmount: Int) {
        repeat(trialAmount) { time ->
            cars.move()
            recorder.record(cars.toRecords(time))
        }
    }
}

fun Iterable<RacingCar>.toRacingCars(): RacingCars {
    return RacingCars(toList())
}

private fun Iterable<RacingCar>.move() {
    forEach { it.move() }
}

private fun Iterable<RacingCar>.toRecords(time: Int): Records {
    val list = map { Record(time, it.distance()) }
        .toList()
    return Records(list)
}
