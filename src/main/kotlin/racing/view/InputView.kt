package racing.view

object InputView {

    fun printInputCarNames(): String {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼포(,)를 기준으로 구분).")
        return readlnOrNull() ?: throw IllegalArgumentException("입력 값은 null 값이 올 수 없습니다")
    }

    fun printInputCar(): Int {
        println("자동차 대수는 몇 대 인가요?")
        return readlnOrNull()?.toInt() ?: throw IllegalArgumentException("입력 값은 null 값이 올 수 없습니다")
    }

    fun printInputCount(): Int {
        println("시도할 횟수는 몇 회 인가요?")
        return readlnOrNull()?.toInt() ?: throw IllegalArgumentException("입력 값은 null 값이 올 수 없습니다")
    }
}
