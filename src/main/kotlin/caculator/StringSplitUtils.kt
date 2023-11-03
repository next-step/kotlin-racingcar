package caculator

class StringSplitUtils {
    companion object {
        fun split(input: String?): List<String> {
            require(input != null) { throw IllegalArgumentException("Input cannot be null") }
            return input.split(" ")
        }
    }
}
