# Task API

This Spring Boot application provides three core functionalities:
1. Calculates the number of days between two dates
2. Converts numbers into grammatically correct Lithuanian words
3. Retrieves temperature statistics in Vilnius for a given date range

## API Endpoints

### 1. 
**Endpoint**: `POST /api/numberOfDays`
Calculates and returns the number of days between two provided dates.

Constraints:
Dates must be between 0000-01-01 and 9999-12-31
Dates must be in YYYY-MM-DD format

**Request Body**:
```json
{
    "dateOne": "YYYY-MM-DD",
    "dateTwo": "YYYY-MM-DD"
}
```
Response:
Returns the number of days between the two dates.

### 2. 
**Endpoint**: `POST /api/numberToWords`
Endpoint: POST /api/numberToWords
Converts a positive number less than one billion into grammatically correct Lithuanian text.

Constraints:
Accepts numbers from 1 to 999999999

**Request Body**:
```json
{
    "dateOne": "YYYY-MM-DD",
    "dateTwo": "YYYY-MM-DD"
}
```
Response:
Returns the number as a Lithuanian phrase.

### 3. 
**Endpoint**: `POST /api/temperatureStatsForVilnius`
Endpoint: POST /api/numberToWords
Returns temperature statistics (average, minimum, and maximum) for Vilnius between two specified dates. Also converts each of these numbers into grammatically correct Lithuanian text.

Constraints:
Dates must be in YYYY-MM-DD format

**Request Body**:
```json
{
    "dateOne": "YYYY-MM-DD",
    "dateTwo": "YYYY-MM-DD"
}
```
**Response**:
```json
{
   "averageTemperature": "double",
    "minTemperature": "double",
    "maxTemperature": "double",
    "lithuanianTextAverageTemperature": "string",
    "lithuanianTextMinTemperature": "string",
    "lithuanianTextMaxTemperature": "string"
}
```

Constraints:
Dates must be in YYYY-MM-DD format.

dateOne and dateTwo must be between 1940-01-02 and yesterday.

dateOne cannot be after dateTwo.

Dates can be the same.

If only yesterday's date is requested, averageTemperature will be returned as null due to limitations in the external API.


## External API

This endpoint uses the Open-Meteo Historical Weather API:
https://open-meteo.com/en/docs/historical-weather-api

API Notes:
Provides historical weather data from 1940 up to the current day, though updates may be delayed by a couple of days.

Rate Limit (Free Tier): 10,000 requests per day.

Large date ranges count as multiple API calls:

Example: A request from 1940-01-02 to 2025-05-26 is equivalent to 668 API calls.

For this reason, the application performs strict date validation before sending any request to the external API to avoid exceeding rate limits.


### Installation
Docker must be installed on your system

1. Clone the repository
```
  git clone https://github.com/PanuprasB/DateWordAndTemperatureStatsApi.git
```
2. Navigate to the project directory
```
cd DateWordAndTemperatureStatsApi/TaskApi
```
3. Build the Docker image
```
 docker-compose build
```
3. Run the application
```
docker-compose up
```
API will be accessible at http://localhost:8080
