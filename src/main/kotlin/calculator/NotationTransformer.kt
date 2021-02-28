package calculator

interface NotationTransformer {
    fun transform(line: String): List<Word>
}
