package racing.domain

class Car(val name: String, var position: Int = 0) {

    init {
        require(name.length <= MAXIMUM_NAME_LENGTH) { "자동차의 이름은 5자를 초과할 수 없습니다." }
    }

    fun move() {
        this.position += CAR_FORWARD_COUNT
    }

    fun isEqualToPosition(comparingPosition: Int): Boolean {
        return this.position == comparingPosition
    }

    companion object {
        private const val MAXIMUM_NAME_LENGTH: Int = 5
        private const val CAR_FORWARD_COUNT: Int = 1
    }
}
