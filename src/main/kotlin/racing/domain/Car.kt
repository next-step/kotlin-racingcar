package racing.domain

data class Car(
    val name: String = ""
) {
    private val maxNameLength = 5
    private var distance = 0
    val position: Int
        get() = distance
    init {
        validateCarNameLength()
    }

    fun move() {
        this.distance += 1
    }

    private fun validateCarNameLength() {
        require(name.length <= maxNameLength) {
            "자동차 이름은 5글자를 초과할 수 없습니다."
        }
    }
}
