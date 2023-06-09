package step3.view

object InputView {
    fun getCarCount(): Int {
        println("자동차의 대수는 몇 대 인가요?")
        return readln().toInt()
    }

    fun getTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }
}
