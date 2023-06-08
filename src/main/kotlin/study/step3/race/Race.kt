package study.step3.race

import kotlin.random.Random

class Race(
    command: Command,
    private val random: Random
) {

    private val carStorage = command.carStorage()
    private val totalRaceCount = command.raceTryCnt()
    private val drawView = DrawView(totalRaceCount)

    companion object {
        private const val RANDOM_BOUND = 10
        private const val FORWARD_THRESHOLD = 3
    }

    fun startRace() {
        for (raceIdx in 1..totalRaceCount) {
            moveCarsIfPossible()
            drawView.drawCarState(carStorage, raceIdx)
        }
    }

    private fun moveCarsIfPossible() {
        for (carIdx in carStorage.indices) {
            val randomNumber = random.nextInt(RANDOM_BOUND)
            if (randomNumber > FORWARD_THRESHOLD) carStorage[carIdx] += 1
        }
    }
}
