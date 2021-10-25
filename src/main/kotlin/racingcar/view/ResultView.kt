package racingcar.view

import java.util.LinkedList
import java.util.Queue

object ResultView {
    private const val ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val ASK_HOW_MANY_TRY = "시도할 횟수는 몇 회인가요?"
    private const val PROCESS_RESULT = "실행결과"
    private const val SUFFIX_WINNER_ANNOUNCE = "가 최종 우승했습니다."
    private const val DIVIDER = "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"

    fun printWinners(winnerList: List<String>) =
        println(createWinnerAnnounceMessage(winnerList))

    fun printProcessResultTitle() = println(PROCESS_RESULT)

    fun printAskHowManyCars() = println(ASK_CAR_NAMES)

    fun printAskHowManyTry() = println(ASK_HOW_MANY_TRY)

    fun printRaceResult(raceResult: List<String>) = raceResult.forEach { printResult(it) }

    private fun printResult(lapResultList: String) {
        println(DIVIDER)
        println(lapResultList)
        println(DIVIDER)
    }

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
}
