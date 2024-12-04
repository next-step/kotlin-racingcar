package racing.model

class RacingCars(private val carList: List<Car>): List<Car> by carList {
    fun moveAll() {
        carList.forEach {
            it.move()
        }
    }

    fun getRaceWinners(): RacingCars {
        val validCars = carList.filter { it.position > 0 }
        val groupedByPosition = validCars.groupBy { it.position }
        val maxPosition = groupedByPosition.keys.maxOrNull()
        val carList = groupedByPosition[maxPosition] ?: emptyList()
        return RacingCars(carList)
    }
}
