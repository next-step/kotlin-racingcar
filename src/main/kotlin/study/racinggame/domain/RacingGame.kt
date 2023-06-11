package study.racinggame.domain

class RacingGame(
    val cars: List<Car>,
    val numberOfStages: Int,
) {

    fun start(): RacingGameResult {
        val racingGameStages = (0 until numberOfStages)
            .map { stage ->
                val positionOfCars = cars.map { it.move() }
                RacingGameStage(stage, positionOfCars)
            }

        val lastStageCarPositions = racingGameStages.last().positionOfCars
        val maxPosition = lastStageCarPositions.map { it.position }
            .maxBy { it }
        val winners: List<String> = lastStageCarPositions
            .filter { it.position == maxPosition }
            .map { it.name }

        return RacingGameResult(racingGameStages, winners)
    }
}

data class RacingGameResult(
    val racingGameStages: List<RacingGameStage>,
    val winners: List<String>
)
data class RacingGameStage(
    val stage: Int,
    val positionOfCars: List<CarPosition>,

)
