package racingCar.domain

class CarMustMove : CarMovable {

    /**
     * 우선 무조건 움직일 수 있도록
     */
    override fun movable(): Boolean {
        return true
    }
}