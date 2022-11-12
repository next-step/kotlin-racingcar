package src.step3

object CarOperator {
    fun calculateCarMoveDistance(cars: MutableList<Car>, tryCount: Int, randomValue: Int): MutableList<Car> {
        for (car in cars) {
            var moveCount = 0
            for (i in 0 until tryCount) {
                if (4 <= randomValue) {
                    moveCount++
                    car.move(moveCount)
                } else {
                    car.move(moveCount)
                }
            }
        }

        return cars
    }

    fun makeCar(cars: MutableList<Car>, carNumber: String) {
        for (i in 0 until carNumber.toInt()) {
            cars.add(Car())
        }
    }
}
