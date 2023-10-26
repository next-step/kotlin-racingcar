package racingCar.view

// private const val을 사용하려고 object로 선언 했는데 정확하게 어떨 떄 object or class로 선언해야하는지 궁금
object OutputView {

    private const val ASK_CAR_COUNT = "자동차 대수는 몇 대인가요?"
    private const val ASK_TRY_COUNT = "시도할 횟수는 몇 회인가요?"

    fun printCarCount() = println(ASK_CAR_COUNT)
    fun printTryCount() = println(ASK_TRY_COUNT)
}
