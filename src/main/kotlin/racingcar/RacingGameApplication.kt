package racingcar

import racingcar.InputView.getCarNames
import racingcar.InputView.getRunCnt
import racingcar.RecordRepository.findWinners
import racingcar.RecordRepository.gameRecords

fun main(args: Array<String>) {
    val racing = RacingGame(getCarNames(), getRunCnt())

    racing.start()

    ResultView.showRace(gameRecords)
    ResultView.showWinner(findWinners())
}
