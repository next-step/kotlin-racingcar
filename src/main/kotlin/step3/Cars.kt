package step3

class Cars private constructor(private val carNames: String) {
    val carsList: List<Car>

    init {
        val carNamesArray = carNames.split(",")
        val cars: MutableList<Car> = ArrayList()
        for (i in carNamesArray.indices) {
            cars.add(Car.makeCar(carNamesArray[i]))
        }
        this.carsList = cars
    }

    fun run(movingStrategy: MovingStrategy) {
        carsList.forEach{ car: Car -> car.move(movingStrategy) }
    }

    companion object {
        fun from(carNames: String): Cars {
            return Cars(carNames)
        }
    }
}


