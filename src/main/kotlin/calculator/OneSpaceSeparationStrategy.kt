package calculator

class OneSpaceSeparationStrategy : SeparationStrategy {

    override fun separate(input: String): List<String> {
        return input.split(SEPARATOR)
    }

    companion object {
        const val SEPARATOR = " "
    }
}
