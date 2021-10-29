package racingcar

const val MINIMUM_CARS = 1
const val MINIMUM_GAMES = 0

fun readNumberOfCars(): Int {
    println("자동차 대수는 몇 대인가요?")
    val numberOfCars = readLine()!!.toInt()

    validateNumberOfCars(numberOfCars)

    return numberOfCars
}

fun readNumberOfGames(): Int {
    println("시도할 횟수는 몇 회인가요?")
    val numberOfGames = readLine()!!.toInt()

    validateNumberOfGames(numberOfGames)

    return numberOfGames
}

fun validateNumberOfCars(input: Int) {
    require(input > MINIMUM_CARS) { "자동차 대수는 2대 이상이어야 합니다." }
}

fun validateNumberOfGames(input: Int) {
    require(input > MINIMUM_GAMES) { "게임 횟수는 1회 이상이어야 합니다." }
}
