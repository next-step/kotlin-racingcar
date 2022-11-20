package race

import race.view.Input
import race.view.Message.GET_CARS_NAME_MESSAGE
import race.view.Message.GET_RACE_COUNT_MESSAGE
import race.view.Output

private val randomNumberGenerator = RandomNumberGenerator()
private val inputView = Input()
private lateinit var outputView: Output

fun main() {
    val inputCarNames = inputView.getCarNames(GET_CARS_NAME_MESSAGE)
    val carNames = inputCarNames.split(",")
    val raceCount = inputView.getRaceCount(GET_RACE_COUNT_MESSAGE)

    val record = Record.from(carNames)
    val race = Race(randomNumberGenerator, record)
    val resultRecord = race.start(carNames, raceCount)
    outputView = Output(resultRecord)
    outputView.printResult()
    outputView.printWinner()
}
