package racing

class Cars {
    val carList: List<Car>
    constructor(carList: List<Car>) {
        this.carList = carList
    }

    constructor(carNumber: Int) {
        this.carList = List(carNumber) { Car() }
    }

    fun moveAll(moveProvider: () -> Int){
        carList.forEach { car ->
            val moveSteps = moveProvider()
            car.moveForward(moveSteps)
        }
    }
}

