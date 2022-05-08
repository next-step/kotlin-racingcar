package racingcar

class Car(private val canGoDecide: () -> Boolean) {
    var position = 0
        private set

    fun proceed() {
        if (canGo()) {
            position++
        }
    }

    private fun canGo(): Boolean {
        return canGoDecide.invoke()
    }
}
