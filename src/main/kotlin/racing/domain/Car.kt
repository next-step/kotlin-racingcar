package racing.domain

const val START_POSITION = 0

class Car(val name: String, private val pedal: Pedal) {
    var position = START_POSITION

    fun moveForward() {
        if (pedal.press()) {
            position++
        }
    }
}
