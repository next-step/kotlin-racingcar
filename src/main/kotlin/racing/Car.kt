package racing

class Car {
    var currentPosition: Int = 1
        private set

    fun go() {
        if ((0..9).random() >= 4) currentPosition++
    }
}
