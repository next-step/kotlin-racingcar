package racingcar

interface Car {

    val carNumber: Long
    val position: Long
    val name: String

    fun drive()
}
