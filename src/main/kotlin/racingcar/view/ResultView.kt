package racingcar.view

import racingcar.domain.CarInfo
import racingcar.domain.RoundHistory

class ResultView {
    companion object {
        fun printHistory(histories: List<RoundHistory>) {
            println("실행 결과")
            histories.forEach {
                printPositions(it.carInfos)
                println()
            }
        }

        private fun printPositions(carInfos: List<CarInfo>) {
            val info = StringBuilder()
            for (carInfo in carInfos) {
                info.append("${carInfo.name}: ${"-".repeat(carInfo.position)}\n")
            }

            print(info.toString())
        }
    }
}
