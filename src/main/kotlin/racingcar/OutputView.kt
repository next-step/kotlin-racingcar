package racingcar

class OutputView(private val carList: ArrayList<RacingCar.CarInformation>) {
    init {
        println("실행 결과...")
        carList.forEach {
            println("${it.carName}번 차 : ${it.carDistance}")
        }
    }
}
