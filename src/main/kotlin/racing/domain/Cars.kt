package racing.domain

class Cars(private val cars: List<Car>) {

    constructor(carCount: Int) : this((0 until carCount).map { Car() })

    fun move(): Positions {
        return Positions(cars.map { car -> car.move() })
    }
}
