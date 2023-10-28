package step3

class CarRace(
    cars: Int,
) {
    private val carStatus = MutableList(cars) { 1 }

    fun getCarStatus() = carStatus

    private fun isForward() = (0..9).random() >= 4

    fun doRound() {
        carStatus.indices.forEach {
            if (isForward()) carStatus[it]++
        }
    }
}
