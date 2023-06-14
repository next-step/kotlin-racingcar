package racinggame.view

import racinggame.domain.car.CarName
import racinggame.domain.field.MoveDistance
import racinggame.domain.game.GameGuide
import racinggame.domain.game.RacingGame
import racinggame.domain.game.RacingGameResult
import racinggame.domain.player.User
import racinggame.domain.player.UserUniqueId
import racinggame.domain.record.RacingRecordBook
import racinggame.domain.record.RacingRecordPaper
import racinggame.domain.record.RacingRecordPaperList

class MockRacingGame : RacingGame {

    var gameGuideCapture: GameGuide? = null
    var racingGameResultDelegator: (() -> RacingGameResult)? = null

    fun clear() {
        gameGuideCapture = null
    }

    override fun execute(gameGuide: GameGuide): RacingGameResult {
        gameGuideCapture = gameGuide
        return racingGameResultDelegator?.invoke() ?: mockRacingGameResult()
    }

    private fun mockRacingGameResult(): RacingGameResult {
        val mockUser = User(
            id = UserUniqueId.create(),
            carName = CarName("test"),
            ordinal = 0,
        )
        val mockMoveDistance = MoveDistance(0)
        val mockRacingRecordPaper = RacingRecordPaper(
            user = mockUser,
            moveDistance = mockMoveDistance,
        )
        val mockRacingRecordPaperList = RacingRecordPaperList(
            list = listOf(
                mockRacingRecordPaper
            )
        )
        val mockRacingRecordBook = RacingRecordBook(
            totalRacingRecordPaperList = listOf(
                mockRacingRecordPaperList
            ),
        )
        return RacingGameResult(
            racingRecordBook = mockRacingRecordBook,
        )
    }
}
