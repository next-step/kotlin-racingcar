package racingcar

class Race {
    private val cars: List<Car>

    constructor(carCount: Int) {
        this.cars = (0 until carCount).map { Car() }
    }

    constructor(cars: List<Car>) {
        this.cars = cars
    }

    fun run() {
        for (car in cars) car.move()
    }

    fun getAllMovingDistance(): List<Int> {
        return this.cars.map { it.position }
    }

    fun getCarsSize(): Int {
        return this.cars.size
    }
}