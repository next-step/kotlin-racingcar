package racingCar

class Car(
    private var distance: Int = 0,
    private val randomNumber: RandomNumber
) {
    val readOnlyDistance: Int
        get() {
            return distance
        }

    companion object {
        const val FORWARD_CONDITIONS: Int = 4
    }

    fun move() {
        if (checkForwardCondition())
            distance++
    }

    private fun checkForwardCondition(): Boolean {
        return randomNumber.getRandomNumber() >= FORWARD_CONDITIONS
    }
}
