package step3

class ManualCarMover : CarMover {

    /**
     * 우선 무조건 움직일 수 있도록
     */
    override fun movable(): Boolean {
        return true
    }
}