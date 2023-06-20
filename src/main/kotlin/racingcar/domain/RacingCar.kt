package racingcar.domain

class RacingCar(
    val name: String,
    private val numberGenerator: NumberGenerator
) {
    var position: Int = 0
        private set

    init {
        require(name.length <= CAR_NAME_MAX_LENGTH) {
            "자동차 이름은 ${CAR_NAME_MAX_LENGTH}자 까지 사용 가능 합니다. 입력하신 차의 이름은 : $name 입니다."
        }
    }

    fun move() {
        if (movePossible(numberGenerator.generateNumber())) {
            position++
        }
    }

    private fun movePossible(input: Int): Boolean = input >= MOVE_POSSIBLE_NUMBER

    companion object {
        private const val MOVE_POSSIBLE_NUMBER = 4
        private const val CAR_NAME_MAX_LENGTH = 5
    }
}
