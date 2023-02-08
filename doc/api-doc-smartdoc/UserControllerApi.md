
# 用户管理
## 用户注册

**URL:** `/user/register`

**Type:** `POST`


**Content-Type:** `application/json`

**Description:** 用户注册




**Body-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|id|int32|false|用户id|-|
|userName|string| true     |用户名|-|
|userPassword|string|true|用户密码|-|
|userEmail|string|true|用户邮箱|-|

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json' -i /user/register --data '{
  "id": 135,
  "userName": "kacy.grady",
  "userPassword": "imk2nm",
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
  "code": 100,
  "message": "success",
  "data": {}
}
```

## 用户登录

**URL:** `/user/login`

**Type:** `GET`


**Content-Type:** `application/json`

**Description:** 用户登录




**Body-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|id|int32|false|用户id|-|
|userName|string|true|用户名|-|
|userPassword|string|true|用户密码|-|
|userEmail|string|false|用户邮箱|-|

**Request-example:**
```
curl -X GET -H 'Content-Type: application/json' -i /user/login --data '{
  "id": 952,
  "userName": "kacy.grady",
  "userPassword": "mmmo8l",
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
  "code": 827,
  "message": "success",
  "data": {}
}
```

## 用户退出登录

**URL:** `/user/exit`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 用户退出登录





**Request-example:**
```
curl -X GET -i /user/exit
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
  "code": 559,
  "message": "success",
  "data": {}
}
```

## 修改用户信息

**URL:** `/user`

**Type:** `PUT`


**Content-Type:** `application/json`

**Description:** 修改用户信息




**Body-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|id|int32|true|用户id|-|
|userName|string|false|用户名|-|
|userPassword|string|false|用户密码|-|
|userEmail|string|false|用户邮箱|-|

**Request-example:**
```
curl -X PUT -H 'Content-Type: application/json' -i /user --data '{
  "id": 297,
  "userName": "kacy.grady",
  "userPassword": "d24dwd",
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
  "code": 222,
  "message": "success",
  "data": {}
}
```

