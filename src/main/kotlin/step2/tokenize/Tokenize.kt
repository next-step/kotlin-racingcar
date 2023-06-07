package step2.tokenize

interface Tokenize {
    operator fun invoke(equation: String, delimiter: String): List<String> {
        return equation.split(delimiter)
    }
}
