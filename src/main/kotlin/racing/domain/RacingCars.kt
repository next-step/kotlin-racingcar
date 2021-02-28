package racing.domain

class RacingCars private constructor(private val racingCars: List<RacingCar>) {
    companion object {
        fun create(carCount: Int): RacingCars = RacingCars(List(carCount) { RacingCar() })
    }
}
