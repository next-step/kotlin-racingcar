package racing

import racing.game.Game
import racing.view.InputView
import racing.view.ResultView
import kotlin.random.Random

fun main() {
    val randomLimit = 10
    val inputView = InputView()
    val resultView = ResultView()
    val cars = inputView.getNames("자동차 이름을 입력하세요")
    val tryCount = inputView.get("시도할 횟수는 몇 회인가요?")

    val game = Game(cars)

    repeat(tryCount) {
        val conditions = cars.map { Random.nextInt(randomLimit) }
        val runners = game.run(conditions)
        resultView.view(runners)
    }

    resultView.viewWinner(game.end())
}
