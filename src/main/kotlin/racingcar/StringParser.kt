package racingcar

object StringParser {
    fun parseRacingCarString(input: String): List<RacingCar> {
        return input.split(",").map { RacingCar(it) }.toList()
    }
    fun getIntValue(input: String): Int {
        require(input.isNotBlank() && (input.toInt() > RacingCar.MINIMUM_POWER_NUMBER)) { "0 보다 큰 숫자값을 입력하세요" }
        return input.toInt()
    }
}
