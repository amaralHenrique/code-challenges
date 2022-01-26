# code-challenges

Dear Jose and Jumnia Team,

In order to run the project, you should sync the git repo in your machine. Open it with STS and run. It is configured to populate the H2 database with the sample data you have provided. If necessary, you can add or remove records using \src\main\resources\data.sql.

Once the service is up, you should be able to perform requests using Postman, Insomnia or another request tool you might like. It responds in localhost, port 8001.
I am writing below some CURL examples so you can use to guide your validations.

The application reads the entries from the database, categorizes the country, validate the rightness of the numbers and filters according to the incoming request parameters. As an extra, it paginates the results, so you can input the page you want and how many items per page. Also it is available to select if you prefer ascending or descending sorting.


CURL examples:

-1
curl --request POST \
  --url http://localhost:8001/customers/retrieve/list \
  --header 'Content-Type: application/json' \
  --data '{
	"filterByCountryName": ["CAMEROON", "ETHIOPIA", "MOZAMBIQUE"],

	"pageSize": 10,
	"pageNumber": 1
}'

-2
curl --request POST \
  --url http://localhost:8001/customers/retrieve/list \
  --header 'Content-Type: application/json' \
  --data '{
	"filterByCountryName": ["UNKNOWN"],
	"pageSize": 14,
	"pageNumber": 1,
  "orderDirection": "DESC"
}'

Filter Values Avaliable:

List<String> filterByCountryName;

    CAMEROON
    ETHIOPIA
    MOROCCO
    MOZAMBIQUE 
    UGANDA
    UNKNOWN

String filterByState;
  
  VALID
  INVALID
	
String orderDirection;
	
  ASC
  DESC
  
Integer pageSize;
  1 - N
	
Integer pageNumber;
  1 - N
