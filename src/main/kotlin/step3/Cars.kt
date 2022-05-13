package step3

class Cars private constructor(count: Int) {
    val carsList: List<Car>

    init {
        val cars: MutableList<Car> = ArrayList(count)
        repeat(count) {
            cars.add(Car.makeCar())
        }
        this.carsList = cars
    }

    fun run(movingStrategy: MovingStrategy) {
        carsList.forEach{ car: Car -> car.move(movingStrategy) }
    }

    companion object {
        fun from(count: Int): Cars {
            return Cars(count)
        }
    }
}


