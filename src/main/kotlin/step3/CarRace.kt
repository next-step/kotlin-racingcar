package step3

class CarRace(
    carsCount: Int,
) {
    private val carsStatus = MutableList(carsCount) { Car() }

    fun getCarsPosition() = carsStatus.map { it.getPosition() }.toList()

    fun doRound() {
        carsStatus.forEach { it.doForwardOrNot() }
    }
}
