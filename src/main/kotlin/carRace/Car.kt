package carRace

data class Car(private var _traveled: Int, val carMovingStrategy: CarMovingStrategy = RandomMovingStrategy()) {
    private fun shouldMove(): Boolean = carMovingStrategy.shouldMove()

    val traveled: Int get() = _traveled

    fun drive() {
        if (shouldMove()) {
            _traveled += 1
        }
    }
}
