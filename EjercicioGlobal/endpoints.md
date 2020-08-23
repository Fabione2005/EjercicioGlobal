# Endpoints


## login

- **Method**: `GET`
- **Path**: `/userAuth`

#### Request body

```json
{
    "userEmail":"userEmail",
    "password":"password"
}
```

```json
#### Valid response sample

{
    "userEmail": "userEmail",
    "password": null,
    "token": "token"
}
```

## Error Responses

- Status:  `400` | `401` | `500` | `415`

````json
{
    "message": "detailed error"
}
```


## addUser

- **Method**: `POST`
- **Path**: `/users/add`
- **Headers**: Require authorization bearer with user token.

#### Request body

```json
{
	"name": "name",
	"email": "email",
	"password": "password",
	"phones": [
			{
				"number":  "number",
				"citycode": "citycode",
				"countrycode": "countrycode"
			},
						{
				"number":  "number",
				"citycode": "citycode",
				"countrycode": "countrycode"
			}
		]
}
```

#### Valid response sample

- Status: `201`

```json

    {
        "id": "id",
        "name": "name",
        "email": "email",
        "password": "password",
        "phones": [
            {
                "id": "id",
                "number": "number",
                "cityCode": "cityCode",
                "countryCode": "countryCode"
            }
        ],
        "token": "token",
        "created": "created",
        "modified": "2020-08-20T00:00:00",
        "last_login": "2020-08-20T00:00:00",
        "active": true
    }

```
## Error Responses

- Status: `400` | `409` | `500` | `415`

````json
{
    "message": "detailed error"
}
```
## retrieveUsers

- **Method**: `GET`
- **Path**: `/users`
- **Headers**: Require authorization bearer with user token.

#### Valid response sample

- Status: `200`

```json
[
   {
        "id": "id",
        "name": "name",
        "email": "email",
        "password": "password",
        "phones": [
            {
                "id": "id",
                "number": "number",
                "cityCode": "cityCode",
                "countryCode": "countryCode"
            }
        ],
        "token": "token",
        "created": "created",
        "modified": "2020-08-20T00:00:00",
        "last_login": "2020-08-20T00:00:00",
        "active": true
    },
    {
        "id": "id",
        "name": "name",
        "email": "email",
        "password": "password",
        "phones": [
            {
                "id": "id",
                "number": "number",
                "cityCode": "cityCode",
                "countryCode": "countryCode"
            }
        ],
        "token": "token",
        "created": "created",
        "modified": "2020-08-20T00:00:00",
        "last_login": "2020-08-20T00:00:00",
        "active": true
    }
]
```

## Error Responses

- Status: `500`

````json
{
    "message": "detailed error"
}
`````

## updateUser

- **Method**: `PUT`
- **Path**: `/users/update`
- **Headers**: Require authorization bearer with user token.

#### Request body

```json
{
	"id": "id",
	"name": "name",
	"email": "email",
	"password": "password",
	"phones": [
			{
				"number":  "number",
				"citycode": "citycode",
				"countrycode": "countrycode"
			},
						{
				"number":  "number",
				"citycode": "citycode",
				"countrycode": "countrycode"
			}
		]
}
```

#### Valid response sample

- Status: `200`

```json

    {
    "message": "info message"
	 }

```
## Error Responses

- Status: `400` | `409` | `500` | `415` | `404` 

````json
{
    "message": "detailed error"
}
```

## deleteUser

- **Method**: `DELETE`
- **Path**: `/users/delete/{id}`
- **Headers**: Require authorization bearer with user token.

#### Valid response sample

- Status: `200`

```json

    {
    "message": "info message"
	 }

```
## Error Responses

- Status: `500` | `404` 

````json
{
    "message": "detailed error"
}
```

