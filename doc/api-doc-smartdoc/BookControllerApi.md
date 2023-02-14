
# 书籍管理
## 添加书籍

**URL:** `/book`

**Type:** `POST`


**Content-Type:** `application/json`

**Description:** 添加书籍




**Body-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|bookName|string|false|书籍名称|-|
|bookAuthor|string|false|书籍作者|-|
|bookPublish|string|false|书籍出版社|-|
|bookCategory|int32|false|书籍类别|-|
|bookPrize|double|false|书籍价格|-|
|bookIntroduction|string|false|书籍介绍|-|

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json' -i /book --data '{
  "bookName": "jim.kub",
  "bookAuthor": "Mario VonRueden",
  "bookPublish": "6ds26k",
  "bookCategory": 175,
  "bookPrize": 65.00,
  "bookIntroduction": "5kixsh"
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
  "code": 533,
  "message": "success",
  "data": {}
}
```

## 删除书籍

**URL:** `/book/{id}`

**Type:** `DELETE`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 删除书籍


**Path-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|id|int32|true|书籍id|-|



**Request-example:**
```
curl -X DELETE -i /book/429
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
  "code": 168,
  "message": "success",
  "data": {}
}
```

## 修改书籍信息

**URL:** `/book`

**Type:** `PUT`


**Content-Type:** `application/json`

**Description:** 修改书籍信息




**Body-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|bookName|string|false|书籍名称|-|
|bookAuthor|string|false|书籍作者|-|
|bookPublish|string|false|书籍出版社|-|
|bookCategory|int32|false|书籍类别|-|
|bookPrize|double|false|书籍价格|-|
|bookIntroduction|string|false|书籍介绍|-|

**Request-example:**
```
curl -X PUT -H 'Content-Type: application/json' -i /book --data '{
  "bookName": "jim.kub",
  "bookAuthor": "Mario VonRueden",
  "bookPublish": "pxyvia",
  "bookCategory": 387,
  "bookPrize": 35.76,
  "bookIntroduction": "le1rmf"
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
  "code": 522,
  "message": "success",
  "data": {}
}
```

## 查询所有书籍

**URL:** `/book/list`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 查询所有书籍



**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|pageNum|int32|true|页码|-|
|pageSize|int32|true|显示条数|-|


**Request-example:**
```
curl -X GET -i /book/list?pageNum=679&pageSize=10 --data '&679&10'
```

**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|code|int32|返回码|-|
|message|string|返回信息|-|
|data|array|返回数据|-|
|└─id|int32|书籍id|-|
|└─bookName|string|书名|-|
|└─bookAuthor|string|书籍作者|-|
|└─bookPublish|string|书籍出版社|-|
|└─state|string|借阅状态|-|

**Response-example:**
```
{
  "code": 943,
  "message": "success",
  "data": [
    {
      "id": 308,
      "bookName": "jim.kub",
      "bookAuthor": "Mario VonRueden",
      "bookPublish": "hzafxk",
      "state": "1ee4kz"
    }
  ]
}
```

## 根据id查询书籍

**URL:** `/book/{id}`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 根据id查询书籍


**Path-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|id|int32|true|书籍id|-|



**Request-example:**
```
curl -X GET -i /book/534
```

**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|code|int32|返回码|-|
|message|string|返回信息|-|
|data|object|返回数据|-|
|└─id|int32|书籍id|-|
|└─bookName|string|书名|-|
|└─bookAuthor|string|书籍作者|-|
|└─bookPublish|string|书籍出版社|-|
|└─state|string|借阅状态|-|

**Response-example:**
```
{
  "code": 410,
  "message": "success",
  "data": {
    "id": 843,
    "bookName": "jim.kub",
    "bookAuthor": "Mario VonRueden",
    "bookPublish": "yeq5fp",
    "state": "pchpem"
  }
}
```

## 根据书名查询书籍

**URL:** `/book`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 根据书名查询书籍



**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|bookName|string|true|书籍名称|-|
|pageNum|int32|true|No comments found.|-|
|pageSize|int32|true|No comments found.|-|


**Request-example:**
```
curl -X GET -i /book?bookName=jim.kub&pageNum=821&pageSize=10 --data '&jim.kub&821&10'
```

**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|code|int32|返回码|-|
|message|string|返回信息|-|
|data|array|返回数据|-|
|└─id|int32|书籍id|-|
|└─bookName|string|书名|-|
|└─bookAuthor|string|书籍作者|-|
|└─bookPublish|string|书籍出版社|-|
|└─state|string|借阅状态|-|

**Response-example:**
```
{
  "code": 782,
  "message": "success",
  "data": [
    {
      "id": 215,
      "bookName": "jim.kub",
      "bookAuthor": "Mario VonRueden",
      "bookPublish": "17z4fl",
      "state": "88ai33"
    }
  ]
}
```

## 根据书籍类别查询书籍

**URL:** `/book/category`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 根据书籍类别查询书籍



**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|categoryName|string|true|类别名称|-|
|pageNum|int32|true|     页码|-|
|pageSize|int32|true|No comments found.|-|


**Request-example:**
```
curl -X GET -i /book/category?categoryName=jim.kub&pageNum=408&pageSize=10 --data '&jim.kub&408&10'
```

**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|code|int32|返回码|-|
|message|string|返回信息|-|
|data|array|返回数据|-|
|└─id|int32|书籍id|-|
|└─bookName|string|书名|-|
|└─bookAuthor|string|书籍作者|-|
|└─bookPublish|string|书籍出版社|-|
|└─state|string|借阅状态|-|

**Response-example:**
```
{
  "code": 217,
  "message": "success",
  "data": [
    {
      "id": 832,
      "bookName": "jim.kub",
      "bookAuthor": "Mario VonRueden",
      "bookPublish": "vhe4ke",
      "state": "b8u8xx"
    }
  ]
}
```

