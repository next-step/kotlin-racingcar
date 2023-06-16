package study.racinggame.domain

class Winners(racingGameStages: List<RacingGameStage>) {
    private val winnersOfGame: List<Participant>
    init {
        val lastStage = racingGameStages.last()
        this.winnersOfGame = lastStage.frontRunners()
            .map { it.participant }
    }

    fun names(): List<String> {
        return winnersOfGame.map { it.name }
    }
}
