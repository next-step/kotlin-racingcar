interface CharTypeProcessStrategy {
    fun execute(scanner: StringCalculatorScanner, c: Char)
}

class NumberCharTypeProcessStrategy : CharTypeProcessStrategy {
    override fun execute(scanner: StringCalculatorScanner, c: Char) {
        if (scanner.operator == null)
            scanner.firstOperand += c

        if (scanner.firstOperand != "" && scanner.operator != null)
            scanner.secondOperand += c
    }
}

class BlankCharTypeProcessStrategy : CharTypeProcessStrategy {
    override fun execute(scanner: StringCalculatorScanner, c: Char) {
        scanner.operate()
    }
}

class OperatorCharTypeProcessStrategy : CharTypeProcessStrategy {
    override fun execute(scanner: StringCalculatorScanner, c: Char) {
        scanner.operator = c
    }
}
