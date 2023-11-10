package racingcar.domain

data class Car(
    var location: Int = CAR_DEFAULT_LOCATION,
    val name: String,
) {
    init {
        require(this.name.length <= CAR_MAX_NAME_LENGTH) { "자동차 이름은 최대 ${CAR_MAX_NAME_LENGTH}글자 입니다" }
    }

    fun moveOrStop(engine: Engine) {
        val power = engine.powerUp()
        if (isMovablePower(power)) {
            location++
        }
    }

    private fun isMovablePower(power: Int): Boolean =
        power in MOVABLE_MIN_POWER..MOVABLE_MAX_POWER

    companion object {
        const val CAR_DEFAULT_LOCATION = 0
        private const val MOVABLE_MAX_POWER = 9
        private const val MOVABLE_MIN_POWER = 4
        private const val CAR_MAX_NAME_LENGTH = 5
    }
}
