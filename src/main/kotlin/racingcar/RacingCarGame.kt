package racingcar

val ATTEMPT_NUMBER_RANGE = 0..9
const val SEPARATOR = ", "

fun main() {
    val carNames = readCarNames()
    val numberOfGames = readNumberOfGames()

    val carList: MutableList<Car> = ArrayList()

    println("\n실행 결과")

    carNames.forEach { initCarList(it, carList) }

    println()

    repeat(numberOfGames) { playGame(carList) }

    val winners = getWinners(carList)

    showWinners(winners)
}

private fun initCarList(it: String, carList: MutableList<Car>) {
    val car = Car()
    car.name = it

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
    require(numberOfWinners >= 1) { "우승자는 1명 이상이어야 합니다." }
}
