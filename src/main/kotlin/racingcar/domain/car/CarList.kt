package racingcar.domain.car

import racingcar.domain.record.RacingRecord

data class CarList(
    val cars: List<Car>
) {
    fun race(tryCount: Int) = RacingRecord(cars.map { car -> car.race(tryCount) })

    companion object {

        fun of(carCount: Int) = CarList(
            cars = (0 until carCount).map { Car(it) }
        )
    }
}
