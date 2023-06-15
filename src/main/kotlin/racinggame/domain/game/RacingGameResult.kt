package racinggame.domain.game

import racinggame.domain.record.RacingRecordBook

data class RacingGameResult(
    val racingRecordBook: RacingRecordBook,
) {
    val winners = racingRecordBook.finalRound.maxMoveDistanceUsers
}
