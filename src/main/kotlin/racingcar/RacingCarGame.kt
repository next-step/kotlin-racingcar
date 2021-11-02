package racingcar

val ATTEMPT_NUMBER_RANGE = 0..9
const val SEPARATOR = ", "
const val MINIMUM_WINNER_COUNT = 1

fun main() {
    val carNames = readCarNames()
    val numberOfGames = readNumberOfGames()

    val carList: MutableList<Car> = mutableListOf()

    println("\n실행 결과")

    carNames.forEach { carName -> initCarList(carName, carList) }

    println()

    repeat(numberOfGames) { playGame(carList) }

    val winners = getWinners(carList)

    showWinners(winners)
}

private fun initCarList(carName: String, carList: MutableList<Car>) {
    val car = Car(carName)
    carList.add(car)
    printCurrentPosition(car.name, car.position)
}

private fun playGame(carList: MutableList<Car>) {
    carList.forEach {
        it.move(ATTEMPT_NUMBER_RANGE.random())
        printCurrentPosition(it.name, it.position)
    }
    println()
}

private fun getWinners(carList: MutableList<Car>): List<Car> {
    val winnerPosition = carList.maxByOrNull { it.position }!!.position
    val winners = carList.filter { it.position == winnerPosition }
    validateWinnersCount(winners.count())
    return winners
}

private fun showWinners(winners: List<Car>) {
    print("${winners.joinToString(SEPARATOR) { it.name }}가 최종 우승했습니다.")
}

fun validateWinnersCount(numberOfWinners: Int) {
    require(numberOfWinners >= MINIMUM_WINNER_COUNT) { "우승자는 ${MINIMUM_WINNER_COUNT}명 이상이어야 합니다." }
}
