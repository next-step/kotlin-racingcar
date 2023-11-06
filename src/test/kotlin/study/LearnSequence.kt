package study

import io.kotest.core.spec.style.StringSpec

class LearnSequence : StringSpec({
    """
        시퀀스
        - https://kotlinlang.org/docs/sequences.html
        
        ## 중간 연산과 최종 연산
        - Iterable(Java Stream) 과 같은점
          - Sequence 는 Collection API 에 들어있는 연산과 똑같은 함수를 가지고 있다
          - map 과 filter 와 같은 중간 연산은 새로운 시퀀스를 리턴한다.
          - 연산의 두가지 종류 중간 연산(intermediate operation)과 최종 연산(terminal operation)이라는 두가지로 나뉨
          - 최종연산은 Sequence 가 아닌 다른것을 리턴함 (예시 : first ,toList, forEach)
        - 차이점 (Kotlin Sequence)
          - 시퀀스는 최종연산 전까지 데이터를 처리하지 않음, 지연 평가를 함
        - 지연평과와 중간연산   
          - Java Stream 은 Iterable 기반 다단계 컬렉션 처리 인데,
            - Sequence 는 다단계 컬렉션 처리에 대한 또 다른 접근 방식임.
            - Iterable 은 여러 단계가 포함된 경우 해당 단계에서 열심히 매번 수행함 
            - 각 처리 단계는 그때 그때 완료 되고, 해당 결과(중간 컬렉션)를 반환함 
          - 반면에 Kotlin Sequence 는 
            - 다단계 처리 가능한건 같음
            - 지연연산으로 실행됩니다.
            - 실제 컴퓨팅은 전체 처리 체인의 결과가 요청될 때만(최종연산시에만) 발생
    """.trimIndent()

    "시퀀스를 Iterable 에서 만드는법" {
        val 그냥시퀀스로만들기: Sequence<String> = sequenceOf("four", "three", "two", "one")
        val list_에서_시퀀스로: Sequence<String> = listOf("one", "two", "three", "four").asSequence()
        println(그냥시퀀스로만들기)
        println(list_에서_시퀀스로)
    }

    "함수로 시퀀스 만들기" {
        val oddNumbers = generateSequence(1) { it + 2 } // `it` is the previous element
        println(oddNumbers.take(5).toList())
    }

    "시퀀스를 무한대로 만들수 있다" {
        println("주석을 풀고 실행하면 성공한다 = 즉 ArithmeticException 가 발생한다")
//        shouldThrow<ArithmeticException> {
//            val oddNumbers = generateSequence(1) { it + 2 } // `it` is the previous element
//            println(oddNumbers.count()) // error: the sequence is infinite
//        }
    }
    "10이하의 홀수를 생성하는 유한 시퀀스" {
        val oddNumbersLessThan10 = generateSequence(1) { if (it < 8) it + 2 else null }
        println("유한시퀀스를 생성한다 ${oddNumbersLessThan10.toList()}")
        println("갯수 = ${oddNumbersLessThan10.count()} 개 입니다 ")
    }

    "chunks 로 시퀀스 만들기" {
        """
        - 시퀀스 요소를 하나씩 또는 임의 크기의 덩어리로 생성할 수 있는 함수, 즉 함수가 있습니다 sequence(). yield()
              
            
        """.trimIndent()
        val oddNumbers = sequence {
            yield(1)
            yieldAll(listOf(3, 5))
            yieldAll(generateSequence(7) { it + 2 })
        }
        println(oddNumbers.take(5).toList())
    }

    "시퀀스의 yieldAll()" {
        """
        - yieldAll() 은 Iterable object 를 취할수 있다
        - yieldAll() 은 무한히 더 쓸수 있음(인수는 무한 할 수 있습니다)
            - Iterator, 
            - another Sequence
            - A Sequence argument 
        - 그러나 이러한 호출은 마지막 호출이어야 합니다. 모든 후속 호출은 실행되지 않습니다
          - However, such a call must be the last: all subsequent calls will never be executed.
        """.trimIndent()
    }

    "시퀀스 를 사용해야 하는 이유" {
        """
            (기존)Iterable 기반 : Java Stream API 같은거들은 즉시계산(eager) 해서 불필요한 연산이 많음
            Kotlin Sequence 기반 : 연산함수 그대로 다 쓸수 있는데, 지연계산(Lazy) 해서 최종연산으로 직행하기떄문에 계산량이 상대적으로 적음
        """.trimIndent()
    }
})
