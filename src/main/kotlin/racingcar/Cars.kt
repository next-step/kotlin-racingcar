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

    fun findWinner(): Winners {
        val positions = getPositions()
        val maxPosition = positions.max()

        val winners = cars.filter { car ->
            car.position == maxPosition
        }.map { car ->
            car.name
        }.toList()

        return Winners(winners)
    }

    private fun canForward(condition: Int) = condition >= MAX_FORWARD_CONDITION

    fun getSize(): Int {
        return cars.size
    }

    fun getPositionByIndex(index: Int): Position {
        return cars[index].position
    }

    fun getPositions(): Positions {
        val positions = cars.map { car -> car.position }
            .toList()

        return Positions(positions)
    }

    companion object {
        private const val MAX_FORWARD_CONDITION = 4
        private const val MIN_CAN_CREATE_CARS = 0

        fun createCars(names: List<String>): Cars {
            checkNameSize(names.size)

            val newCars = names
                .map { name ->
                    Car(name)
                }
                .toList()

            return Cars(newCars)
        }

        private fun checkNameSize(nameSize: Int) {
            require(nameSize > MIN_CAN_CREATE_CARS) { "0 미만의 개수는 생성할 수 없습니다." }
        }
    }
}
