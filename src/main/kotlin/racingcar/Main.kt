package racingcar

import racingcar.domain.Name
import racingcar.domain.RacingGame
import racingcar.view.PositionPrinter
import racingcar.view.UserInput
import racingcar.view.WinnerPrinter

fun main() {
    val names = UserInput.StringArray("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).").answer()
        .map { Name(it) }
    val playCount = UserInput.Int("시도할 회수는 몇 회 인가요?").answer()

    val racingGame = RacingGame(names)
    racingGame.play(playCount)
    PositionPrinter(racingGame.positions).print()
    WinnerPrinter(racingGame.winner().names()).print()
}
