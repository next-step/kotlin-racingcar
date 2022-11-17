import racingcar.domain.Cars
import racingcar.domain.GameInputValue
import racingcar.domain.InputName
import racingcar.domain.InputNumber
import racingcar.domain.RandomMovingStrategy
import racingcar.view.InputView

fun main() {
    val inputNameOfCars = InputName(InputView().getNameOfCars()).names
    val inputNumberOfTGames = InputNumber(InputView().getNumberOfGames()).number
    val gameInputValue = GameInputValue(inputNameOfCars, inputNumberOfTGames)
    val cars = Cars()
    cars.make(inputNameOfCars, RandomMovingStrategy())
    cars.race(gameInputValue)
    cars.showResult()
}
