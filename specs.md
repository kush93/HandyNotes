# OVERVIEW

The Reference API allows you to easily access a list of supported Countries, States, TimeZones and Currencies.

# Base URL

https://reference.azure.net/v1

# RESOURCES

## Country

```json
[
    {
        "Id": 1,
        "Code": "CA",
        "Name": "Canada",
        "Version": 1,
        "States": [
            {
                "Name": "Alberta",
                "Code": "AB"
            },
            ...
        ]
    }
]
```

| Name | Description |
|:-----|:------------|
| Id (`Integer`) | Identifier | 
| Code (`String`) | Country Code. Uses the ISO 3166-1 alpha-2 standard | 
| Name (`String`) | Country name | 
| Version (`Integer`) | Latest version number | 
| States (Array[<a href='/api/reference/#state'>State</a>]) | States/Provinces | 

## State

```json
{
    "Name": "Alberta",
    "Code": "AB"
}
```

| Name | Description |
|:-----|:------------|
| Name (`String`) | Country name | 
| Code (`String`) | State/Province Code. Based off the ISO 3166-2 standard | 

## TimeZone

```json
[
    {
        "Id": "Alaskan Standard Time",
        "Name": "(UTC-09:00) Alaska",
        "SupportsDaylightSavingTime": true
    }
]
```

| Name | Description |
|:-----|:------------|
| Id (`String`) | Identifier | 
| Name (`String`) | Name | 
| SupportsDaylightSavingTime (`Boolean`) | A flag to indicate if this TimeZone observes Daylight Savings Time | 

## Currency

To represent a Currency symbol in unicode, use the format <code>&#(Code);</code>, for USD this would be <code>&#36;</code> which is displayed as &#36; 

```json
[
    {
        "Id": 106,
        "Name": "United States Dollar",
        "Code": "USD",
        "Symbol": [
            36
        ],
        "Version": 1
    }
]
```

| Name | Description |
|:-----|:------------|
| Id (`Integer`) | Identifier | 
| Name (`String`) | Currency Name | 
| Code (`String`) | Identifier for the Currency | 
| Symbol (`Array[integer]`) | Unicode decimal value for symbols associated with this currency | 
| Version (`Integer`) | Latest version number | 

# REQUESTS

## GET All Countries

### Request

```
GET /Countries
```

### Example Request

```javascript
GET /Countries
Accept: application/json
```

### Response Parameters

### Example Response

```
HTTP 200 Content-Type: application/json
```

```json
[
    {
        "Id": 1,
        "Code": "CA",
        "Name": "Canada",
        "Version": 1,
        "States": [
            {
                "Name": "Alberta",
                "Code": "AB"
            }
        ]
    }
]
```

Array[[Country](#country)]

## GET All Time Zones

### Request

```
GET /TimeZones
```

### Example Request

```javascript
GET /TimeZones
Accept: application/json
```

### Response Parameters

### Example Response

```
HTTP 200 Content-Type: application/json
```

```json
[
    {
        "Id": "Alaskan Standard Time",
        "Name": "(UTC-09:00) Alaska",
        "SupportsDaylightSavingTime": true
    }
]
```

Array[[TimeZone](#timezone)]

## GET All Currencies

Currency resources are returned in ascending alphabetical order by Code.

### Request

```
GET /Currencies
```

### Example Request

```javascript
GET /Currencies
Accept: application/json
```

### Response Parameters

### Example Response

```
HTTP 200 Content-Type: application/json
```

```json
[
    {
        "Id": 106,
        "Name": "United States Dollar",
        "Code": "USD",
        "Symbol": [
            36
        ],
        "Version": 1
    }
]
```

Array[[Currency](#currency)]