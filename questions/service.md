## What is a Kubernetes Service  
* A Service is an abstract of logical set of Pods defined by a policy
* It acts as the intermediary for pods to talk to each other
* selectors are used for accessing all the pods that match a specific label
* Service is an object in kubernetes - similar to pods and RCs
* Each Service exposes one or more ports and targetPorts
* The targetPort is mapped to the port exposed by matching pods
* Kubernetes services support TCP and UDP protocols

```
S1 - Red - pod - red
S2 - Green pod -green
S3 - Yellow pod - yellow
S4 - Blue pod - pod 
```
* color app Node js app

```
var express = require('express');
var app = express();

var port = process.env.PORT || 8080;
var color = process.env.COLOR;
var router = express.Router();

router.get('/', function(req,res){
  res.json({'color': color});
});

app.use('/', router);
app.listen(port);
console.log('Server Started at '+port);
```
* Dockerfile
```
FROM node
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY ./app/ ./
RUN npm install
CMD ["node", "app.js"]
```
* color-pod.yml
```
apiVersion: v1
kind: Pod
metadata:
  name: red
  labels:
    color: red
spec:
  containers:
    - image: janakiram/color
      name: red
      env:
        - name: "COLOR"
          value: "red"
      ports:
        - containerPort: 8080
```
* color-rc.yml
```
apiVersion: v1
kind: ReplicationController
metadata:
  name: red
spec:
  replicas: 3
  template:
    metadata:
      labels:
        color: red
    spec:
      containers:
        - image: janakiram/color
          name: red
          env:
            - name: "COLOR"
              value: "red"
          ports:
            - containerPort: 8080
```
* color-svc.yml
```
apiVersion: v1
kind: Service
metadata:
  name: red
spec:
  selector:
    color: red
  type: NodePort
  ports:
    - name: http
      NodePort: 31001
      port: 80
      targetPort: 8080
      protocol: TCP
```
* execute following commands
```
kubectl create -f color-pod.yml
kubectl create -f color-rc.yml
kubectl create -f color-svc.yml
kubectl get pods
kubectl get svc
kubectl describe svc red
curl node1: 31002
kubectl apply -f color-svc.yml

```
* Discovering Services - Env Vars
  * Kubernetes creates Docker Link compatible envirnment varaiables in all pods
  * Containers can use the envirnment variable to talk to the service endpoint
* Discovering Services - DNS
  * THe DNS Server watches Kubernetes api for new services
  * The Dns Server creates a set of DNS records for each service
  * Services can be resolved by the name within the same namespace
  * Pods in other namespace can access the Service by Adding the namespcae to the dns path
    * myservice.my-namespace

* Service Types
  * Cluster IP
  * NodePort
  * LoadBalaner

* Second demo (nodejs app talks to mongodb)
  * db-pod.yml
```

apiVersion: v1
kind: Pod
metadata:
  name: db
  labels:
    name: mongo
    app: todoapp
spec:
  containers:
    - image: mongo
      name: mongo
      ports:
        - name: mongo
          containerPort: 27017
          hostPort: 27017
      volumeMounts:
        - name: mongo-storage
          mountPath: /data/db
      volumes:
        - name: mongo-storage
          hostPath:
            path: /data/db
```
  * db-svc.yml
```
  apiVersion: v1
  kind: Service
  metadata:
    name: db
    labels:
      name: mongo
      app: todoapp
  spec:
    selector:
      name: mongo
    type: ClusterIP
    ports:
      - name: db
        port: 27017
        targetPort: 27017
```
  * web-pod.yml
```
apiVersion: v1
kind: Pod
metadata:
  name: web
  labels:
    name: web
    app: todoapp
spec:
  containers:
    - image: janakiram/todo-app
      name: myweb
      ports:
        - containerPort: 3000
```
   * web-service.yml
```
apiVersion: v1
kind: Service
metadata:
  name: web
  labels:
    name: web
    app: todoapp
spec:
  selector:
    name: web
  type: NodePort
  ports:
    - name: http
      port: 80
      targetPort: 3000
      protocol: TCP
```
   * web-rc.yml
```
apiVersion: v1
kind: ReplicationController
metadata:
  name: web
  labels:
    name: web
    app: todoapp
spec:
  replicas: 2
  template:
    metadata:
      labels:
        name: web
    spec:
      containers:
        - name: web
          image: janakiramm/todo-app
          ports:
           - containerPort: 3000
```
* execute following commands
```
kubectl create -f db-pod.yml
kubectl create -f db-svc.yml
kubectl create - web-rc.yml
kubectl create -f web-svc.yml
```
