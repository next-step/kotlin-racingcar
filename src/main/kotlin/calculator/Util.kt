package calculator

class Util {
    companion object {
        fun groupByIsNumber(inputs: List<String>, bool: Boolean): List<String> {
            return inputs.groupBy { (it.toFloatOrNull() != null) }[bool]!!
        }
    }
}
