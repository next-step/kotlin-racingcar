package carRacing

fun main() {
    println("자동차 대수는 몇 대인가요?")
    val carCount: String = readLine() ?: throw IllegalArgumentException("자동차 대수는 null 이 올수 없습니다")
    println("시도할 횟수는 몇 회인가요?")
    val movementTryCount: String = readLine() ?: throw IllegalArgumentException("시도할 횟수는 null 이 올수 없습니다")

    val inputDto = InputDto(carCount, movementTryCount)
    val randomNumberCarRacingManager = RandomNumberCarRacingManager(inputDto)

    for (tryCount in 1..inputDto.movementTryCount) {
        setRandomValue(randomNumberCarRacingManager)
        println(randomNumberCarRacingManager.getMonitoringInformation())
        println()
    }
}

private fun setRandomValue(randomNumberCarRacingManager: RandomNumberCarRacingManager) {
    for (carIndex in 0 until randomNumberCarRacingManager.getCarListSize()) {
        val randomNumber = (1..9).random()
        randomNumberCarRacingManager.tryMoveCar(carIndex, randomNumber)
    }
}