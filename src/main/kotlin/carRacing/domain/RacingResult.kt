package carRacing.domain

class RacingResult(private var racingResultHistory: MutableList<CarList>) {
    private lateinit var winnerNames: List<String>

    fun getWinnerNames(): List<String> = this.winnerNames

    init {
        this.winnerNames = this.racingResultHistory.map { this.getWinnerNames(it) }.last()
    }

    fun add(carList: CarList) {
        this.racingResultHistory.add(carList)
        this.winnerNames = this.getWinnerNames(carList)
    }

    private fun getWinnerNames(carList: CarList): List<String> {
        val readOnlyCarList = carList.getCarList()

        val maxPosition: Int = readOnlyCarList.maxBy { it.position }.position
        return readOnlyCarList.filter { it.position == maxPosition }.map { it.name }
    }

    fun getRacingResultHistory(): List<CarList> = this.racingResultHistory
}
