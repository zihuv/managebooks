
# 书籍类别管理
## 添加书籍类别

**URL:** `/category`

**Type:** `POST`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 添加书籍类别



**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|bookCategory|string|true|书籍类别名称|-|


**Request-example:**
```
curl -X POST -i /category --data 'bookCategory=fzzhyw'
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
  "code": 171,
  "message": "success",
  "data": {}
}
```

## 删除书籍类别

**URL:** `/category/{id}`

**Type:** `DELETE`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 删除书籍类别


**Path-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|id|int32|true|书籍类别的id|-|



**Request-example:**
```
curl -X DELETE -i /category/460
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
  "code": 655,
  "message": "success",
  "data": {}
}
```

## 查询所有书籍类别

**URL:** `/category/list`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 查询所有书籍类别



**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|pageNum|int32|true|页码|-|
|pageSize|int32|true|显示条数|-|


**Request-example:**
```
curl -X GET -i /category/list?pageNum=419&pageSize=10 --data '&419&10'
```

**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|code|int32|返回码|-|
|message|string|返回信息|-|
|data|array|返回数据|-|
|└─id|int32|书籍类别id|-|
|└─categoryName|string|书籍类别名称|-|

**Response-example:**
```
{
  "code": 717,
  "message": "success",
  "data": [
    {
      "id": 383,
      "categoryName": "jim.kub"
    }
  ]
}
```

## 查询所有类别有多少本书

**URL:** `/category`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 查询所有类别有多少本书



**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|pageNum|int32|true|页码|-|
|pageSize|int32|true|显示条数|-|


**Request-example:**
```
curl -X GET -i /category?pageNum=307&pageSize=10 --data '&307&10'
```

**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|code|int32|返回码|-|
|message|string|返回信息|-|
|data|array|返回数据|-|
|└─id|int32|书籍类别id|-|
|└─categoryName|string|书籍类别名称|-|
|└─amount|int32|该书籍的数量|-|

**Response-example:**
```
{
  "code": 471,
  "message": "success",
  "data": [
    {
      "id": 64,
      "categoryName": "jim.kub",
      "amount": 20
    }
  ]
}
```

