package step3.racingcar

object InputView {

    fun carCount(): Int {
        println("자동차 대수는 몇 대 인가요?")
        return readLine()?.toInt() ?: throw IllegalArgumentException("차량 갯수를 입력해주세요")
    }

    fun movementCount(): Int {
        println("시도할 횟수는 몇 회 인가요?")
        return readLine()?.toInt() ?: throw IllegalArgumentException("차량 이동 횟수를 입력해주세요")
    }
}
