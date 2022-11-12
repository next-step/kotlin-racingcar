package racing.domain

class Cars(val cars: List<Car>) {

    constructor(carCount: Int) : this((0 until carCount).map { Car() })

    fun move(): Cars {
        val cars = cars.map { car -> car.move() }
        return Cars(cars)
    }
}
