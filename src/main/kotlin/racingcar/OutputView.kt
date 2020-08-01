package racingcar

fun printWinner(carList: List<RacingCar>) {
    println("${carList.joinToString { it.carName }}가 우승입니다.")
}

fun printCurrentLocation(carList: List<RacingCar>) {
    println("-----------------------------------")
    carList.forEach {
        println("${it.carName}번 차 : ${convertDistance(it.carDistance)}")
    }
}

private fun convertDistance(count: Int): String {
    return "-".repeat(count)
}
