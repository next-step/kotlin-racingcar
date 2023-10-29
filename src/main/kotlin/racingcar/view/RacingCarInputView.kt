package racingcar.view

object RacingCarInputView {
    private const val NAME_DELIMITER = ","

    fun readInput(): RacingCarInputDto {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNames = readln().split(NAME_DELIMITER)

        println("시도할 횟수는 몇 회인가요?")
        val totalRound = readln().toInt()

        return RacingCarInputDto(
            carNames = carNames,
            totalRound = totalRound,
        )
    }
}
