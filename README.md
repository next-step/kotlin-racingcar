# kotlin-racingcar 기능목록

1. Car: 자동차 정보를 담고 있는 클래스
    1. name: String - 입력받은 자동차 이름
    2. position: Int - 현재 자동차의 위치

2. WinnerCarRacingView: 화면을 보여주는 클래스

    1. 사용자의 입력값을 받는 메소드 (input : String)
        1. 입력받은 자동차 이름들 파싱 - return Car[]
        2. 입력받은 횟수를 숫자로 변 - return Int
    
    2. 사용자 입력값 유효성을 체크하는 메소드 (input : String)
        1. 자동차 이름이 없거나 null 인 경우
        2. 자동차 이름에 영문, "," 외의 문자열이 포함될 경
        3. 자동차 이름이 다섯글자 초과인 경우
        4. 시도 횟수가 없거나 null 인 경우
        5. 시도 횟수가 1보다 작을 경우
        6. 시도 횟수가 숫자가 아닌 경우
        7. 글자 마지막에 ","가 있는 경우
                
    3. 사용자에게 화면에 보여줄 내용을 출력하는 메소드
        1. 사용자에게 보여줄 안내문구 출력 
        2. 시도 횟수 당 보여주는 자동차 이동
        3. 자동차 경주의 결과를 보여주는 메소드 
         
          
3.  wk1_step4: 자동차 경주를 하는 비지니스 로직 클래스
    1. 자동차가 이동할 것인지 멈출 것인지 결정하는 메소드

4. 결과는 main 함수에서 호출

---
# 프로그램 요구사항
1. 각 기능 구현시, 단위 테스트 구현할 것
2. 들여쓰기는 최대 1
3. 함수의 길이는 최대 14라인




    