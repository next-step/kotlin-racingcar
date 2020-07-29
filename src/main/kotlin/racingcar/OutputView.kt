package racingcar

object OutputView {
    fun printCurrentLocation(carList: ArrayList<RacingCar>) {
        println("-----------------------------------")
        carList.forEach {
            println("${it.carName}번 차 : ${it.carDistance}")
        }
    }
}
