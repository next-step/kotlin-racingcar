package racing.car

data class Car(
    var position: Int = 0
) {

    fun move() {
        this.position += 1
    }
}
