package step2

class ChunkTokenCalculator : TokenCalculator {

    override fun calculate(tokens: List<Token>): Int {
        val (firstToken: Token, restTokens: List<Token>) = head(tokens)
        val firstOperandNumber = firstToken.getOperandNumber()
        return restTokens
            .chunked(2)
            .fold(firstOperandNumber) { acc, tokens ->
                val operatorToken = tokens[0]
                val operandToken = tokens[1]
                val operatorFunction = OperatorFunction.get(operatorSign = operatorToken.getOperatorSign())
                operatorFunction(acc, operandToken.getOperandNumber())
            }
    }
}
