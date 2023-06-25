package racingcar.domain

class RacingCar(
    val name: String,
    private val engine: Engine = RacingCarEngine()
) {
    var position: Int = 0
        private set

    init {
        require(name.length <= CAR_NAME_MAX_LENGTH) {
            "자동차 이름은 ${CAR_NAME_MAX_LENGTH}자 까지 사용 가능 합니다. 입력하신 차의 이름은 : $name 입니다."
        }
    }

    fun move() {
        if (engine.movePossible()) {
            position++
        }
    }

    companion object {
        private const val CAR_NAME_MAX_LENGTH = 5
        const val MOVE_POSSIBLE_NUMBER = 4
    }
}
