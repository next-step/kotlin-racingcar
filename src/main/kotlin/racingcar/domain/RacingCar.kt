package racingcar.domain

class RacingCar(
    private val name: String,
    private var position: Int = 0
) {
    init {
        require(name.length <= 5) {
            throw IllegalArgumentException("자동차 이름은 5자 까지 사용 가능 합니다. 입력하신 차의 이름은 : $name 입니다.")
        }
    }

    fun move(input: Int) {
        if (movePossible(input)) {
            position++
        }
    }

    fun name(): String {
        return name
    }

    fun position(): Int {
        return position
    }

    private fun movePossible(input: Int): Boolean = input >= MOVE_POSSIBLE_NUMBER

    companion object {
        private const val MOVE_POSSIBLE_NUMBER = 4
    }
}
