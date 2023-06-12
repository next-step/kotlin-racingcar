package step3

class Car private constructor(
    private var position: Int = INITIAL_POSITION,
) {
    val positionValue: Int
        get() = this.position

    fun progress(raceNumber: RaceNumber) {
        if (RaceRule.isGo(raceNumber)) {
            this.position += 1
        }
    }

    companion object {
        private const val INITIAL_POSITION = 1

        fun build(): Car {
            return Car()
        }
    }
}
