package racingcar.view

import racingcar.domain.CarInfo
import racingcar.domain.Name

object InputView {

    private const val COMMA = ","
    private const val MAX_LENGTH = 5

    fun getCarInfo(): CarInfo {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return getNamesAndCount()
    }

    fun getTrialCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return getCount()
    }

    private fun getNamesAndCount(): CarInfo = readLine()?.split(COMMA)?.let { names ->
        CarInfo(
            names = names.map { name ->
                Name.of(name)
            },
            count = names.size
        )
    } ?: throw IllegalArgumentException("하나 이상의 자동차 이름을 입력해주세요.")

    private fun getCount(): Int = readLine()?.toIntOrNull()?.let {
        require(it > 0) { IllegalArgumentException("0보다 큰 수를 입력해주세요.") }
        it
    } ?: throw IllegalArgumentException("숫자를 입력해주세요.")
}
