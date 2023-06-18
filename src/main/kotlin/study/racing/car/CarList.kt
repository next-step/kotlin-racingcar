package study.racing.car

class CarList(
    private val cars: List<Car>
) : List<Car> by cars
