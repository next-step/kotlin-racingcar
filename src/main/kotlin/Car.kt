class Car(
    val FORWARD_CONDITIONS: Int = 4,
    var distance: Int = 0
) {
    fun move() {
        if (checkForwardCondition())
            distance++
    }

    private fun checkForwardCondition(): Boolean {
        return RandomNumberGenerator.getRandomNumber() >= FORWARD_CONDITIONS
    }
}
