package racing

import racing.car.CarManager

fun main() {
    val carManager = CarManager()
    val racing = Racing()

    println("자동차 대수는 몇 대인가요?")
    val inputCarCnt = readln()

    println("시도할 횟수는 몇 회인가요?")
    val inputRacingCnt = readln()

    carManager.validateInputData(inputCarCnt)
    carManager.createCarList(inputCarCnt.toInt())

    racing.validateInputData(inputRacingCnt)
    racing.startRacing(inputRacingCnt.toInt())

    RacingResult().showRacingResult(racing.getRacingResultList())
}
