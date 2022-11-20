package race

import race.view.Input
import race.view.Message.GET_CAR_COUNT_MESSAGE
import race.view.Message.GET_RACE_COUNT_MESSAGE
import race.view.Output

private val randomNumberGenerator = RandomNumberGenerator()
private val inputView = Input()
private val outputView = Output()

fun main() {
    val carCount = inputView.getCount(GET_CAR_COUNT_MESSAGE)
    val raceCount = inputView.getCount(GET_RACE_COUNT_MESSAGE)

    val record = Record.from(carCount)
    val race = Race(randomNumberGenerator, record)
    val result = race.start(carCount, raceCount)
    outputView.printResult(result)
}
