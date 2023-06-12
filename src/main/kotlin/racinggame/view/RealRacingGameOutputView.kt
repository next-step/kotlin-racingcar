package racinggame.view

import racinggame.domain.game.RacingGameResult

class RealRacingGameOutputView : RacingGameOutputView {

    override fun display(racingGameFixedMessage: RacingGameFixedMessage) {
        println(racingGameFixedMessage.koreaGuideMessage)
    }

    override fun display(racingGameResult: RacingGameResult) {
        racingGameResult.racingRecordBook
            .totalRacingRecordPaperList
            .forEach { racingRecordPaperList ->
                racingRecordPaperList.list
                    .map { racingRecordPaper -> racingRecordPaper.moveDistance.distance }
                    .forEach { racingCarMoveDistance -> println("-".repeat(racingCarMoveDistance)) }
                println()
            }
        println()
    }
}
