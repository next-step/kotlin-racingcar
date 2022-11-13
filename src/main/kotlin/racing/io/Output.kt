package racing.io

import racing.domain.CarInfo
import racing.domain.CarInfos
import racing.domain.Result
import racing.domain.Winners

object Output {
    private const val RESULT_MESSAGE = "실행 결과"
    private const val WINNER_MESSAGE = "가 최종 우승했습니다."

    fun resultMessage(result: Result) {
        println(RESULT_MESSAGE)
        println(ResultMaker.makeWholeResult(result))
    }

    private object ResultMaker {
        private const val MARK: String = "-"
        private const val LINE_BREAK: String = "\n"

        fun makeWholeResult(result: Result): String {
            val sb = StringBuilder()
            val carInfosPerRound: List<CarInfos> = result.carInfosList
            for (carInfos: CarInfos in carInfosPerRound) {
                makeRoundResult(carInfos, sb)
            }
            makeWinnerResult(result.winners, sb)
            return sb.toString()
        }

        private fun makeRoundResult(carInfos: CarInfos, sb: StringBuilder) {
            val carInfoList = carInfos.carInfoList
            for (carInfo: CarInfo in carInfoList) {
                makeCarResult(carInfo, sb)
            }
            sb.append(LINE_BREAK)
        }

        private fun makeCarResult(carInfo: CarInfo, sb: StringBuilder) {
            sb.append(carInfo.name.value).append(" : ")
            sb.append(MARK.repeat(carInfo.position.value))
            sb.append(LINE_BREAK)
        }

        private fun makeWinnerResult(winners: Winners, sb: StringBuilder) {
            for (winner in winners.winners) {
                sb.append(winner.name.value).append(", ")
            }
            sb.deleteRange(sb.length - 2, sb.length)
            sb.append(WINNER_MESSAGE)
        }
    }
}
