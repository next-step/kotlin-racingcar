package car_race.logic.car

class Cars private constructor(
    private val cars: List<Car>
) {

    fun nextRound() {
        cars.map { car -> car.nextRound() }
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

            val createdCars = (1..input.toLong()).map {
                Car.from()
            }
            return Cars(createdCars)
        }

        private fun validate(input: String) {
            try {
                input.toLong()
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException(
                    INVALID_TYPE_MESSAGE,
                    e
                )
            }
            check(input.toLong() > 0) { throw IllegalArgumentException(INVALID_TYPE_MESSAGE) }
        }
    }
}
