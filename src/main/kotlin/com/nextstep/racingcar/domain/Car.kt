package com.nextstep.racingcar.domain

class Car(private val name: String) {
    var position: Int = 0
        private set

    constructor(name: String, position: Int) : this(name) {
        this.position = position
    }

    init {
        validation(name)
    }

    private fun validation(name: String) {
        if (name.isEmpty() || name.length > MAX_NAME_LENGTH) {
            throw IllegalArgumentException("이름은 1자 이상 5지 이하여야합니다.")
        }
    }

    fun move(randomNumber: Int) {
        if (randomNumber.movable()) {
            position++
        }
    }

    fun getName(): String = name

    private fun Int.movable(): Boolean {
        return this >= MIN_MOVABLE_NUMBER
    }

    fun isMatchedPosition(maxPosition: Int): Boolean {
        return position == maxPosition
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        if (name != other.name) return false
        if (position != other.position) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + position
        return result
    }

    companion object {
        const val MIN_MOVABLE_NUMBER = 4
        const val MAX_NAME_LENGTH = 5
    }
}
