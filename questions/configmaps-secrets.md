## ConfigMaps & Secrets in Kubernetes - gothrough again
* What are ConfigMaps
* When to use ConfigMaps
* use cases of config map
* Overview of secrets
* Using secrets
* Key Takeaways

## Configuring Containerized Applications
 * Applications expect configuration from
   * configuration files
   * Command line arguments
   * Environment variables
 * Configuration is always decoupled from applications
   * INI
   * XML
   * JSON
   * Custom Format
* Container images shouldn't hold application configuration
   * Essential for keeping containerized application portable

* what are configMaps?
  * Kubernetes objects for injecting containers with configuration data
  * ConfigMaps keep Containers agostic of Kubernetes
  * They can be use to store fine-grained or corse grained COnfiguration
    * Individual properties
    * Entire Configuration File
    * Json files
  * configMaps hold configuration in key-value pair accessible to Pods
  * Similar to /etc directory and files in Linux OS

* Overview of ConfigMap
  * kind: ConfigMap
  * Accessing ConfigMaps from Pods
    * configuration data can be consume in pods in variety of ways
    * ConfigMap can be used to :
      *

* Demo
  * configMap.yaml
```
apiVersion: v1
kind: ConfigMap
metadata:
  name: log-config
  namespace: default
  data:
    log.lvel : INFO
    log.location: LOCAL
```
  * pod-cmd.yml
```
apiVersion: v1
kind: Pod
metadata:
name: test-pod-cmd
spec:
  containers:
    - name: test-container
      image: gcr.io/google_containers/busybox
      command: ["/bin/bash", "-c", "echo Error Level: $(LOG_LEVEL )"]- Error Location : $(LOG_LOCAION )
      env:
      - name: LOG_LEVEL
        valueFrom:
          configMapKeyRef:
            name: log-config
            key: log.level
      - name: LOG_LOCAION
        valueFrom:
          configMapKeyRef:
            name: log-config
            key: log.location
  restartPolicy: Never
```
```
kubectl cretate -f configmap.yml
kubectl create -f pod-cmd.yaml
kubectl logs pod-cmd
```
* from env

```
  apiVersion: v1
  kind: Pod
  metadata:
    name: test-pod-env
  spec:
    containers:
      - name: test-container
        image: gcr.io/google_containers/busybox
        command: ["/bin/bash", "-c", "--""]
        args: ["while true; do sleep 30; done;"]
        env:
          - name: LOG_LEVEL
            valueFrom:
              configMapKeyRef:
                name: log-config
                key: log.level
          - name: LOG_LOCAION
            valueFrom:
              configMapKeyRef:
                name: log-config
                key: log.location
  restartPolicy: Never
  ```
```
kubelct create -f pod-env.yml
kubectl exec -it test-pod-env
```
* from file system
```
  apiVersion: v1
  kind: Pod
  metadata:
    name: test-pod-vol
  spec:
    containers:
      - name: test-container
        image: gcr.io/google_containers/busybox
        command: ["/bin/bash", "-c", "--""]
        args: ["while true; do sleep 30; done;"]
        volumeMounts:
          - name: config-volume
            mountPath: /etc/config
    volumes:
      - name: config-volume
        configMap:
          name: log-config
  restartPolicy: Never
```
```
  * kubectl create -f pod-vol.yaml
  * kubectl exec -it test-pod-vol /bin/bash
```
* redis-config
```
  maxmemory 5mb
  maxmemory-policy allkeys-lru

```
```
kubectl create configMap example-redis-config --from-file=reis-config
kubectl get configMap
redis.yml (redis pod)
kubectl create -f redis.yml
kubectl exec -it redis redis-cli
```

* Secrets (before configMaps)
  * Secret is an Object that contains a small amount of sensitive data such as PASSWORD
  * Secret redue the risk of exposing sensitive data no unwanted entities
  * Like ConfigMaps, Secrets are kubernetes API Objects created outside of  POds
  * Secrets belong to specific kubernetes namespace
  * The Size of each secret cannot execed 1MB

  * Uses of screts
    * secrets are registered with Kubernetes Master
    * Secret can be mounted as Volumes or exposed as environment vaiables
    * Secret is only sent to the Node hosting the pod that requires access
    * Each secret is stored in tempfs volumes that restrict acess to the rest of the application s in the node
    * Communication btw the kubernetes api server and node is secured through SSL/TLS
* demo
```
  * username.txt 'admin'
  * passwrod.txt 'secret'
  * kubectl create secret generic dbsecret --from-file=./username.txt --from-file=./password.txt
  * kubectl get scret
  * kubectl get secret -o yaml
  * echo '111' | base64 -D
```
* secret-pod.yml
  
  ```
    apiVersion: v1
    kind: Pod
    metadata:
      name: secret-pod
    spec:
      containers:
        - name: redis
          image: redis
          volumeMounts:
            - name: foo
              mountPath: "/etc/foo"
              readOnly: true
      volumes:
        - name: foo
          secret:
            secretName: dbsecret
  ```
