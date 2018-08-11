

## start Scaling And Managing Deployments

* Overview of ReplicaSets
  * Replica Sets are the next generation of Replication Controllers
  * Replica Sets support set-based selectors
  * Replication Controller only supports equality-based selectors
  * Deployments in Kubernetes use Replica Sets
  * Example of set-based selectors in Replica Set

  ```
    selector:
      matchLabels:
        component: redis
      matchExpressions:
        - {key: tier, operator: In, values: [cache]}
        - {key: environment, operator: NotIn, values: [dev]}
  ```
* WHat are Deployments
  * Deployment provides declarative updates for Pods and Replica Sets
  * Deployment defines the state of the application
    * Kubernetes ensures that the cluster maintains the desired state of application
  * Replication Controllers and Replica Sets fall short of key requirements to manage application Deployments
  * Deployment Object is flexible for managing and scaling applications in Kubernetes.  
* why use Deployments
  * Create Deployment
  * Deploy an application
    * Update Deployment
  * Deply new version of application
    * Perform rolling updates
  * zero downtime during upgrades
    * Perform rollback
  * undo the last deployment
    * Pause/REsume a deployment
  * selective upgrades


* Use Cases
  * create a Deployment to bring up a replica set and pods
  * Check status of a Deployment to see if it succeds or not 
  * Later, update that Deployment to recreate the Pods
  * Rollaback to an earlier Deployment revision if the current Deployment isn't stable
  * Pause and resume a Deployment
  
* Demo 1
```
   open http://127.0.0.1:8001/static
   kubectl proxy --www=local/ &
   kubectl run update-demo --image=gcr.io/google_containers/update-demo:nautilus --port=80 -l name=update-demo 
   kubectl scale deployment/update-demo --replicas=4
   kubectl edit deployment/update-demo
   kubectl rollout undo deployment/update-demo
```
* Demo2 j-hello.yml
```
apiVersion: extensions/v1beta1
kind: Deployment
metadata:
  name: j-hello
spec:
  replicas: 3
  template:
    metadata:
      labels:
        app: helloworld
    spec:
      containers:
      - name: j-hello
        image: janakiramm/j-hello
        ports:
        - name: nodejs-port
          containerPort: 3000
```
*  j-hello-svc.yml
```
apiVersion: v1
kind: Service
metadata:
  name: j-hello
  labels:
    app: helloworld
spec:
  selector:
    app: helloworld
  type: NodePort
  ports:
    - port: 80
      name: http
      targetPort: 3000
      nodePort: 30001
      protocol: TCP
```
* Execute following things
```
kubectl create -f j-hello.yml -f j-hello-svc.yml
kubectl get pods
kubectl get svc
kubectl get deployments
kubectl describe deployments
kubectl get pods --show-labels
kubectl get rs --show-labels
kubectl describe svc j-hello
export NODE_PORT=30001
curl node1:$NODE_PORT
kubectl scale deployment j-hello --replicas 10
curl node1:$NODE_PORT
kubectl set image deployment j-hello j-hello=janakiramm/j-hello:2
curl node1:$NODE_PORT
kubectl rollout history deployment j-hello
kubectl rollout undo deploy/j-hello
curl node1:$NODE_PORT
kubectl get deployments
kubectl delete deployment j-hello
kubectl create -f j-hello.yml -f j-hello-svc.yml
curl node1:$NODE_PORT
kubectl scale deployment j-hello --replicas 10
kubectl set image deployment j-hello j-hello=jankiramm/j-hello:2
kubectl rollout pause deploy/j-hello
kubectl rollout status deploy/j-hello
for loop
  curl node1:$NODE_PORT
kubectl rollout resume deploy/j-hello
for loop
  curl node1:$NODE_PORT
```
