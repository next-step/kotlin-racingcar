package carRacing

class Car(
    val name: String
) {

    init {
        require(name.isNotBlank()) { INVALID_CAR_NAME }
    }

    var position: Int = 0
        private set

    fun move() {
        this.position += 1
    }

    companion object {
        const val INVALID_CAR_NAME = "자동차 이름은 빈 문자열일 수 없다."
    }
}
