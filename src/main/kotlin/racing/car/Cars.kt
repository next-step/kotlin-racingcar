package racing.car

import racing.moveprovider.MoveProvider

class Cars(val carList: List<Car>) {
    constructor(carNumber: Int) : this(List(carNumber) { Car() })

    fun moveAll(moveProvider: MoveProvider) {
        carList.forEach { car ->
            val moveSteps = moveProvider.getMove()
            car.moveForward(moveSteps)
        }
    }

    fun getWinner(): List<Car> {
        val maxPosition = carList.maxByOrNull { it.position }?.position
        return carList.filter { it.position == maxPosition }
    }
}
