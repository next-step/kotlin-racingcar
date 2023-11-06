package racing.car

data class Car(val name: String, var position: Int = INIT_POSITION) {

    fun move() {
        position += ADD_POSITION
    }

    fun validate() {
        validateNameLength(name)
        validateEmpty(name)
    }

    private fun validateNameLength(carName: String) {
        if (carName.length > 5) {
            throw IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.")
        }
    }

    private fun validateEmpty(carName: String) {
        // 공백을 입력했을 경우
        if (carName.isBlank()) {
            throw IllegalArgumentException("자동차 이름이 공백입니다.")
        }
    }

    companion object {
        const val INIT_POSITION = 1
        const val ADD_POSITION = 1
    }
}
