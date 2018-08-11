## session 12 Ingress
* Recap of Service in Kubernetes
  * ClusterIP
    * Service is reacable only from inside of the Cluster
  * NodePort
    * Service is reachable through <NODEIP>:<NODEPORT>
  * LoadBalancer
    * Service is reachable through an external load balancer mapped to <NodeiP>:<Nodeport>

* Overview of Ingress
  * An Ingress is a collection of rules that allow inbound
  * Configured to expose services through
    * external URLS
    * Load Balancers
    * SSL- terminated endpoints
    * Name-based virtual hosting

* Demo in GKE
    ```
     kubectl run nginx --image=nginx --port=80
     kubectl get deployments
     kubectl get svc
     kubectl expose deployment nginx --target-port=80 --type=NodePort
     kubectl get svc
     ```
* nginx-Ingress.yml
```
      apiVersion: extensions/v1beta1
      kind: Ingress
      metadata:
        name: nginx-ingress
      spec:
        backend:
          serviceName: nginx
          servicePort: 80
```
```
     kubectl get svc 
     out: kubernetes  10.59.240.1 <none> 443/TCP 41m
          ngix        10.59.254.253 <nodes> 80:31117/TCP 2m
```
```
kubectl create -f ngix-ingress.yml
open GKE -> LoadBalancer
kubectl get ing
out ngix-ingress 
kubectl describe ing ngix-ingress
acess ip of ingress
kubectl get pods
kubectl get svc
kubectl get ing
create static ip
tie with ingress
```
```
apiVersion: extensions/v1beta1
kind: Ingress
metadata:
  name: nginx-ingress
  annotations:
    kubernetes.io/ingress.global-static-ip-name: ngix-static-ip
spec:
  backend:
    serviceName: nginx
    servicePort: 80
```

* create another web pod tie with ingress
  * echoserver
  * nginx
  * called fanout ingress

```
apiVersion: extensions/v1beta1
kind: Ingress
metadata:
  name: fanout-ingress
spec:
  rules:
  - http:
      paths:
      - path: /
        backend:
          serviceName: nginx
          servicePort: 80
      - path: /echo
        backend:
          serviceName: echoserver
          servicePort: 8080
```

* google for gke kubernetes ingress to get tutorial on ingress

* Ingress in Kubernetes

* Special type of controller deployed within the cluster 
* A daemon, deployed as Kubernetes Pod, that watches the apiserver's /ingresses endpoint for updates to the ingress resource

* Fundamentally different from other controllers
