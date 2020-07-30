package racingcar

private const val NAME_LENGTH_MAX = 5
private const val ACCELERATE_MIN_VALUE = 0
private const val ACCELERATE_MAX_VALUE = 9
private const val ACCELERATE_STANDARD_VALUE = 4

class Car(private val name: String) {
    var position: Int = 0
        private set
    var positionHistory = mutableListOf<Int>()
        private set

    init {
        require(name.length < NAME_LENGTH_MAX) { "자동차 이름은 ${NAME_LENGTH_MAX}자 이하로 가능합니다. [input: $name]" }
    }

    fun equalsCurrentPosition(_position: Int): Boolean = position == _position

    fun accelerate(randomZeroToNine: Int): Int {
        require(randomZeroToNine >= ACCELERATE_MIN_VALUE) { "${ACCELERATE_MIN_VALUE}보다 작은 값은 사용이 불가능합니다. [input: $randomZeroToNine]" }
        require(randomZeroToNine <= ACCELERATE_MAX_VALUE) { "${ACCELERATE_MAX_VALUE}보다 큰 값은 사용이 불가능합니다. [input: $randomZeroToNine]" }
        if (randomZeroToNine >= ACCELERATE_STANDARD_VALUE) {
            position++
        }
        positionHistory.add(position)
        return position
    }

    fun getName(): String = name
}
