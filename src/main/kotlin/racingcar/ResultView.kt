package racingcar

import java.util.LinkedList
import java.util.Queue

object ResultView {
    private const val ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val ASK_HOW_MANY_TRY = "시도할 횟수는 몇 회인가요?"
    private const val PROCESS_RESULT = "실행결과"
    private const val SUFFIX_WINNER_ANNOUNCE = "가 최종 우승했습니다."
    private const val DIVIDER = "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"

    fun printResult(lapResultList: List<LapResult>) {
        println(DIVIDER)
        printLapResultList(lapResultList)
        println(DIVIDER)
    }

    fun printWinners(winnerList: List<String>) =
        println(createWinnerAnnounceMessage(winnerList))

    fun printProcessResultTitle() = println(PROCESS_RESULT)

    fun printAskHowManyCars() = println(ASK_CAR_NAMES)

    fun printAskHowManyTry() = println(ASK_HOW_MANY_TRY)

    private fun createWinnerAnnounceMessage(winnerList: List<String>): String {
        val sb = StringBuffer()
        val winnerNameQueue = LinkedList(winnerList) as Queue<String>

        sb.append(winnerNameQueue.poll())
        repeat(winnerNameQueue.size) {
            sb.append(", ${winnerNameQueue.poll()}")
        }
        sb.append(SUFFIX_WINNER_ANNOUNCE)
        return sb.toString()
    }

    private fun printLapResultList(lapResultList: List<LapResult>) {
        lapResultList.forEach {
            printLapResult(it)
        }
    }

    private fun printLapResult(lapResult: LapResult) {
        with(lapResult) {
            println("$carName : ${getMovedDistanceExpression(movedDistance)}")
        }
    }

    private fun getMovedDistanceExpression(distance: Int) = "-".repeat(distance)
}
