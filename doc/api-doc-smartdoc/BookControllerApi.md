
# 书籍管理
## 添加书籍

**URL:** `/book`

**Type:** `POST`


**Content-Type:** `application/json`

**Description:** 添加书籍




**Body-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|id|int32|true|书籍id|-|
|bookName|string|true|书籍名称|-|
|bookAuthor|string|true|书籍作者|-|
|bookPublish|string|true|书籍出版社|-|
|bookCategory|int32|true|书籍类别|-|
|bookPrize|double|true|书籍价格|-|
|bookIntroduction|string|true|书籍介绍|-|

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json' -i /book --data '{
  "id": 780,
  "bookName": "kacy.grady",
  "bookAuthor": "Walker Kerluke",
  "bookPublish": "qswu21",
  "bookCategory": 556,
  "bookPrize": 8.68,
  "bookIntroduction": "nyl2da"
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
  "code": 342,
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
curl -X DELETE -i /book/290
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
  "code": 651,
  "message": "success",
  "data": {}
}
```

## 修改书籍信息

**URL:** `/book`

**Type:** `PUT`


**Content-Type:** `application/json`

**Description:** 修改书籍信息（需要登录）




**Body-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|id|int32|true|书籍id|-|
|bookName|string|false|书籍名称|-|
|bookAuthor|string|false|书籍作者|-|
|bookPublish|string|false|书籍出版社|-|
|bookCategory|int32|false|书籍类别|-|
|bookPrize|double|false|书籍价格|-|
|bookIntroduction|string|false|书籍介绍|-|

**Request-example:**
```
curl -X PUT -H 'Content-Type: application/json' -i /book --data '{
  "id": 455,
  "bookName": "kacy.grady",
  "bookAuthor": "Walker Kerluke",
  "bookPublish": "ix4f2u",
  "bookCategory": 286,
  "bookPrize": 63.93,
  "bookIntroduction": "ooe70z"
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
  "code": 934,
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
curl -X GET -i /book/list?pageNum=708&pageSize=10 --data '&708&10'
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
  "code": 485,
  "message": "success",
  "data": [
    {
      "id": 927,
      "bookName": "kacy.grady",
      "bookAuthor": "Walker Kerluke",
      "bookPublish": "onvgp2",
      "state": "emeb4s"
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
curl -X GET -i /book/203
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
  "code": 977,
  "message": "success",
  "data": {
    "id": 908,
    "bookName": "kacy.grady",
    "bookAuthor": "Walker Kerluke",
    "bookPublish": "nsf5ht",
    "state": "bbp4m6"
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
curl -X GET -i /book?bookName=kacy.grady&pageNum=978&pageSize=10 --data '&kacy.grady&978&10'
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
  "code": 360,
  "message": "success",
  "data": [
    {
      "id": 45,
      "bookName": "kacy.grady",
      "bookAuthor": "Walker Kerluke",
      "bookPublish": "jx7yhi",
      "state": "vrhf1m"
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
curl -X GET -i /book/category?categoryName=kacy.grady&pageNum=272&pageSize=10 --data '&kacy.grady&272&10'
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
  "code": 601,
  "message": "success",
  "data": [
    {
      "id": 487,
      "bookName": "kacy.grady",
      "bookAuthor": "Walker Kerluke",
      "bookPublish": "iqtg74",
      "state": "zg13ak"
    }
  ]
}
```

