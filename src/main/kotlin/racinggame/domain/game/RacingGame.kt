package racinggame.domain.game

interface RacingGame {

    fun execute(gameGuide: GameGuide): RacingGameResult
}
