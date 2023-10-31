package carRacing

object InputRule {

    private fun <T> validate(list: List<T>, condition: (param: T) -> Boolean, errorString: String): List<T> {
        if (!list.all { condition(it) }) {
            throw IllegalArgumentException(errorString)
        }
        return list
    }

    val validateCarNames = { carNames: List<String> ->
        validate(carNames, { it.length < 6 }, "자동차 이름은 5자를 초과할 수 없습니다")
    }

}
