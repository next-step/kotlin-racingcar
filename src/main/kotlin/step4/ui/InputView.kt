package step4.ui

import step4.domain.CarName
import java.util.Scanner

/**
 *
 * @author Leo
 */
class InputView {

    private val scanner = Scanner(System.`in`)

    fun getParticipantNames(): List<CarName> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val names = scanner.nextLine().toString().split(",")
        return names.map { CarName(it) }
    }

    fun getTotalCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return scanner.nextInt()
    }
}
