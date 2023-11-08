package carRacing.domain

class RacingResult {
    private lateinit var winnerNames: List<String>
    private var racingResultHistory: MutableList<List<Car>> = mutableListOf()

    fun getWinnerNames(): List<String> = this.winnerNames

    fun add(carList: List<Car>) {
        this.racingResultHistory.add(carList)

        val maxPosition: Int = carList.maxBy { it.position }.position
        winnerNames = carList.filter { it.position == maxPosition }.map { it.name }
    }

    fun getRacingResultHistory(): List<List<Car>> = this.racingResultHistory
}
