# 책 <스프링 부트3 백엔드 개발자 되기 - 자바편> 

스프링에대해 책도 읽고 실습해 볼 수 있는 책

---

## 경험1

* github 레포지토리에 민감정보가 저장되어 레포지토리를 삭제하고 싶었다
* 신규 레포지토리를 만들면 커밋-푸시가 되는 줄 알고 기존 레포지토리 바로 삭제..
* 신규레포지토리 주소 리모트 애드 했으나 커밋할게 없다고 자꾸 떳음..
* 구글링을 열심히 해도 안나왔었다(아니면 내가 잘 못찾는 걸 수도^^;;)
---
* git remote add origin https://github.com/songyoh/springboot3_study.git 일단 해주고
*  git remote -v 로 바뀐 레포지토리 주소 확인
* git push --set-upstream origin main 하게되면 바뀐 레포지토리 주소로 민감정보는 gitignore 되었고, 잘 업로드 되었다.

# 휴..!