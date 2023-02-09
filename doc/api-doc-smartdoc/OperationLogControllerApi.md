
# 操作日志管理
## 查询所有日志

**URL:** `/log`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 查询所有日志



**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|pageNum|int32|true| 页码|-|
|pageSize|int32|true|显示条数|-|


**Request-example:**
```
curl -X GET -i /log?pageNum=808&pageSize=10 --data '&808&10'
```

**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|code|int32|返回码|-|
|message|string|返回信息|-|
|data|array|返回数据|-|
|└─id|int32|日志id|-|
|└─username|string|操作者的用户名|-|
|└─description|string|操作描述|-|
|└─className|string|操作类名|-|
|└─methodName|string|操作方法名|-|
|└─uri|string|操作路径|-|
|└─params|string|请求参数|-|
|└─createDate|string|日志创建日期|-|

**Response-example:**
```
{
  "code": 165,
  "message": "success",
  "data": [
    {
      "id": 481,
      "username": "verla.kiehn",
      "description": "pldtsj",
      "className": "verla.kiehn",
      "methodName": "verla.kiehn",
      "uri": "bpz3pt",
      "params": "nr9q0t",
      "createDate": "2023-02-09"
    }
  ]
}
```

## 根据id集合删除日志

**URL:** `/log`

**Type:** `DELETE`


**Content-Type:** `application/json`

**Description:** 根据id集合删除日志




**Body-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|ids|array|true|所要删除的日志id集合,[array of int32]|-|

**Request-example:**
```
curl -X DELETE -H 'Content-Type: application/json' -i /log --data '[
  658
]'
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
  "code": 812,
  "message": "success",
  "data": {}
}
```

## 查询开始时间与截止时间查询日志

**URL:** `/log/time`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 查询开始时间与截止时间查询日志



**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|beginTime|string|true|开始时间|-|
|endTime|string|true|  截止时间|-|
|pageNum|int32|true|  页码|-|
|pageSize|int32|true| 显示条数|-|


**Request-example:**
```
curl -X GET -i /log/time?beginTime=2023-02-09 23:57:20&endTime=2023-02-09 23:57:20&pageNum=688&pageSize=10 --data '&2023-02-09 23:57:20&2023-02-09 23:57:20&688&10'
```

**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|code|int32|返回码|-|
|message|string|返回信息|-|
|data|array|返回数据|-|
|└─id|int32|日志id|-|
|└─username|string|操作者的用户名|-|
|└─description|string|操作描述|-|
|└─className|string|操作类名|-|
|└─methodName|string|操作方法名|-|
|└─uri|string|操作路径|-|
|└─params|string|请求参数|-|
|└─createDate|string|日志创建日期|-|

**Response-example:**
```
{
  "code": 785,
  "message": "success",
  "data": [
    {
      "id": 706,
      "username": "verla.kiehn",
      "description": "6ee8f4",
      "className": "verla.kiehn",
      "methodName": "verla.kiehn",
      "uri": "bxrmhm",
      "params": "b4m9bk",
      "createDate": "2023-02-09"
    }
  ]
}
```

