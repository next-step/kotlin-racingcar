package racing

import racing.game.Game
import racing.generator.RandomNumberGenerator
import racing.view.InputView
import racing.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val cars = inputView.getNames("자동차 이름을 입력하세요")
    val tryCount = inputView.get("시도할 횟수는 몇 회인가요?")
    val numberGenerator = RandomNumberGenerator()

    val game = Game(cars)

    repeat(tryCount) {
        val runners = game.run(numberGenerator)
        resultView.view(runners)
    }

    resultView.viewWinner(game.end())
}
