package racing

import racing.car.CarManager
import racing.rule.Rule

fun main() {
    val rule = Rule()
    val carManager = CarManager(rule)
    val racing = Racing(carManager)

    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    val inputCarNames = readln()

    println("시도할 횟수는 몇 회인가요?")
    val inputRacingCnt = readln()

    carManager.validateInputData(inputCarNames)
    carManager.createCarList(inputCarNames)

    // racing 횟수는 main에서 가지고 있어야한다.
    racing.validateInputData(inputRacingCnt)
    racing.startRacing(inputRacingCnt.toInt())

    RacingResult().showRacingResult(racing.getRacingResultList())
}
