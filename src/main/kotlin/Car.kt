class Car(
    private var distance: Int = 0
) {
    companion object {
        const val FORWARD_CONDITIONS: Int = 4
    }

    fun move() {
        if (checkForwardCondition())
            distance++
    }

    private fun checkForwardCondition(): Boolean {
        var randomNumber: RandomNumber = RandomNumberGenerator()

        val env =
            try {
                System.getenv("OPERATE_MODE")
            } catch (e: NullPointerException) {
                null
            }

        if (env == "test")
            randomNumber = FixedNumberGenerator()

        return randomNumber.getRandomNumber() >= FORWARD_CONDITIONS
    }

    fun getDistance(): Int {
        return distance
    }
}

fun getRandomNumber(): Int {
    return (0..9).random()
}