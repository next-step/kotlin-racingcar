package carracing

const val VIEW_STRING_CAR = "-"
const val VIEW_STRING_SEPARATOR = "\n"
const val FORWARD_INT = 4
const val MIN_RANDOM_INT = 1
const val MAX_RANDOM_INT = 9

fun main() {
    println("자동차 대수는 몇 대인가요?")
    val carCount: String = readln()
    println("시도할 횟수는 몇 회인가요?")
    val movementTryCount: String = readln()
    val inputDto = InputDto(carCount, movementTryCount)

    val randomIntCarRacingManager = RandomIntCarRacingManager.fromInputDto(
        inputDto,
        RandomIntRacingMovementRole(
            FORWARD_INT,
            MIN_RANDOM_INT,
            MAX_RANDOM_INT,
        )
    )
    val carRacingView = CarRacingView(VIEW_STRING_CAR, VIEW_STRING_SEPARATOR)

    repeat(inputDto.movementTryCount) {
        setRandomValue(randomIntCarRacingManager)
        println(carRacingView.getViewString(randomIntCarRacingManager))
        println()
    }
}

private fun setRandomValue(carRacingManager: CarRacingManager<Int>) {
    for (carIndex in 0 until carRacingManager.getCarSize()) {
        val randomNumber = (MIN_RANDOM_INT..MAX_RANDOM_INT).random()
        carRacingManager.tryMoveCar(carIndex, randomNumber)
    }
}
