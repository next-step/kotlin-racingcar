package carRacing.domain

class RacingResult {
    private lateinit var winnerNames: List<String>
    private var racingResultHistory: MutableList<CarList> = mutableListOf()

    fun getWinnerNames(): List<String> = this.winnerNames

    fun add(carList: CarList) {
        this.racingResultHistory.add(carList)
        val readOnlyCarList: List<Car> = carList.getCarList()

        val maxPosition: Int = readOnlyCarList.maxBy { it.position }.position
        winnerNames = readOnlyCarList.filter { it.position == maxPosition }.map { it.name }
    }

    fun getRacingResultHistory(): List<CarList> = this.racingResultHistory
}
