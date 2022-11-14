package racing.view

object GameInputView {
    private const val NAME_SEPARATOR = ","

    fun splitNameOfCars(nameOfCars: String) = nameOfCars.split(NAME_SEPARATOR)

    fun inputNameOfRacingCars(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val nameOfRacingCars = readLine()!!
        require(nameOfRacingCars.isNotBlank()) { "입력값이 null 혹은 공백일 수 없습니다." }
        return splitNameOfCars(nameOfRacingCars)
    }

    fun inputRacingCarCount(): Int {
        println("자동차 대수는 몇 대인가요?")
        val racingCarCount = readLine()!!.toInt()
        require(racingCarCount > 0) { "0보다 큰 값만 입력 가능합니다." }
        return racingCarCount
    }

    fun inputRacingRound(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val round = readLine()!!.toInt()
        require(round > 0) { "0보다 큰 값만 입력 가능합니다." }
        return round
    }
}
