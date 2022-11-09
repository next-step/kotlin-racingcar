package step2.calculator.system.component

enum class ComponentConverter {
    NUMERIC {
        override fun mapping(input: String): Numeric? {
            return if (Numeric.isNumeric(input)) Numeric.from(input) else null
        }
    },
    LAZY_FUNCTION {
        override fun mapping(input: String): LazyFunction? {
            return if (LazyFunction.isLazyFunction(input)) LazyFunction.from(input) else null
        }
    }
    ;
    abstract fun mapping(input: String): Component?

    companion object {
        fun convert(input: String): Component {
            return values().firstNotNullOfOrNull { it.mapping(input) }
                ?: throw IllegalArgumentException("계산기에서 지원하는 기능이 아닙니다 : $input")
        }
    }
}
