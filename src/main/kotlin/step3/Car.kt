package step3

class Car(val id: Int) {
    var position: Int = 0

    fun move() {
        if ((0..9).random().takeIf { it >= 4 } != null) {
            position++
        }
    }
}
