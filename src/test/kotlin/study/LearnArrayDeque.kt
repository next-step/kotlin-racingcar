package study

import io.kotest.core.spec.style.StringSpec

class LearnArrayDeque : StringSpec({

    "ArrayDeque 를 생성해서 CRUD 해본다" {
        val arrayDeque = ArrayDeque<Int>()
        arrayDeque.add(1)
        arrayDeque.add(1)
        arrayDeque.add(2)
        arrayDeque.add(2)
        arrayDeque.add(3)
        println("1) 추가만 한 상태 $arrayDeque")

        val isSuccess = arrayDeque.remove(1)
        println("Removed element 결과가 리턴된다 : $isSuccess") // 출력: Removed element: 1
        println("2) 엘리먼트를 인덱스 몰라도 remove 하는 기능이 있다 \n $arrayDeque")

        arrayDeque.add(4)
        arrayDeque.add(5)
        println("3) 인덱스를 몇개 더 추가 하면 \n $arrayDeque")

        val topElement1 = arrayDeque.drop(1)
        val topElement2 = arrayDeque.drop(1)
        println("Popped element: $topElement1")
        println("Popped element: $topElement2")
        println("3) drop 메서드는 원본에 영향을 주지 않는다 \n $arrayDeque")

        arrayDeque.removeFirst()
        arrayDeque.removeLast()
        println("4) removeFirst와 removeLast 기능이 있다 코테에서 좋을꺼같다. 파이썬이 부럽지 않다 \n $arrayDeque")

        arrayDeque.removeAt(2)
        println("5) 인덱스 기준으로 원소 삭제는 removeAt 을 쓴다 \n $arrayDeque")
    }
})
