package racinggame.domain.record

import racinggame.domain.field.MoveDistance
import racinggame.domain.player.User

data class RacingRecordPaper(
    val user: User,
    val moveDistance: MoveDistance,
)
