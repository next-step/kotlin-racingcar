package racinggame.domain.game

import racinggame.domain.player.User
import racinggame.domain.record.RacingRecordBook

data class RacingGameResult(
    val racingRecordBook: RacingRecordBook,
    val winners: List<User>,
)
