package car_race.logic.car

import car_race.logic.system.MovingSystem

class Cars(
    private val cars: List<Car>
) {

    fun nextRound(movingSystem: MovingSystem) {
        cars.map { car ->
            car.nextRound(movingSystem)
        }
    }

    fun getPositions(): List<CarPosition> {
        return cars.map { car ->
            car.getPosition()
        }
    }

    companion object {
        private const val INVALID_TYPE_MESSAGE = "게임 참여 자동차는 양의 정수여야 합니다."

        fun from(input: String): Cars {
            validate(input)

            val createdCars = (1..input.toLong()).map { Car() }
            return Cars(createdCars)
        }

        private fun validate(input: String) {
            val inputNumber = try {
                input.toLong()
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException(
                    INVALID_TYPE_MESSAGE,
                    e
                )
            }
            check(inputNumber > 0) { throw IllegalArgumentException(INVALID_TYPE_MESSAGE) }
        }
    }
}
