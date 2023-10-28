package step3

class Car {

    private var position = 1

    fun getPosition() = position

    private fun isForward() = (0..9).random() >= 4

    fun doForwardOrNot() {
        if (isForward()) position++
    }
}
