package step3

class Car(
    private var position: Int = 1,
) {
    val positionValue: Int
        get() = this.position

    fun progress() {
        val raceNumber = RaceNumber.from(buildRandomNumber())
        if (RaceRule.isGo(raceNumber)) {
            this.position += 1
        }
    }

    private fun buildRandomNumber(): Int {
        return (Math.random() * RANDOM_RANGE).toInt()
    }

    companion object {
        private const val RANDOM_RANGE = 10
    }
}
