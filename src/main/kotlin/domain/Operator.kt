package domain

class Operator(val operatorList: ArrayList<String?>) {
    init {
        for (operator in operatorList) {
            checkOperatorValidation(operator)
        }
    }

    private fun checkOperatorValidation(input: String?) {
        ValidationChecker().checkNullAndBlankValidation(input)
        ValidationChecker().checkValidOperator(input)
    }
}
