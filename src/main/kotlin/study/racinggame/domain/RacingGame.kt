package study.racinggame.domain

class RacingGame(
    val cars: List<Car>,
    val numberOfStages: Int,
) {

    fun start(): RacingGameResult {
        val racingGameStages: List<RacingGameStage> = (0 until numberOfStages)
            .map { stage ->
                val positionOfCars = cars.map { it.move() }
                RacingGameStage(stage, positionOfCars)
            }
        val winners: List<Participant> = chooseWinner(racingGameStages)
        return RacingGameResult(racingGameStages, winners)
    }

    private fun chooseWinner(racingGameStages: List<RacingGameStage>): List<Participant> {
        val lastStageCarPositions = racingGameStages.last().positionOfCars
        val maxPosition = lastStageCarPositions.map { it.position }
            .maxBy { it.value }
        return lastStageCarPositions
            .filter { it.position == maxPosition }
            .map { it.participant }
    }
}

data class RacingGameResult(
    val racingGameStages: List<RacingGameStage>,
    val winners: List<Participant>
)
data class RacingGameStage(
    val stage: Int,
    val positionOfCars: List<CarPosition>,
)

class InsufficientCarsException(numberOfCars: Int) : RuntimeException("최소 2대 이상의 자동차가 필요 합니다. (numberOfCars = $numberOfCars")
class InsufficientStagesException(numberOfStages: Int) : RuntimeException("최소 1번 이상의 스테이지거 팔요 합니다. (numberOfStages = $numberOfStages")
