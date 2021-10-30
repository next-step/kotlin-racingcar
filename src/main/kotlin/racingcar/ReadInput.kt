package racingcar

const val MAXIMUM_CHARACTERS_NAME = 5
const val MINIMUM_CHARACTERS_NAME = 1
const val MINIMUM_CARS = 1
const val MINIMUM_GAMES = 0

fun readCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    val carList = readLine()!!.split(',')
    carList.forEach {
        validateNameOfCar(it)
    }
    return carList
}

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

fun validateNameOfCar(input: String) {
    require(input.isNotBlank() && input.length in MINIMUM_CHARACTERS_NAME..MAXIMUM_CHARACTERS_NAME) { "자동차 이름은 1자 이상 5자 이하여야 합니다." }
}

fun validateNumberOfCars(input: Int) {
    require(input > MINIMUM_CARS) { "자동차 대수는 2대 이상이어야 합니다." }
}

fun validateNumberOfGames(input: Int) {
    require(input > MINIMUM_GAMES) { "게임 횟수는 1회 이상이어야 합니다." }
}
