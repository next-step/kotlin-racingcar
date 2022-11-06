package step2.calculator.system.component

object ComponentConverter {

    fun convert(input: String): Component {
        return if (Numeric.isNumeric(input)) {
            Numeric.from(input)
        } else if (LazyFunction.isLazyFunction(input)) {
            LazyFunction.from(input)
        } else {
            throw IllegalArgumentException("계산기에서 지원하는 기능이 아닙니다 : $input ")
        }
    }
}
