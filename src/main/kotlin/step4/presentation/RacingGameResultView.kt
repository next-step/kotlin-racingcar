package step4.presentation

import step4.domain.RacingGameResultText
import step4.domain.ResultView

class RacingGameResultView : ResultView<RacingGameResultText> {
    override fun showResult(resultInfo: RacingGameResultText) {
        for (mid in resultInfo.middleResult) {
            println(mid)
        }

        println(resultInfo.finalResult)
    }
}
