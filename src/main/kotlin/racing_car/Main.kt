package racing_car

import racing_car.interfaces.Movable
import racing_car.parser.RacingParser
import racing_car.ui.InputView
import racing_car.ui.ResultView

fun main() {
    InputView.draw(InputView.InputType.CAR_NAME_LIST)
    val carNameListText = readln()

    InputView.draw(InputView.InputType.ROUND_COUNT)
    val roundCntText = readln()

    val roundCnt = RacingParser.convertTextToRoundCnt(roundCntText)
    var racingGameResult: List<Movable> = RacingParser.convertTextToCarList(carNameListText)

    ResultView.drawRacingResultMsg()

    repeat(roundCnt) {
        racingGameResult = RacingGame.playRound(racingGameResult)
        ResultView.drawCarStateList(racingGameResult)
    }

    ResultView.drawRacingWinners(racingGameResult)
}