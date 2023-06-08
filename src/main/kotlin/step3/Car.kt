package step3

class Car(
    var position: Int = 1,
) {
    fun progress() {
        this.position += 1
    }

    fun showPosition() {
        println("-".repeat(position))
    }
}
