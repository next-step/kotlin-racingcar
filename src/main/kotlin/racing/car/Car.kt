package racing.car

data class Car(
    private var name: String = "",
    private var position: Int = 0
) {
    private val maxNameLength = 5
    init {
        carNameLengthValidation()
    }

    fun move() {
        this.position += 1
    }

    fun getPosition(): Int {
        return this.position
    }

    private fun carNameLengthValidation() {
        require(name.length <= maxNameLength) {
            "자동차 이름은 5글자를 초과할 수 없습니다."
        }
    }
}
