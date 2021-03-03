package racing

class Car {
    var position = 1

    private fun getProbability(): Int {
        return (MIN_VALUE..MAX_VALUE).random()
    }

    fun tryGo() {
        if (getProbability() >= CAN_GO_LIMIT)
            position++
    }

    companion object {
        const val MIN_VALUE = 0
        const val MAX_VALUE = 9
        const val CAN_GO_LIMIT = 4
    }
}
