package racingcar

object InputView {

    fun inputHowManyCar(): Int {
        return try {
            println("자동차 대수는 몇 대인가요?")
            return readln().toInt()
        } catch (e: NumberFormatException) {
            println("숫자를 입력해주세요.")
            inputHowManyCar()
        }
    }

    fun inputOperationCar(): Int {
        return try {
            println("시도할 횟수는 몇 회인가요?")
            return readln().toInt()
        } catch (e: NumberFormatException) {
            println("숫자를 입력해주세요.")
            inputOperationCar()
        }
    }
}
