import racingcar.domain.Cars
import racingcar.domain.GameInputValue
import racingcar.domain.InputNumber
import racingcar.domain.RandomMovingStrategy
import racingcar.view.InputView

fun main() {
    val inputNumberOfCars = InputNumber(InputView().getNumberOfCars()).number
    val inputNumberOfTGames = InputNumber(InputView().getNumberOfGames()).number
    val gameInputValue = GameInputValue(inputNumberOfCars, inputNumberOfTGames)
    Cars().startRace(gameInputValue, RandomMovingStrategy())
}
