package racingCar.view

class InputView {
    fun inputNumber() : Int {
        try {
            return readLine()!!.toInt()
        } catch (e: NullPointerException) {
            IllegalArgumentException("null이에욤!!!!!!")
        } catch (e: NumberFormatException) {
            IllegalArgumentException("이노옴~~~ 숫자만 입력해야지!!")
        } catch (e: Throwable) {
            IllegalArgumentException("Input Error")
        }
    }
}

