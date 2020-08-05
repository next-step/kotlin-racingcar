package racingcar.model

class Car(val name: String, distance: Int) {

    var movingDistance: Int = distance
        private set

    init {
        require(name.length <= MAX_CAR_NAME) { "차 이름은 최대 5글자까지 가능합니다." }
    }

    fun move(number: Int) {
        if (number >= MOVING_MIN_CONDITION) movingDistance++
    }

    fun isEqualDistance(distance: Int) = this.movingDistance == distance

    companion object {
        private const val MAX_CAR_NAME = 5
        private const val MOVING_MIN_CONDITION = 4
    }
}
