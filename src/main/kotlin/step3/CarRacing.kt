package step3

class CarRacing private constructor(var carCount: Int, var moveCount: Int) {
    var cars = Cars.from(carCount)

    fun run(movingStrategy: MovingStrategy) {
        repeat(moveCount) {
            cars.run(movingStrategy)
        }
    }

    companion object {
        fun of(carCount: Int, moveCount: Int): CarRacing {
            return CarRacing(carCount, moveCount)
        }
    }
}
