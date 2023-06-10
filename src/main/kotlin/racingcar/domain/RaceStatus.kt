package racingcar.domain

data class RaceStatus(
    val finished: Boolean,
    val cars: List<RaceCarStatus>
) {

    companion object {
        fun of(finished: Boolean, cars: List<Car>): RaceStatus = RaceStatus(
            finished,
            cars.toRaceCarsStatus()
        )

        private fun List<Car>.toRaceCarsStatus(): List<RaceCarStatus> = map { RaceCarStatus(it) }
    }
}

data class RaceCarStatus(
    val carRef: CarRef,
    val location: Location
) {
    constructor(car: Car) : this(car, car.location())
}
