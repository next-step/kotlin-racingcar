package racing.domain

const val START_POSITION = 0

class Car(val name: String) {
    var position = START_POSITION

    init {
        require(name.length <= 5) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }

    fun moveForward(pedal: Pedal) {
        if (pedal.press()) {
            position++
        }
    }
}
