package calculator

interface SeparationStrategy {
    fun separate(input: String): List<String>
}