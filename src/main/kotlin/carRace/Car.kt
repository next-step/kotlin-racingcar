package carRace

data class Car(val driverName: String, private var _traveled: Int, val carMovingStrategy: CarMovingStrategy = RandomMovingStrategy()) {
    val traveled: Int get() = _traveled

    fun drive() {
        if (shouldMove()) {
            _traveled += 1
        }
    }

    private fun shouldMove(): Boolean = carMovingStrategy.shouldMove()
}
