package step3

class Cars private constructor(carNames: String) {
    val carList = ArrayList<Car>()

    init {
        val carNamesArray = carNames.split(",")
        for (i in carNamesArray.indices) {
            carList.add(Car.makeCar(carNamesArray[i]))
        }
    }

    fun run(movingStrategy: MovingStrategy) {
        carList.forEach{ car: Car -> car.move(movingStrategy) }
    }

    companion object {
        fun from(carNames: String): Cars {
            return Cars(carNames)
        }
    }
}



