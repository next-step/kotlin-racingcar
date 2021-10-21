package racingCar.view

class CheckInputValue {
    fun isCarNameValid(list: List<String>): Boolean {
        list.forEach {
            if (it.length > LIMIT_NAME_LENGTH) {
                println(CAR_NAME_INPUT_WARNING)
                return false
            }
            if (it.isBlank()) {
                println(NOT_BLANK_NAME)
                return false
            }
        }
        return true
    }

    companion object {
        private const val LIMIT_NAME_LENGTH = 5
        private const val CAR_NAME_INPUT_WARNING = "자동차 이름은 $LIMIT_NAME_LENGTH 자를 초과할 수 없습니다."
        private const val NOT_BLANK_NAME = "이름에는 빈공간이 올 수 없고, ',' 뒤에는 이름이 들어가야합니다."
    }
}
