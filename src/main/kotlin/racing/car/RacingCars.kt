package racing.car

class RacingCars(
    cars: List<Car>
) {
    val racingCars: List<Car> = cars.map { it.copy() }

    fun findWinner(cars: RacingCars): List<String> {
        val maxPosition = cars.racingCars.maxOf { it.position }
        return cars.racingCars.filter { it.position == maxPosition }
            .map { it.name }
    }
}
