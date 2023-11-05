package racing

class Car(var position: String = "") {

    fun move() {
        position += "-"
    }
}
