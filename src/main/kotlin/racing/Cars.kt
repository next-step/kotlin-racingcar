package racing

class Cars {
    val carList: List<Car>
    constructor(carList: List<Car>) {
        this.carList = carList
    }

    constructor(carNumber: Int) {
        this.carList = List(carNumber) { Car() }
    }

    constructor(carNames: List<String>) {
        this.carList = carNames.map { Car(name = it) }
    }

    fun moveAll(moveProvider: () -> Int) {
        carList.forEach { car ->
            val moveSteps = moveProvider()
            car.moveForward(moveSteps)
        }
    }

    fun getWinner(): List<Car> {
        val maxPosition = carList.maxByOrNull { it.currentPosition }?.currentPosition
        return carList.filter { it.currentPosition == maxPosition }
    }
}

