## HOW TO RUN DOCKER

`
docker compose -f docker-compose-dev.yaml --env-file env\.env.dev up -d --build
`

## HOW TO RUN K8S

1. Generate secret key

`
kubectl create secret generic service-common --from-env-file=env.dev
`

2. Copy env/.env.dev to k8s/.env.dev

`
cp env/.env.dev k8s/.env.dev
`

3. Run K8S

`
kubectl apply -k k8s/
`
