package racingcar

data class RacingCar(val name: String, var position: Int = DEFAULT_POSITION_NUMBER, private val engine: Engine) {

    init {
        require(name.length <= MAXIMUM_NAME_LENGTH) { "자동차의 이름은 5글자를 넘을 수 없습니다." }
    }

    fun tryMove() {
        if (engine.power() >= FORWARD_POWER_NUMBER) position++
    }

    companion object {
        const val MINIMUM_POWER_NUMBER = 0
        const val FORWARD_POWER_NUMBER = 4
        const val DEFAULT_POSITION_NUMBER = 0
        private const val MAXIMUM_NAME_LENGTH = 5

        fun of(name: String, position: Int = 0): RacingCar {
            return RacingCar(name, position, RacingCarEngine())
        }
    }
}
