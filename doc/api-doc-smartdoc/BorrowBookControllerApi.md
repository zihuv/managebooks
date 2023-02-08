
# 借书管理
## 借书

**URL:** `/borrow`

**Type:** `POST`


**Content-Type:** `application/json`

**Description:** 借书




**Body-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|id|int32|true|书籍id|-|
|bookName|string|false|书名|-|
|bookAuthor|string|false|书籍作者|-|
|bookPublish|string|false|书籍出版社|-|
|state|string|true|借阅状态|-|

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json' -i /borrow --data '{
  "id": 357,
  "bookName": "kacy.grady",
  "bookAuthor": "Walker Kerluke",
  "bookPublish": "7cl1qg",
  "state": "lrxoc1"
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
  "code": 800,
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
curl -X PUT -i /borrow --data 'bookId=694'
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
  "code": 120,
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
curl -X GET -i /borrow/user?pageNum=171&pageSize=10 --data '&171&10'
```

**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|code|int32|返回码|-|
|message|string|返回信息|-|
|data|array|返回数据|-|
|└─userName|string|No comments found.|-|
|└─bookName|string|No comments found.|-|
|└─borrowDate|string|No comments found.|-|
|└─returnDate|string|No comments found.|-|

**Response-example:**
```
{
  "code": 106,
  "message": "success",
  "data": [
    {
      "userName": "kacy.grady",
      "bookName": "kacy.grady",
      "borrowDate": "2023-02-08",
      "returnDate": "2023-02-08"
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
curl -X GET -i /borrow/admin?pageNum=708&pageSize=10 --data '&708&10'
```

**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|code|int32|返回码|-|
|message|string|返回信息|-|
|data|array|返回数据|-|
|└─userName|string|No comments found.|-|
|└─bookName|string|No comments found.|-|
|└─borrowDate|string|No comments found.|-|
|└─returnDate|string|No comments found.|-|

**Response-example:**
```
{
  "code": 989,
  "message": "success",
  "data": [
    {
      "userName": "kacy.grady",
      "bookName": "kacy.grady",
      "borrowDate": "2023-02-08",
      "returnDate": "2023-02-08"
    }
  ]
}
```

