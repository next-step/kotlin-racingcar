class InputView {

    var carNumber = 0
    var actionCount = 0

    fun doInput() {
        println("자동차 대수는 몇 대인가요?")
        runCatching {
            carNumber = readlnOrNull()?.toInt()?:0
        }.getOrElse {
            throw NumberFormatException("숫자 입력해야함")
        }
        if(carNumber < 1) {
            throw IllegalArgumentException("자동차 대수는 1대 이상이어야 함")
        }
        println("시도할 횟수는 몇 회인가요?")
        runCatching {
            actionCount = readlnOrNull()?.toInt()?:0
        }.getOrElse {
            throw NumberFormatException("숫자 입력해야함")
        }
        if(carNumber < 1) {
            throw IllegalArgumentException("시도할 횟수는 1회 이상이어야 함")
        }
    }
}