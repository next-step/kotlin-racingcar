package racingCar.view

object InputView {

    fun getNumber(): Int {
        try {
            return readLine()!!.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("입력값은 숫자여야 합니다.", e)
        } catch (e: NullPointerException) {
            throw IllegalArgumentException("입력값이 비어있습니다.", e)
        }
    }
}
