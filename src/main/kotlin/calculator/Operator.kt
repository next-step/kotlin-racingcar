package calculator;

enum class Operator(val expression:String , val calculate :(Int,Int)->Int) {
    PLUS("+",{x,y->x+y}),
    MINUS("-",{x,y->x-y}),
    DIVIDE("/",{x,y->x/y}),
    MULTIPLY("*",{x,y->x*y});

    companion object {
        fun isOperator(operator: String): Boolean {
            return values().find { it.expression.equals(operator) } != null
        }

        fun valueOf(operator:String) :Operator? {
            return values().firstOrNull { it.expression.equals(operator) };
        }
    }


}
