package racingcar.model

data class Car(val name: String) {

    var movingDistance: Int = 0
        private set

    init {
        require(name.length <= 5) { "차 이름은 최대 5글자까지 가능합니다." }
    }

    fun move(number: Int) {
        if (number >= MOVING_MIN_CONDITION) movingDistance++
    }

    companion object {
        private const val MAX_CAR_NAME = 5
        private const val MOVING_MIN_CONDITION = 4
    }
}
