## Exploring Daemon Sets and Jobs

* Recap of Kubernetes Controllers
  * Replica Sets
  * Deployments
  * Stateful sets
  * Daemon Sets
  * Jobs (One time)
  * cron jobs
* Overview of Daemon Set 
  * Daemon set runs a copy of a pod on every node in a Kubernetes cluster
  * Daemon set and Replica Set are similar but have different use cases
  * New nodes automatically gets Daemon Set Pod
  * When a node is removed, the Daemon set pod will not be rescheduled
  * <i> Total number of pods in the Daemon Set == The number of nodes in cluster </i>
  * <i> Daemon set is set of pods (= to number of nodes) </i>
  * schedular no role to play in Daemon set
* User cases
  * Logging Aggregators
  * Monitoring
  * Load Balancers / Reverse Proxies / Api Gateways
  * Generic background job that needs to be run on each node

* Demo nginx-rs.yml
  ```
  apiVersion: extensions/v1beta1
  kind: ReplicaSet
  metadata:
    name: nginx
  spec:
    replicas: 3
    template:
      metadata:
        labels:
          app: nginx
      spec:
        containers:
          - name: nginx
            image: nginx:1.10.0
  ```
  ```
  kubectl create -f nginx-rs.yml
  kubectl get pods -o wide
  ```
* Daemon set nginx-ds.yml
  ```
  apiVersion: extensions/v1beta1
  kind: DaemonSet
  metadata:
    name: nginx
    labels:
      app: nginx
  spec:
    template:
      metadata:
        labels:
          app: nginx
      spec:
        containers:
          - name: nginx
            image: nginx:1.10.0
  ```
  ```
  kubectl create -f nginx-ds.yml
  kubectl get pods -o wide
  ```
* Daemon set also get schedule on master as well
  ```
  kubectl scale --replicas=10 ds/nginx -> error
  ```
  sematext -> Monitoring tool

* Jobs
  * There are two types of job controllers in Kubernetes
    * One Time / Run on Completion
    * Scheduled jobs
  * Both extremely useful in performing batch operatoins
  * Jobs complement other controllers like Replica Set and DaemonSet
  * Run to Completion Jobs
    * each job creates one or more pods and ensures that they are successfully terminated
    * if a pod or node fails during the execution, job controllers will restart or reschedules the pod
    * job can also be used to run multiple pods in parallel
    * A job can be scaled up suing the kubectl scale command
    * job's spec may define the parallelism value for running multiple pods in parallel.
  * Use case for jobs
    * One time initialization of resources
      * databases
      * file systems
      * cache
      * configuraition
  * multiple workers to process messages in a queue
  * Demo 
  * bring up mysql and feed data 
  * mysql.yml
```
apiVersion: v1
kind: Pod
metadata:
  name: mysql
  labels:
    app: myapp
    tier: data
spec:
  containers:
    - name: mysql
      image: mysql
      env:
        - name: MYSQL_ROOT_PASSWORD
          value: password
      ports:
      - containerPort: 3306
---
apiVersion: v1
kind: Service
metadata:
  name: mysql
  labels:
    app: myapp
    tier: data
spec:
  ports:
    - port: 3306
      name: mysql
      targetPort: 3306
      protocol: TCP
  selector:
    app: myapp
---
apiVersion: v1
kind: Service
metadata:
  name: mysql-external
  labels:
    app: myapp
    tier: data
spec:
  type: NodePort
  ports:
    - port: 3306
      name: mysql
      targetPort: 3306
      protocol: TCP
  selector:
    app: myapp
```
```
kubectl create -f mysql.yml
export NODEPORT=30495
mysql -u root -ppassword -h node1 -P $NODEPORT -e "show databases"
```
* job db-init-job.yml
```
  apiVersion: batch/v1
  kind: Job
  metadata:
    name: db-init
    labels:
      app: myapp
      tier: data
  spec:
    template:
      metadata:
        name: "db-init"
      spec:
        containers:
        - name: db-init
          image: janakiramm/db-init
          env:
            - name: USERNAME
              value: "root"
            - name: PASSWORD
              value: "password"
            - name: HOST
              value: mysql
              name: PORT
              value: "3306"
        restartPolicy: Never

```
* DOckerfile for janakiramm/db-init
```
  FROM mysql
  MAINTAINER janakiramm.com
  ADD db.sql /tmp
  RUN echo "DB import is initializing"
  ENTRYPOINT mysql -u $USERNAME -p$PASSWORD -h $HOST -P $PORT < /tmp/db.sql
```
* db.sql 
```
  kubectl create -f db-init-job.yml
  kubectl get pods
  kubectl logs db-init-8cf8
  mysql -u root -ppassword -h node1 -P $NODEPORT -e "show databases"
  kubectl describe job db-init
```
* Cron JObs
  * A cron job Manages time based jobs
    * Once at a specified point in time
    * repeatedly at specified point in time
  * Each Cron Job is similar to one line of crontab (cron table ) file
  * A typical use cases include
    * schedule a job execution at given point in Time
    * create periodic job
      * Database backup
      * sending emails

      <b> WOrks only on clusters with --runtime-config=batch/v2alpha1=true </b>
* Demo cron.yml

```
apiVersion: batch/v2alpha1
kind: CronJob
metadata:
  name: hello
spec:
  schedule: "*/1 * * * *"
  jobTemplate:
    spec:
      template:
        spec:
          containers:
          - name: hello
            image: busybox
            args:
            - /bin/sh
            - -c
            - date; ech Hello from the Kubernetes cluster
          restartPolicy: OnFailure
```
```
kubectl config 
kubectl create -f cron.yml

kubectl run hello \
   --schedule="*/1 * * * *" \
   --restart=OnFailure \
   --image=busybox \
   -- /bin/sh -C "date; echo Hello from the Kubernetes cluster"

kubectl get cronjob hello
kubectl get pods -a
kubectl logs hello-<xxx> pod name
kubectl get jobs --watch

```
