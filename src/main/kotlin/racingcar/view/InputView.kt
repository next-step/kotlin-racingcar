package racingcar.view

object InputView {
    fun getCarCount(): Int {
        println("자동차 대수는 몇 대 인가요?")
        return readln().toInt()
    }

    fun getRacingCount(): Int {
        println("경주 횟수는 몇 대 인가요?")
        return readln().toInt()
    }
}