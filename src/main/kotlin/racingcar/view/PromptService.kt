package racingcar.view

interface PromptService {
    fun getNameOfCars(assignedNames: String? = null): List<String>
    fun getNumberOfMoves(assignedNumber: Int? = null): Int
    fun showResult(result: List<Map<String, Int>>)
}
