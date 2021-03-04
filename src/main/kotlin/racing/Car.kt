package racing

class Car(val probability: Probability) {
    var position = 1

    fun tryGo() {
        if (probability.getProbability() >= CAN_GO_LIMIT)
            position++
    }

    companion object {
        private const val CAN_GO_LIMIT = 4
    }
}
