package racingCar

data class Car(private val name: String) {
    var distance = DEFAULT_DISTANCE
        private set

    fun move(number: Int) {
        if (number >= FORWARD_NUMBER) {
            distance++
        }
    }

    fun getName(): String = name

    companion object {
        const val FORWARD_NUMBER = 4
        const val DEFAULT_DISTANCE = 0
    }
}
