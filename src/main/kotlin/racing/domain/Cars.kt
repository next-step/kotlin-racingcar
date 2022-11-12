package racing.domain

class Cars {
    val cars: List<Car>

    constructor(carCount: Int) {
        this.cars = (0 until carCount).map { Car() }
    }

    constructor(cars: List<Car>) {
        this.cars = cars
    }

    fun move(): Cars {
        val cars = cars.map { car -> car.move() }
        return Cars(cars)
    }
}
