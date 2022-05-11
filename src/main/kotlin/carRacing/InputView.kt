package carRacing

object InputView {

    fun numCar(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readln().toIntOrNull() ?: throw IllegalArgumentException()
    }

    fun numMovement(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toIntOrNull() ?: throw IllegalArgumentException()
    }
}
