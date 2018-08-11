##  Deploying StatefulSets in Kubernetes

* Containers are designed to be stateless
* Containers use ephemeral storage
* Pods can be made stateful through volumes
* Running Databases cloud be challenge
  * Lack of stable namving convention
  * Lack of stable persistent storage per pod

## Introducing StatefulSets

* Bringing the concept of ReplicaSets to stateful pods
* Enables running Pods in a "cluster mode"
* Ideal for deploying highly available database workloads
* Valuable for applications that need
  * Stable, unique network identifiers
  * Stable, persistent storage
  * Ordered, graceful deployment and scalling
  * Ordered, graceful deletion and termination.
* Currentl in beta - not available in versions < 1.5

## Key Concepts
* Depend on a Headless service for pod to pod communication
* Each pod gets a DNS name accessible to other Pods in the sets
* Leverage Persistent Volumes and Persistent Volume Claims
* Each Pod is suffixed with predictable, consistent ordinal defaultIndex
  * mysql-01, mysql-02
* Pods are created sequentially
  * ideal for setting up master / slave configuration
* The identity is consistent regardless of the node it is scheduled on
* Pods are terminated in LiFo Order

## Demo
* NFS storage backed
* persistent volumes and Claims
* 3 instances of etcd cluster with node affinity
* 3 instances of percona xtraDB cluster
* 5 instances of WordPress with Horizontal Pod Autoscaling
* https://thenewstack.io/deploy-highly-available-wordpress-instance-statefulset-kubernetes-1-5/
```
kubectl get nodes
kubectl version
ssh into kube master
cat /etc/exports
/opt/data/content
/opt/data/vol
vagrant status

kubectl create -f volumes.yml
kubectl get pv
```
```
apiVersion: v1
kind: Service
metadata:
  name: etcd
  spec:
    ports:
      - name: etcd-2379
        port: 2379
        protocol: TCP
        targetPort: 2379
      - name: etcd-4001
        port: 4001
        protocol: TCP
        targetPort: 4001
      - name: etcd-7001
        port: 7001
        protocol: TCP
        targetPort: 7001
    selector:
      app: etcd
  ```
  ```
  apiVersion: v1
  kind: Service
  metadata:
    name: etcd-client
  spec:
    type: NodePort
    ports:
      - port: 2379
        name: client
        protocol: TCP
        targetPort: 30001
        nodePort: 30001
      selector:
        app: etcd
  ```
* https://github.com/janakiramm/wp-statefulset
```
kubectl create -f etcd.yml
kubectl get pods
kubectl get svc
kubectl create -f mysql.yml
kubectl get pods
kubectl logs mysql-0
while true; do mysql -h 10.245.1.3 -P 30002 -u root -pk8spassword - Nbe 'select @@wasrep_node-address' 2>/dev/null; sleep 1; done

kubectl create -f wordpress.yml
```
