package study.racingcar.step4

import kotlin.random.Random

class RacingRun(private val racingCars: List<Racing>) {

    private val fromValue: Int = 0
    private val toValue: Int = 9

    fun nextRun() {
        for (racingCar in racingCars) racingCar.run(randomRunValue())
    }

    fun racingRecords(): List<RacingRecord> {
        return racingCars.map { racingCar -> RacingRecord(racingCar.getName(), racingCar.getPosition()) }
    }

    fun getWinnerCarNamesAsString(): String {
        val maxPosition = racingCars.maxBy { car -> car.getPosition() }!!.getPosition()
        return racingCars.filter { car -> car.getPosition() == maxPosition }
            .joinToString { car -> car.getName() }
    }

    private fun randomRunValue(): Int {
        return Random.nextInt(fromValue, toValue)
    }
}
