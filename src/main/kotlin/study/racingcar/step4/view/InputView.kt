package study.racingcar.step4.view

import study.racingcar.step4.utils.IntUtil
import study.racingcar.step4.utils.StringUtil

class InputView {

    private val SEPARATOR_COMMA = ","

    fun inputCarNameList(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return StringUtil.splitToListString(readLine(), SEPARATOR_COMMA)
    }

    fun inputRunCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return IntUtil.convertToInt(readLine())
    }
}
