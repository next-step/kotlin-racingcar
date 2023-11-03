package racingcar.domain

fun interface RacingPlayersValidation {
    fun validate(players: RacingPlayers): Boolean

    companion object {
        const val NAME_MAX_LENGTH = 6
    }
}
