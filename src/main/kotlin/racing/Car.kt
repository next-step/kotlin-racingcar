package racing

class Car(val name: String, private val probability: Probability = Probability()) {
    var position = START_POSITION
        private set

    fun tryGo() {
        if (probability.canGo())
            position++
    }

    companion object {
        private const val START_POSITION = 1
    }
}
