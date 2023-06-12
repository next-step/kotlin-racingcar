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

        if (System.getenv("OPERATE_MODE").equals("test"))
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