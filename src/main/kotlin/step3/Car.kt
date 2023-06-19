package step3

class Car(
    var position: Int = 0
) {
    fun move(distance: Int) {
        this.position += distance
    }
}