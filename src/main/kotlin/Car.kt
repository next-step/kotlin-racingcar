class Car(
    var distance: Int = 0
) {
    companion object {
        const val FORWARD_CONDITIONS: Int = 4
    }

    fun move() {
        if (checkForwardCondition())
            distance++
    }

    private fun checkForwardCondition(): Boolean {
        return RandomNumberGenerator.getRandomNumber() >= FORWARD_CONDITIONS
    }
}
