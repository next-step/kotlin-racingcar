package domain

class Car(
    val name: String,
    private val engine: Engine = RacingCarEngine()
) {

    var position: Int = 0
        private set

    init {
        require(name.length < CAR_NAME_MAX_LENGTH) { throw IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.") }
    }

    fun move(number: Int = engine.getRandomNumber()) {
        if (engine.isMoving(number)) position++
    }

    companion object {
        const val CAR_NAME_MAX_LENGTH = 5
    }
}
