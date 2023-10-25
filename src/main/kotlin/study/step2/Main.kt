package study.step2

fun main() {
    val mathExpression = View.printInputView()
    View.printResultView(Expression(mathExpression).processExpression())
}
