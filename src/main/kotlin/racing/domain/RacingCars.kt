package racing.domain

class RacingCars private constructor(private val racingCars: List<RacingCar>) {
    companion object {
        fun create(carCount: Int): RacingCars = RacingCars(List(carCount) { RacingCar() })
    }

    fun race(tryCount: Int, moveStrategy: MoveStrategy) =
        (1..tryCount).forEach { _ -> racingCars.forEach { it.move(moveStrategy) } }
}