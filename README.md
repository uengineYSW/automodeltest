# 

## Model
www.msaez.io/#/112850933/storming/automodel-test0205

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- VehicleOperation
- DispatchManagement
- Maintenance
- ExpenseManagement
- Dashboard


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- VehicleOperation
```
 http :8088/operationRecords operationId="operationId"Driver := '{"driverId": driverId, "name": name, "phoneNumber": phoneNumber}'Vehicle := '{"vehicleId": vehicleId, "licensePlate": licensePlate, "vehicleType": vehicleType}'travelDistance="travelDistance"travelDate="travelDate"departure="departure"destination="destination"
```
- DispatchManagement
```
 http :8088/assignmentRequests requestId="requestId"User := '{"userId": userId, "name": name, "email": email, "phoneNumber": phoneNumber}'VehicleType = "SEDAN"requestDate="requestDate"RequestStatus = "PENDING"
```
- Maintenance
```
 http :8088/maintenanceRecords recordId="recordId"carId="carId"MaintenanceDetail := '{"maintenanceItem": maintenanceItem, "details": details}'maintenanceDate="maintenanceDate"MaintenanceStatus = "PENDING"OperationRecordId := '{"operationId": operationId}'
 http :8088/vehicles vehicleId="vehicleId"CarDetail := '{"carModel": carModel, "ownerName": ownerName}'licensePlate="licensePlate"ownerName="ownerName"
```
- ExpenseManagement
```
 http :8088/expenses expenseId="expenseId"ExpenseType = "FUEL"Money := '{"amount": 0, "currency": currency}'date="date"description="description"VehicleId := '{"vehicleId": vehicleId, "licensePlate": licensePlate, "ownerName": ownerName}'
```
- Dashboard
```
 http :8088/operationSummaries summaryId="summaryId"SummaryMetrics := '{"totalOperations": 0, "totalDistance": 0, "averageDistance": 0, "money": undefined}'
 http :8088/dashboardMetrics id="id"OperationSummaryId := '{"summaryId": 0}'
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```
