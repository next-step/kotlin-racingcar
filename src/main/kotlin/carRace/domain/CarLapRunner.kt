package carRace.domain

import java.lang.RuntimeException

class CarLapRunner(private val carRaceResult: CarRaceResult, private val totalLap: Int) {
    var currentLap: Int = 0
        private set

    fun runLaps() {
        require(currentLap == 0) { RuntimeException("runLaps should be called only once (current lap: $currentLap)") }
        repeat(totalLap) {
            carRaceResult.cars.driveCars()
            currentLap += 1
            carRaceResult.updateHistory(currentLap)
        }
    }
}
