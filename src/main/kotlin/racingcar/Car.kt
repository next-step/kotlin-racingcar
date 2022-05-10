package racingcar

class Car(val name: String, private val canGoDecide: () -> Boolean) {
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

    fun makeResult(): String {
        val positionResultString = RESULT_CHAR.repeat(position)
        return "$name : $positionResultString"
    }

    companion object {
        private const val RESULT_CHAR = "-"
    }
}
