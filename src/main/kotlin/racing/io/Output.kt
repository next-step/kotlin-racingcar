package racing.io

import racing.domain.CarInfo
import racing.domain.CarInfos
import racing.domain.Result

object Output {
    private const val RESULT_MESSAGE = "실행 결과"

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
    }
}
