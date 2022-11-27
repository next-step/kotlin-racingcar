package racingcar.service

object CarNameParseService {
    fun parse(carNames: String): List<String> = carNames.split(",")
}
