package study.step3.inputview

interface InputView {

    fun receive(): RacingInputResult

    data class RacingInputResult(
        val numOfCar: Long,
        val numOfAttempt: Long
    )
}
