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

        val winners = racingGameResult.winners.joinToString(", ") { it.carName.value }
        println("${winners}가 최종 우승했습니다.")
    }

    private fun display(racingRecordPaperList: RacingRecordPaperList) {
        racingRecordPaperList.list
            .map { racingRecordPaper -> racingRecordPaper.user.carName to racingRecordPaper.moveDistance }
            .map { (carName, moveDistance) -> carName.value to "-".repeat(moveDistance.value) }
            .forEach { (carName, moveDistanceLine) -> println("$carName : $moveDistanceLine") }
    }
}
