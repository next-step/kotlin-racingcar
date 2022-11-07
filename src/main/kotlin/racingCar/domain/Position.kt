package racingCar.domain

class Position(val position:Int) {
    fun increase() :Position  = Position(position+1)

    constructor() :this(1)
}
