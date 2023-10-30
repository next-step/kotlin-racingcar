package CarRacing.Service

interface MovementController {
    fun isMove(): Boolean

    /**
     * 구현체에 따라 툭정 조건에 따라 움직이는 칸 수를 조절할 수 있도록 getMoveCount 함수를 선언함.
     */
    fun getMoveCount(): Int
}
