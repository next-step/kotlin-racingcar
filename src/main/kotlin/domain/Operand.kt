package domain

class Operand(val operandList: ArrayList<Double>) {
    init {
        for (operand in operandList) {
            checkOperandValidation(operand.toString())
        }
    }

    private fun checkOperandValidation(input: String?) {
        ValidationChecker().checkNullAndBlankValidation(input)
        ValidationChecker().checkValidNumber(input)
    }
}
