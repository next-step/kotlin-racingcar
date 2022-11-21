package racingcar.domain

class Round(val id: Int) {
    fun start(carGroup: CarGroup): RoundResult {
        carGroup.move()
        val carPositions = carGroup.getPositions()
        return RoundResult(carPositions = carPositions)
    }
}
