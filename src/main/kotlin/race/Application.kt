package race

import race.view.Input
import race.view.Message.GET_CARS_NAME_MESSAGE
import race.view.Message.GET_RACE_COUNT_MESSAGE
import race.view.Output.printResult
import race.view.Output.printWinner

private val randomNumberGenerator = RandomNumberGenerator()
private val inputView = Input()

fun main() {
    val inputCarNames = inputView.getCarNames(GET_CARS_NAME_MESSAGE)
    val carNames = inputCarNames.split(",")
    val raceCount = inputView.getRaceCount(GET_RACE_COUNT_MESSAGE)

    val race = Race(randomNumberGenerator)
    val record = race.start(carNames, raceCount)
    printResult(record)
    printWinner(record)
}
