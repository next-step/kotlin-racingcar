package racinggame.view

import racinggame.domain.game.RacingGameResult
import racinggame.domain.record.RacingRecordPaperList

class RealRacingGameOutputView : RacingGameOutputView {

    override fun display(racingGameFixedMessage: RacingGameFixedMessage) {
        println(racingGameFixedMessage.koreaGuideMessage)
    }

    override fun display(racingGameResult: RacingGameResult) {
        racingGameResult.racingRecordBook
            .totalRacingRecordPaperList
            .forEach { racingRecordPaperList ->
                display(racingRecordPaperList)
                println()
            }
        println()
    }

    private fun display(racingRecordPaperList: RacingRecordPaperList) {
        racingRecordPaperList.list
            .map { racingRecordPaper -> racingRecordPaper.moveDistance.value }
            .forEach { racingCarMoveDistance -> println("-".repeat(racingCarMoveDistance)) }
    }
}
