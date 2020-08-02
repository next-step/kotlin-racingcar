package model

interface DiceStatus {
    fun dice(): Int
    fun isSuccess(): Boolean
}
