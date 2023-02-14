
# 导入excel文件和下载excel文件
## 将excel转成数据库数据导入

**URL:** `/excel`

**Type:** `POST`


**Content-Type:** `multipart/form-data`

**Description:** 将excel转成数据库数据导入



**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|file|file|true|要上传的excel文件|-|


**Request-example:**
```
curl -X POST -H 'Content-Type: multipart/form-data' -F 'file=' -i /excel
```

**Response-example:**
```
Return void.
```

## 数据库信息转成excel保存到本地

**URL:** `/excel`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 数据库信息转成excel保存到本地





**Request-example:**
```
curl -X GET -i /excel
```

**Response-example:**
```
Return void.
```

