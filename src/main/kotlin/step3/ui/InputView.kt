package step3.ui

import java.util.*

/**
 *
 * @author Leo
 */
class InputView {

    private val scanner = Scanner(System.`in`)

    fun getParticipantCount(): Int {
        println("자동차 대수는 몇 대인가요?")
        return scanner.nextInt()
    }

    fun getTotalCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return scanner.nextInt()
    }

}
