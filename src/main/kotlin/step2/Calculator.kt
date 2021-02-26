package step2

fun main() {
    val inputManager = InputManager()
    val fomulaList = inputManager.convertFormulaToList(readLine())
    println(fomulaList.toString())
}
