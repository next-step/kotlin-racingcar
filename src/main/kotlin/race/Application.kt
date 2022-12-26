package race

import race.view.Input.getCarNames
import race.view.Input.getRaceCount
import race.view.Message.GET_CARS_NAME_MESSAGE
import race.view.Message.GET_RACE_COUNT_MESSAGE
import race.view.Output.printResult
import race.view.Output.printWinner

private val randomNumberGenerator = RandomNumberGenerator()

fun main() {
    val inputCarNames = getCarNames(GET_CARS_NAME_MESSAGE)
    val carNames = inputCarNames.split(",")
    val raceCount = getRaceCount(GET_RACE_COUNT_MESSAGE)

    val race = Race(randomNumberGenerator)
    val record = race.start(carNames, raceCount)
    printResult(record)
    printWinner(record)
}
