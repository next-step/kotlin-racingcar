package calculator

class StringCalculator {

    fun calculate(input: String?): Int {
        val inputString: String = validate(input)
        return -1
    }

    private fun validate(input: String?): String {
        assertNotNull(input)
        assertNotEmpty(input)

        return input!!
    }

    private fun assertNotEmpty(input: String?) {
        TODO("Not yet implemented")
    }

    private fun assertNotNull(input: String?) {
        TODO("Not yet implemented")
    }
}
