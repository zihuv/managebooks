
# 操作日志管理
## 查询所有日志

**URL:** `/log`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 查询所有日志



**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|pageNum|int32|true|页码|-|
|pageSize|int32|true|显示条数|-|


**Request-example:**
```
curl -X GET -i /log?pageNum=799&pageSize=10 --data '&799&10'
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
  "code": 447,
  "message": "success",
  "data": {}
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
  201
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
  "code": 742,
  "message": "success",
  "data": {}
}
```

