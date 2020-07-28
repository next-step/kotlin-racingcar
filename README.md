# kotlin-racingcar

## Step4 - RacingCar Victory 
1. 구현할 기능 목록 정리 
2. 기능 구현 전, Test Case 미리 작성하기 (Review 내용)
    - ### TEST CASE 추가 항목
        - InputView - 입력 테스트 - 자동차 이름 5글자 초과 테스트 
        - Car - 자동차 이름 5글자 초과 테스트
        - Racing - 우승자 테스트 ( with Custom Engine )
            - 정상 1명 우승 
            - 중복 우승일 경우 
3. 자동차 입력 정보 변경 in InputView
    - 자동차 이름은 5글자를 초과하면 안된다.
    - 입력기준은 , 로 구분한다.
4. Car의 Name 필드 추가
5. 경주 출력시, name도 같이 출력 in ResultView 
6. Racing 우승 결과를 알려준다, 
    - 우승자는 한명 이상
7. depth 2 넘지 않게, 메소드 길이 15 이하로 리팩토링
    - 메소드는 단일 책임 원칙
8. TestCode 작성
