package study.racing.inputview

class CarNumberInputView : InputView<CarNumberInputView.RacingInputResult> {

    /**
     * readLine 을 사용하면 테스트하기가 까다롭다
     * readLine 대신에 생성자로 InputMethod 같은 입력을 받는 책임을 갖는 객체를 받아서
     * 해당 객체에서 결과를 반환하도록 하면 어떨까
     */
    override fun receive(): RacingInputResult {
        println("자동차 대수는 몇 대인가요?")
        val numOfCar = readln().toLong()
        println("시도할 횟수는 몇 회인가요?")
        val numOfAttempt = readln().toLong()
        return RacingInputResult(numOfCar, numOfAttempt)
    }

    data class RacingInputResult(
        val numOfCar: Long,
        val numOfAttempt: Long
    )
}
