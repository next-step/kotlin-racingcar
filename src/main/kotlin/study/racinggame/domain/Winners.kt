package study.racinggame.domain

class Winners(racingGameStages: List<RacingGameStage>) {
    private val winnersOfGame: List<Participant>
    init {
        val lastStageCarPositions = racingGameStages.last().positionOfCars
        val maxPosition = lastStageCarPositions.map { it.position }
            .maxBy { it.value }
        this.winnersOfGame = lastStageCarPositions
            .filter { it.position == maxPosition }
            .map { it.participant }
    }

    fun names(): List<String> {
        return winnersOfGame.map { it.name }
    }
}
