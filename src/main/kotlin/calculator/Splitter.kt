package calculator

class Splitter {
    fun split(input: String?, separator: String = " ", validation: (List<String>?) -> List<String>): List<String> {
        val values = input?.split(separator)
        return validation(values)
    }
}
