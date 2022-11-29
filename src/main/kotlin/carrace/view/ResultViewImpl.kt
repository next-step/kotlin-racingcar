package carrace.view

import carrace.logic.car.CarInfos

object ResultViewImpl : ResultView {

    override fun displayGameResult(gameLog: List<CarInfos>) {
        println("실행 결과")
        gameLog.forEach { carInfos ->
            carInfos.carInfos.forEach { carInfo ->
                println("${carInfo.carName.name} : " + "-".repeat(carInfo.carPosition.position + 1))
            }
            println()
        }
    }

    override fun displayWinner(winnersInfos: CarInfos) {
        println(
            "${winnersInfos.carInfos.joinToString { winnerInfo ->
                winnerInfo.carName.name
            }}가 최종 우승했습니다."
        )
    }
}
