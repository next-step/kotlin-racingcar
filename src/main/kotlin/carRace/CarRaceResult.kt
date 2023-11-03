package carRace

class CarRaceResult(val currentCars: List<Car>) {
    val history = mutableListOf<CarLapResult>()

    fun driveCars(lap: Int) {
        currentCars.forEach {
            it.drive()
        }
        history.add(
            CarLapResult(
                lap,
                currentCars.map { it.copy() }
            )
        )
    }

    private fun getFinalLapCarList() = history
        .first { carLapHistory ->
            carLapHistory.lap == history.maxOf { lapResult -> lapResult.lap }
        }.cars

    private fun getFinalLapDistance() = getFinalLapCarList().maxOf { it.traveled }

    fun getWinners() = getFinalLapCarList().filter { it.traveled == getFinalLapDistance() }
}
