package car_racing

fun main() {
    println("자동차 대수는 몇 대인가요?")
    val carCount: String = readln()
    println("시도할 횟수는 몇 회인가요?")
    val movementTryCount: String = readln()
    val inputDto = InputDto(carCount, movementTryCount)
    val randomNumberCarRacingManager = RandomNumberCarRacingManager.fromInputDto(inputDto)

    repeat(inputDto.movementTryCount) {
        setRandomValue(randomNumberCarRacingManager)
        println(randomNumberCarRacingManager.getMonitoringInformation())
        println()
    }
}

private fun setRandomValue(randomNumberCarRacingManager: RandomNumberCarRacingManager) {
    for (carIndex in 0 until randomNumberCarRacingManager.getCarSize()) {
        val randomNumber = (1..9).random()
        randomNumberCarRacingManager.tryMoveCar(carIndex, randomNumber)
    }
}
