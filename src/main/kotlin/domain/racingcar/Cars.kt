package domain.racingcar

class Cars(private val cars: List<Car>) {
    fun forwardAllByCondition(randomConditions: Conditions) {
        cars.map { forwardByCondition(it, randomConditions.makeCondition()) }
    }

    fun forwardByCondition(car: Car, condition: Int) {
        if (canForward(condition)) {
            car.forward()
        }
    }

    fun findWinner(): Winners {
        val positions = getPositions()
        val maxPosition = positions.max()

        val winners = cars
            .filter { it.position == maxPosition }
            .map { it.name }

        return Winners(winners)
    }

    private fun canForward(condition: Int) = condition >= MAX_FORWARD_CONDITION

    fun getSize(): Int {
        return cars.size
    }

    fun getPositionByIndex(index: Int): Position {
        return cars[index].position
    }

    private fun getPositions(): Positions {
        return Positions(cars.map { it.position })
    }

    fun finishRound(): Records {
        return Records(cars.map { Record(it.name, newPosition(it.position)) })
    }

    private fun newPosition(position: Position) = Position(position.position)

    companion object {
        private const val MAX_FORWARD_CONDITION = 4
        private const val MIN_CAN_CREATE_CARS = 0

        fun createCars(names: List<String>): Cars {
            validateNameSize(names.size)

            return Cars(names.map { Car(it) })
        }

        private fun validateNameSize(nameSize: Int) {
            require(nameSize > MIN_CAN_CREATE_CARS) { "0 미만의 개수는 생성할 수 없습니다." }
        }
    }
}
