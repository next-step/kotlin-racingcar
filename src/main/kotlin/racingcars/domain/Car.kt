package racingcars.domain

data class Car(
    val id: Int,
    val name: String,
    private var _position: Int = DEFAULT_POSITION,
) {
    val position: Int
        get() = _position

    fun moveForward(condition: Int) {
        if (condition >= FORWARD_NUMBER) {
            _position++
        }
    }

    companion object {
        private const val DEFAULT_POSITION = 0
        private const val FORWARD_NUMBER = 4
        private const val MAXIMUM_CAR_NAME_LENGTH = 5
        private const val REGEX_VALID_CHARACTERS = "^[a-zA-Z,]+$"

        fun fromInput(
            numberOfCar: Int,
            carNamesInput: String,
        ): List<Car> {
            val carNames = parseCarNamesInput(carNamesInput)
            return createCarList(carNames, numberOfCar)
        }

        private fun parseCarNamesInput(carNamesInput: String): List<String> {
            return carNamesInput.takeIf { it.matches(Regex(REGEX_VALID_CHARACTERS)) }
                ?.split(",")
                ?.map { it.trim() }
                ?.takeIf { it.isNotEmpty() && it.all { name -> name.length <= MAXIMUM_CAR_NAME_LENGTH } }
                ?: throw IllegalArgumentException("자동차 이름은 비어있을 수 없으며 최대 $MAXIMUM_CAR_NAME_LENGTH 글자여야 합니다.")
        }

        private fun createCarList(
            carNames: List<String>,
            numberOfCar: Int,
        ): List<Car> {
            val createdCars = carNames.mapIndexed { index, name -> Car(id = index + 1, name = name) }
            validateNumberOfCars(createdCars, numberOfCar)
            return createdCars
        }

        private fun validateNumberOfCars(
            carList: List<Car>,
            numberOfCars: Int,
        ) {
            require(carList.size == numberOfCars) {
                "자동차 이름과 생성할 대수가 일치하지 않습니다."
            }
        }
    }
}
