package racingCar.domain

class CarRace(
    private val carList: List<Car>,
    private val numOfMove: Int
) {

    fun start(): RaceLog {
        val raceLog = RaceLog()

        repeat(numOfMove) {
            carList.forEach { it.move() }
            raceLog.addLog(carList)
        }

        raceLog.winners = getWinners(carList)

        return raceLog
    }

    private fun getWinners(carList: List<Car>): List<Car> {
        val maxPosition = carList.maxOf { car -> car.position }
        return carList.filter{ it.position == maxPosition }
    }
}