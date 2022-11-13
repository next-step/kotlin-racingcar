package racingCar.view

import racingCar.domain.Username

object InputView {

    fun number(): Int {
        try {
            return readLine()!!.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("입력값은 숫자여야 합니다.", e)
        } catch (e: NullPointerException) {
            throw IllegalArgumentException("입력값이 비어있습니다.", e)
        }
    }

    fun usernames(): List<Username> {
        TODO("Not yet implemented")
    }
}
