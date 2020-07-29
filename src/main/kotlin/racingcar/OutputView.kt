package racingcar

object OutputView {
    fun printCurrentLocation(carList: List<RacingCar>) {
        println("-----------------------------------")
        carList.forEach {
            println("${it.carName}번 차 : ${convertDistance(it.carDistance)}")
        }
    }

    fun convertDistance(count: Int): String {
        var returnString = StringBuffer("")
        for (distance in 1..count) {
            returnString.append("-")
        }
        return returnString.toString()
    }
}
