
# 借书管理
## 借书

**URL:** `/borrow`

**Type:** `POST`


**Content-Type:** `application/json`

**Description:** 借书




**Body-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|id|int32|false|书籍id|-|
|bookName|string|false|书名|-|
|bookAuthor|string|false|书籍作者|-|
|bookPublish|string|false|书籍出版社|-|
|state|string|false|借阅状态|-|

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json' -i /borrow --data '{
  "id": 493,
  "bookName": "jim.kub",
  "bookAuthor": "Mario VonRueden",
  "bookPublish": "6tvw35",
  "state": "jbvc71"
}'
```

**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|code|int32|返回码|-|
|message|string|返回信息|-|
|data|object|返回数据|-|

**Response-example:**
```
{
  "code": 992,
  "message": "success",
  "data": {}
}
```

## 还书

**URL:** `/borrow`

**Type:** `PUT`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 还书



**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|bookId|int32|true|书籍id|-|


**Request-example:**
```
curl -X PUT -i /borrow --data 'bookId=499'
```

**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|code|int32|返回码|-|
|message|string|返回信息|-|
|data|object|返回数据|-|

**Response-example:**
```
{
  "code": 455,
  "message": "success",
  "data": {}
}
```

## 查询用户个人的借书记录

**URL:** `/borrow/user`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 查询用户个人的借书记录



**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|pageNum|int32|true| 页码|-|
|pageSize|int32|true|显示条数|-|


**Request-example:**
```
curl -X GET -i /borrow/user?pageNum=461&pageSize=10 --data '&461&10'
```

**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|code|int32|返回码|-|
|message|string|返回信息|-|
|data|array|返回数据|-|
|└─userName|string|借阅者用户名|-|
|└─bookName|string|书籍名称|-|
|└─borrowDate|string|借阅日期|-|
|└─returnDate|string|书籍归还日期|-|

**Response-example:**
```
{
  "code": 927,
  "message": "success",
  "data": [
    {
      "userName": "jim.kub",
      "bookName": "jim.kub",
      "borrowDate": "2023-02-14",
      "returnDate": "2023-02-14"
    }
  ]
}
```

## 查询所有人历史借阅记录

**URL:** `/borrow/admin`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 查询所有人历史借阅记录



**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|pageNum|int32|true|页码|-|
|pageSize|int32|true|显示条数|-|


**Request-example:**
```
curl -X GET -i /borrow/admin?pageNum=853&pageSize=10 --data '&853&10'
```

**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|code|int32|返回码|-|
|message|string|返回信息|-|
|data|array|返回数据|-|
|└─userName|string|借阅者用户名|-|
|└─bookName|string|书籍名称|-|
|└─borrowDate|string|借阅日期|-|
|└─returnDate|string|书籍归还日期|-|

**Response-example:**
```
{
  "code": 438,
  "message": "success",
  "data": [
    {
      "userName": "jim.kub",
      "bookName": "jim.kub",
      "borrowDate": "2023-02-14",
      "returnDate": "2023-02-14"
    }
  ]
}
```

