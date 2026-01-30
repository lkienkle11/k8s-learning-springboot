## HOW TO RUN DOCKER

`
docker compose -f docker-compose-dev.yaml --env-file env\.env.dev up -d --build
`

## HOW TO RUN K8S

1. Generate secret key

`
kubectl create secret generic service-common --from-env-file=env.dev
`

2. Run k8s
