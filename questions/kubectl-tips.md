## session 11 kubectl tips
```
kubectl get nodes
kubectl get pods
kubectl get svc
kubectl get pods -o wide (which pod with node)
kubectl scale --replicas=5 rs/web
kubectl cordon 172.17.4.201 (disable node)
kubectl scale --replicas=10 rs/web
no new pods not scheduling on 201
kubectl uncordon 172.17.4.201
kubectl get pods
node draining
kubectl drain 172.17.4.201 --force
kubectl uncordon 172.17.4.201
kubectl get pods --watch-only
kubectl scale --replicas=10 rs/web
kubectl scale --replicas=5 rs/web
kubectl delete -f web-rs.yml
kubectl create -f web-pod.yml
kubectl get svc
kubectl port-forward web 3000:3000
copy files host to pod
kubectl exec -it web /bin/sh
pwd
ls
kubectl cp ./test.html web:/usr/src/app/public/test.html
kubectl get po
kubectl get svc
kubectl explain
reverse engineering
kubectl get pod web -o=yml
kubectl get pod web -o=json
kubectl get pods web -o jsonpath={.spec.containers[*].name}
kubectl get services --sort-by=.metadata.name
kubectl get pod -o wide | awk {'print' $1" " $7} | colomn -t
kubectl edit pod/web
KUBE_EDITOR="sublime" kubectl edit pod/web
kubectl proxy --port=8000
open http://localhost:8000/ui
curl http://localhost:8000/api
curl -s http://localhost:8000/api/v1/nodes | jq '.items[].metadata.labels'
kubectl api-versions
kubectl get pods
curl -s http://localhost:8000/api/v1/namespaces/default/pods -XPOST -H 'Content-Type: application/json' -d@nginx-pod.json | jq '.status'
curl -s http://localhost:8000/api/v1/namespaces/default/services -XPOST -H 'Content-Type: application/json' -d@nginx-service.json | jq '.status'
curl -s http://localhost:8000/api/v1/namespaces/default/services/nginx-service -XDELETE
curl -s http://localhost:8000/api/v1/namespaces/default/pods/nginx-pod -XDELETE
```
