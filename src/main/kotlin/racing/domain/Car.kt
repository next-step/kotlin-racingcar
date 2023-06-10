package racing.domain

class Car(
    var position: Int = 0
) {

    fun moveCheck(randomNumber: Int): Boolean = randomNumber >= 4

    fun move() {
        this.position = this.position.plus(1)
    }
}
