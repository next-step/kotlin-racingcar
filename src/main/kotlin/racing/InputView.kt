package racing

class InputView {

    fun input(): RacingState {
        println("자동차 수를 입력하세요")
        val number = readLine()

        println("이동 횟수를 입력하세요")
        val attempt = readLine()

        return RacingState(number, attempt)
    }
}
