package racingCar.domain.race

import racingCar.domain.car.CarStatus

data class RaceResult(val roundResults: List<RaceRoundResult>) {
    val roundCount: Int = roundResults.size
    val winners: List<CarStatus>

    init {
        val tempWinners: MutableList<CarStatus> = mutableListOf()
        var curMaxPosition = 0
        for (elem in roundResults.last().carStatuses) {
            if (curMaxPosition < elem.value.position) {
                tempWinners.clear()
                tempWinners.add(elem.value)
                curMaxPosition = elem.value.position
            } else if (curMaxPosition == elem.value.position) {
                tempWinners.add(elem.value)
            }
        }
        winners = tempWinners.toList()
    }


}
