package racingcar.view

const val MAXIMUM_CAR_NAME_LENGTH = 5
const val MINIMUM_CAR_NAME_LENGTH = 1
const val MINIMUM_CARS = 1
const val MINIMUM_GAMES = 0
const val CAR_NAME_DELIMITER = ','

fun readCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    val carNames = readLine()!!.split(CAR_NAME_DELIMITER)
    carNames.forEach { carName ->
        validateNameOfCarIsNotBlank(carName)
        validateNameOfCarLength(carName)
    }
    validateNumberOfCars(carNames.count())
    return carNames
}

fun readNumberOfGames(): Int {
    println("시도할 횟수는 몇 회인가요?")
    val numberOfGames = readLine()!!.toInt()

    validateNumberOfGames(numberOfGames)

    return numberOfGames
}

fun validateNameOfCarIsNotBlank(input: String) {
    require(input.isNotBlank()) { "자동차 이름은 공백이어선 안됩니다." }
}

fun validateNameOfCarLength(input: String) {
    require(input.length in MINIMUM_CAR_NAME_LENGTH..MAXIMUM_CAR_NAME_LENGTH) { "자동차 이름은 1자 이상 5자 이하여야 합니다." }
}

fun validateNumberOfCars(input: Int) {
    require(input > MINIMUM_CARS) { "자동차 대수는 2대 이상이어야 합니다." }
}

fun validateNumberOfGames(input: Int) {
    require(input > MINIMUM_GAMES) { "게임 횟수는 1회 이상이어야 합니다." }
}
