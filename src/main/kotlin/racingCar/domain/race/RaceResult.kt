package racingCar.domain.race

import racingCar.domain.car.CarStatus

data class RaceResult(val roundResults: List<RaceRoundResult>) {
    val roundCount: Int = roundResults.size
    val winners: List<CarStatus> = findWinners(roundResults.last())

    private fun findWinners(result: RaceRoundResult): List<CarStatus> = with(result.carStatuses) {
        val winningDistance = maxOfOrNull { it.value.position } ?: 0

        filter { it.value.position == winningDistance }
            .map { it.value }
    }

}
