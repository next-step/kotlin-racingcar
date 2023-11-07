package racingcar.controller

import racingcar.domain.RacingGame
import racingcar.domain.interfaces.Moveable
import racingcar.domain.interfaces.Raceable
import racingcar.domain.parser.RacingParser
import racingcar.view.InputView
import racingcar.view.ResultView

/**
 * 자동차 경주 컨트롤러
 * */
object RacingGameController {

    /**
     * 게임 시작
     * */
    fun runRacingGame() {

        val carNameListText = InputView.getGameInfo(InputView.InputType.CAR_NAME_LIST)
        val roundCntText = InputView.getGameInfo(InputView.InputType.ROUND_COUNT)

        val carList: List<Raceable> = RacingParser.convertTextToCarList(carNameListText)
        val roundCnt = RacingParser.convertTextToRoundCnt(roundCntText)

        ResultView.drawRacingResultMsg()
        RacingGame.run(carList to roundCnt) { roundOverCarList, isGameFinish ->
            ResultView.drawCarStateList(roundOverCarList)
            if (isGameFinish) {
                ResultView.drawRacingWinners(roundOverCarList)
            }
        }
    }
}
