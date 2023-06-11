package racing.car

class RacingCars(
    cars: List<Car>
) {
    val racingCars: List<Car> = cars.map { it.copy() }
}
