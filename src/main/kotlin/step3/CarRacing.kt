package step3

class CarRacing private constructor(var carCount: Int, var moveCount: Int) {
    var cars: Cars = Cars.from(carCount)

    fun run(movingStrategy: MovingStrategy?) {
        for (i in 0 until moveCount) {
            cars.run(movingStrategy)
        }
    }

    companion object {
        fun of(carCount: Int, moveCount: Int): CarRacing {
            return CarRacing(carCount, moveCount)
        }
    }
}

