package racingCar

interface IInput {
    fun receiveCarCount():Int
    fun receiveTryCount():Int
}

class Input: IInput {
    override fun receiveCarCount(): Int {
        return readln().toInt()
    }

    override fun receiveTryCount(): Int {
        return readln().toInt()
    }
}