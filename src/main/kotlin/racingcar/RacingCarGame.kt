package racingcar

fun main() {
    println("자동차 대수는 몇 대인가요?")
    val carCount = readln().toIntOrNull() ?: throw IllegalArgumentException("1 이상의 정수로 입력해주세요.")
    println("시도할 회수는 몇 회인가요?")
    val tryCount = readln().toIntOrNull() ?: throw IllegalArgumentException("1 이상의 정수로 입력해주세요.")

    println("\n실행 결과")
    val driverList = List(carCount) { Driver(Car()) }

    repeat(tryCount) {
        driverList.forEach {
            val isMovable = (1..9).random() > 4
            it.drive(isMovable)

            println(it.getMoveResult())
        }
        println("")
    }
}