package step3

class Car(
    val name: String,
    private val mover: Mover
) {
    var distance: Int = 0
        private set

    init {
        validateNameLength(name)
    }

    private fun validateNameLength(name: String) {
        if (name.length > MAX_NAME_LENGTH) {
            throw IllegalArgumentException("자동차 이름은 ${MAX_NAME_LENGTH}자를 초과할 수 없습니다. \"${name}\"의 길이 : ${name.length}")
        }
    }

    fun race() {
        if (mover.canMove()) {
            distance++
        }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}
