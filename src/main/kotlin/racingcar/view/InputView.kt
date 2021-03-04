package racingcar.view

fun inputCountOfCar(): Int {
    println("자동차 대수는 몇 대인가요?")
    return readLine()?.toInt() ?: throw IllegalArgumentException()
}

fun inputCountOfRace(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return readLine()?.toInt() ?: throw IllegalArgumentException()
}
