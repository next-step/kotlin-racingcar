package racingcar

class StringParser {
    companion object {
        fun parseRacingCarString(input: String): List<RacingCar> {
            return input.split(",").map { RacingCar(it) }.toList()
        }
    }
}
