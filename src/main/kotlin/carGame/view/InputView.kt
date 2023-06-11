package carGame.view

object InputView {
    fun getCarCount(): Int {
        println("자동차의 대수는 몇 대 인가요?")
        val input = readln().toInt()
        require(input > 0) { "자동차 수는 0보다 커야합니다." }
        return input
    }

    fun getTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val input = readln().toInt()
        require(input > 0) { "시도 횟수는 0보다 커야합니다." }
        return input
    }
}
