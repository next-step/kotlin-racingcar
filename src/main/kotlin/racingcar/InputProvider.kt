package racingcar

interface InputProvider {
    fun getIntInput(prompt: String): Int

    fun getStringInput(prompt: String): List<String>
}
