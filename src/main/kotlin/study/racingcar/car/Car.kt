package study.racingcar.car

class Car(val name: String) {
    init {
        require(name.length <= MAX_NAME_LENGTH) {
            "자동차의 이름은 5자를 초과할 수 없습니다."
        }
    }

    var currentLocation: Int = INIT_LOCATION
        private set

    fun move(power: Int) {
        if (canMove(power)) {
            currentLocation += 1
        }
    }

    private fun canMove(power: Int): Boolean {
        return power >= FORWARD_NUMBER
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
        private const val FORWARD_NUMBER = 4
        private const val INIT_LOCATION = 1
    }
}
