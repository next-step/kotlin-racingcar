package study.racinggame.domain

class Winners(racingGameStages: List<RacingGameStage>) {
    private val participant: List<Participant>
    init {
        val lastStageCarPositions = racingGameStages.last().positionOfCars
        val maxPosition = lastStageCarPositions.map { it.position }
            .maxBy { it.value }
        this.participant = lastStageCarPositions
            .filter { it.position == maxPosition }
            .map { it.participant }
    }

    fun names(): List<String> {
        return participant.map { it.name }
    }
}
