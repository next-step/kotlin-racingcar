package game.racing.domain

object MovementStrategy {
    fun randomMoveStrategy(): Int {
        return (RacingGame.MIN_RANDOM_VALUE..RacingGame.MAX_RANDOM_VALUE).random()
    }
}
