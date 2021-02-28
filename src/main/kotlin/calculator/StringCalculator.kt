package calculator

class StringCalculator(private val parsedToken: String = " ") {

    fun calculate(text: String?): Number {
        require(!text.isNullOrBlank())

        val expression = Expression()
        for (token in text.split(parsedToken)) {
            expression.addExpToken(token)
        }

        return expression.execute()
    }
}
