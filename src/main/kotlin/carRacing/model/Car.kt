package carRacing.model

class Car(
    val name: String
) : Comparable<Car> {

    init {
        require(name.isNotBlank()) { INVALID_CAR_NAME }
        require(name.length < 5) { INVALID_CAR_LENGTH }
    }

    var position: Int = 0
        private set

    fun move() {
        this.position += 1
    }

    fun isDrawWith(other: Car): Boolean = other.position == this.position

    companion object {
        const val INVALID_CAR_NAME = "자동차 이름은 빈 문자열일 수 없다."
        const val INVALID_CAR_LENGTH = "자동차 이름은 5글자를 초과할 수 없다."
    }

    override fun compareTo(other: Car): Int = this.position - other.position
}
