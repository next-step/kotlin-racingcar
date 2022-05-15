package racingcar

object InputView {
    fun getCarCount(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readln().toIntOrNull() ?: throw IllegalArgumentException("올바른 정수로 입력해주세요. 이ㅏㅂㄹ")
    }

    fun getTryCount(): Int {
        println("시도할 회수는 몇 회인가요?")
        return 1
    }
}