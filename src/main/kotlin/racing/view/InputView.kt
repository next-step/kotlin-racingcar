package racing.view

class InputView {

    companion object {
        fun printInputCar(): Int {
            println("자동차 대수는 몇 대 인가요?")
            return readlnOrNull()?.toInt() ?: throw IllegalArgumentException("입력 값은 null 값이 올 수 없습니다")
        }

        fun printInputCount(): Int {
            println("시도할 횟수는 몇 회 인가요?")
            return readlnOrNull()?.toInt() ?: throw IllegalArgumentException("입력 값은 null 값이 올 수 없습니다")
        }
    }
}
