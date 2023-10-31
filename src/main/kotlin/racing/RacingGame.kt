package racing

import racing.car.CarManager

fun main() {
    val racing: Racing

    println("자동차 대수는 몇 대인가요?")
    val inputCarCnt = readln()

    println("시도할 횟수는 몇 회인가요?")
    val inputRacingCnt = readln()

    Validate.validateInputData(inputCarCnt, inputRacingCnt)

    CarManager.createCarList(inputCarCnt.toInt())
    racing = Racing(inputRacingCnt.toInt())
    racing.startRacing()

    RacingResult().showRacingResult(racing.getRacingResultList())
}
