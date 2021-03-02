package racingcar

class Cars(private val cars: List<Car>) {
    fun forwardAllByCondition(conditions: List<Int>) {
        cars.mapIndexed { index, car ->
            forwardByCondition(car, conditions[index])
        }
    }

    fun forwardByCondition(car: Car, condition: Int) {
        if (canForward(condition)) {
            car.forward()
        }
    }

    private fun canForward(condition: Int) = condition >= MAX_FORWARD_CONDITION

    fun getSize(): Int {
        return cars.size
    }

    fun getPositionByIndex(index: Int): Int {
        return cars[index].position
    }

    fun getPositions(): List<Int> {
        return cars.map { car -> car.position }
            .toList()
    }

    companion object {
        private const val MAX_FORWARD_CONDITION = 4
        private const val MIN_CAN_CREATE_CARS = 0
        private const val CREAT_CAR_START_INDEX = 1

        fun createCars(numberOfCar: Int): Cars {
            require(numberOfCar > MIN_CAN_CREATE_CARS) { "0미만의 개수는 생성할 수 없습니다." }

            val newCars = (CREAT_CAR_START_INDEX..numberOfCar)
                .map { Car() }
                .toList()

            return Cars(newCars)
        }
    }
}
