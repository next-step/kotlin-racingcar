package racing.domain

class Car(
    val name: String
) {
    var position: Int = 0
        private set

    fun moveCar() {
        position += 1
    }
}
