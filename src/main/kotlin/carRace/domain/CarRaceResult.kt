package carRace.domain

class CarRaceResult(val currentCars: List<Car>) {
    private val _history = mutableListOf<CarLapResult>()
    val history get() = _history.toList()

    fun updateHistory(lap: Int) {
        _history.add(
            CarLapResult(
                lap,
                currentCars.map { it.copy() }
            )
        )
    }

    private fun getFinalLapCarList() = _history
        .first { carLapHistory ->
            carLapHistory.lap == _history.maxOf { lapResult -> lapResult.lap }
        }.cars

    private fun getFinalLapDistance() = getFinalLapCarList().maxOf { it.traveled }

    fun getWinners() = getFinalLapCarList().filter { it.traveled == getFinalLapDistance() }
}
