package racing.domain

class Cars {
    val cars: List<Car>

    constructor(carCount: Int) {
        val cars: MutableList<Car> = mutableListOf()
        for (i in 0 until carCount) {
            cars.add(Car())
        }
        this.cars = cars.toList()
    }

    constructor(cars: List<Car>) {
        this.cars = cars
    }

    fun move(): Cars {
        val cars = cars.map { car -> car.move() }
            .toList()
        return Cars(cars)
    }
}
