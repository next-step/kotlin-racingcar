package study.step2

/**
 * Utility functions for the simple calculator
 *
 * @author jutaeKim
 */

/**
 * Validate the string is a number (double value)
 *
 * @return true / false
 */
fun String.isDouble() = try {
    this.toDouble(); true
} catch (e: NumberFormatException) {
    false
}

/**
 *  Validate the string is an operator
 *
 *  @return ture when this is one of ["+","-","/" ,"*"] , otherwise false
 */
fun String.isOperator() = this.length == 1 && "+-/*".contains(this[0])
