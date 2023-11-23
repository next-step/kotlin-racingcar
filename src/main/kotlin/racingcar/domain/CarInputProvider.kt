package racingcar.domain

interface CarInputProvider {
    fun getIntInput(prompt: String): Int

    fun getStringInput(prompt: String): List<String>
}
