package racing.domain

data class Car(val name: String, var position: Int = START_POSITION) {
    init {
        require(name.length <= 5) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }

    fun moveForward(pedal: Pedal) {
        if (pedal.press()) {
            position++
        }
    }

    companion object {
        private const val START_POSITION = 0
    }
}
