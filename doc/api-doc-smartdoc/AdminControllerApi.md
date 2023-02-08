
# 管理员管理
## 管理员注册

**URL:** `/admin/register`

**Type:** `POST`


**Content-Type:** `application/json`

**Description:** 管理员注册




**Body-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|id|int32|false|管理员id|-|
|adminName|string|true|管理员名|-|
|adminPassword|string|ture|管理员密码|-|
|adminEmail|string|true|管理员邮箱|-|

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json' -i /admin/register --data '{
  "id": 897,
  "adminName": "kacy.grady",
  "adminPassword": "7j565f",
  "adminEmail": "laurabeahan@yahoo.com"
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
  "code": 24,
  "message": "success",
  "data": {}
}
```

## 管理员登录

**URL:** `/admin/login`

**Type:** `GET`


**Content-Type:** `application/json`

**Description:** 管理员登录




**Body-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|id|int32|false|管理员id|-|
|adminName|string|true|管理员名|-|
|adminPassword|string|true|管理员密码|-|
|adminEmail|string|false|管理员邮箱|-|

**Request-example:**
```
curl -X GET -H 'Content-Type: application/json' -i /admin/login --data '{
  "id": 977,
  "adminName": "kacy.grady",
  "adminPassword": "eualcy",
  "adminEmail": "laura.beahan@yahoo.com"
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
  "code": 246,
  "message": "success",
  "data": {}
}
```

## 管理员退出登录

**URL:** `/admin/exit`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 管理员退出登录





**Request-example:**
```
curl -X GET -i /admin/exit
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
  "code": 255,
  "message": "success",
  "data": {}
}
```

## 查询所有管理员

**URL:** `/admin`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 查询所有管理员



**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|pageNum|int32|true|页码|-|
|pageSize|int32|true|显示条数|-|


**Request-example:**
```
curl -X GET -i /admin?pageNum=37&pageSize=10 --data '&37&10'
```

**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|code|int32|返回码|-|
|message|string|返回信息|-|
|data|array|返回数据|-|
|└─id|int32|管理员id|-|
|└─adminName|string|管理员名|-|
|└─adminPassword|string|管理员密码|-|
|└─adminEmail|string|管理员邮箱|-|

**Response-example:**
```
{
  "code": 58,
  "message": "success",
  "data": [
    {
      "id": 274,
      "adminName": "kacy.grady",
      "adminPassword": "sot3m0",
      "adminEmail": "laura.beahan@yahoo.com"
    }
  ]
}
```

## 修改管理员信息

**URL:** `/admin`

**Type:** `PUT`


**Content-Type:** `application/json`

**Description:** 修改管理员信息




**Body-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|id|int32|true|管理员id|-|
|adminName|string|false|管理员名|-|
|adminPassword|string|false|管理员密码|-|
|adminEmail|string|false|管理员邮箱|-|

**Request-example:**
```
curl -X PUT -H 'Content-Type: application/json' -i /admin --data '{
  "id": 139,
  "adminName": "kacy.grady",
  "adminPassword": "dhrz14",
  "adminEmail": "laura.beahan@yahoo.com"
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
  "code": 181,
  "message": "success",
  "data": {}
}
```

## 查询所有用户

**URL:** `/admin/user`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 查询所有用户



**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|pageNum|int32|true|页码|-|
|pageSize|int32|true|显示条数|-|


**Request-example:**
```
curl -X GET -i /admin/user?pageNum=838&pageSize=10 --data '&838&10'
```

**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|code|int32|返回码|-|
|message|string|返回信息|-|
|data|array|返回数据|-|
|└─id|int32|用户id|-|
|└─userName|string|用户名|-|
|└─userPassword|string|用户密码|-|
|└─userEmail|string|用户邮箱|-|

**Response-example:**
```
{
  "code": 513,
  "message": "success",
  "data": [
    {
      "id": 263,
      "userName": "kacy.grady",
      "userPassword": "wn4wp8",
      "userEmail": "laura.beahan@yahoo.com"
    }
  ]
}
```

## 根据id查询用户

**URL:** `/admin/user/{id}`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 根据id查询用户


**Path-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|id|int32|true|用户id|-|



**Request-example:**
```
curl -X GET -i /admin/user/566
```

**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|code|int32|返回码|-|
|message|string|返回信息|-|
|data|object|返回数据|-|
|└─id|int32|用户id|-|
|└─userName|string|用户名|-|
|└─userPassword|string|用户密码|-|
|└─userEmail|string|用户邮箱|-|

**Response-example:**
```
{
  "code": 402,
  "message": "success",
  "data": {
    "id": 287,
    "userName": "kacy.grady",
    "userPassword": "kk21j8",
    "userEmail": "laura.beahan@yahoo.com"
  }
}
```

## 添加用户

**URL:** `/admin/user`

**Type:** `POST`


**Content-Type:** `application/json`

**Description:** 添加用户




**Body-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|id|int32|false|用户id|-|
|userName|string|true|用户名|-|
|userPassword|string|true|用户密码|-|
|userEmail|string|true|用户邮箱|-|

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json' -i /admin/user --data '{
  "id": 694,
  "userName": "kacy.grady",
  "userPassword": "m55hsr",
  "userEmail": "laura.beahan@yahoo.com"
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
  "code": 249,
  "message": "success",
  "data": {}
}
```

