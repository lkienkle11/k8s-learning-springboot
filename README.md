# Project Setup & Usage Guide

## 1. Prerequisites
Before running the project, you need to set up the environment variables.

* Create the `.env.dev` file using the example provided:
    ```bash
    # Copy the example env file to create your development env file
    cp env/.env.example env/.env.dev
    ```

## 2. How to Run with Docker
Execute the following command to build and start the services in detached mode:

```bash
docker compose -f docker-compose-dev.yaml --env-file env/.env.dev up -d --build

```

## 3. How to Run with Kubernetes (K8S)

*Ensure that your Kubernetes cluster is running and `kubectl` is configured correctly.*

1. **Generate Secret Key:**
   Create a generic secret using the environment file created in the Prerequisites step.
```bash
kubectl create secret generic service-common --from-env-file=env/.env.dev

```

2. **Copy env/.env.dev to k8s/.env.dev**

```bash
cp env/.env.dev k8s/.env.dev

```

3. **Deploy Resources:**
   Apply the configuration using Kustomize:
```bash
kubectl apply -k k8s/

```



## 4. API Testing / Verification

You can test the endpoints using `curl` or Postman.

### A. Get Books (Directly via Book Service)

* **Running on Docker (Localhost):**
```bash
curl http://localhost:8002/api/v1/books/

```


* **Running on Kubernetes:**
  *(Replace `<your_ip_in_k8s>` with your actual Node IP)*
```bash
curl http://<your_ip_in_k8s>:30003/api/v1/books/

```



### B. Get Books (Via User Service)

* **Running on Docker (Localhost):**
```bash
curl http://localhost:8000/api/v1/users-books/

```


* **Running on Kubernetes:**
```bash
curl http://<your_ip_in_k8s>:30001/api/v1/users-books/

```


