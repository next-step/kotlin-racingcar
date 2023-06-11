package study.step3.veiw

interface InputView {

    fun receive(): RacingInputResult

    data class RacingInputResult(
        val numOfCar: Long,
        val numOfAttempt: Long
    )
}
