package carracing

const val VIEW_STRING_CAR = "-"
const val VIEW_STRING_SEPARATOR = "\n"

fun main() {
    println("자동차 대수는 몇 대인가요?")
    val carCount: String = readln()
    println("시도할 횟수는 몇 회인가요?")
    val movementTryCount: String = readln()
    val inputDto = InputDto(carCount, movementTryCount)
    val randomIntCarRacingManager =
        RandomIntCarRacingManager.fromInputDto(inputDto, RandomIntRacingMovementRole(4, 1, 9))
    val carRacingView = CarRacingView<Int>(VIEW_STRING_CAR, VIEW_STRING_SEPARATOR)

    repeat(inputDto.movementTryCount) {
        setRandomValue(randomIntCarRacingManager)
        println(carRacingView.getViewString(randomIntCarRacingManager))
        println()
    }
}

private fun setRandomValue(randomIntCarRacingManager: RandomIntCarRacingManager) {
    for (carIndex in 0 until randomIntCarRacingManager.getCarSize()) {
        val randomNumber = (1..9).random()
        randomIntCarRacingManager.tryMoveCar(carIndex, randomNumber)
    }
}
