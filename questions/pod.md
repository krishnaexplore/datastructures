## Every about POD
* What is pod
  * Group of one more containers that always co-located, co-Scheduled, and run in shared context
  * containers in a pod share same ip address, ports, hostname, and storage
  * Modeled like a virtual machine
    * Each container represents one process
    * Tightly coupled with other containers in the same pod
    * Pods are Scheduled in Nodes
    * fundamental unit of deployment in Kubernetes
   * Demo creating first Pod
   * my-pod.yml
   * Pods are Scheduled in Nodes
   * fundamental unit of deployment in Kubernetes
   * Demo creating first Pod
   * my-pod.yml
     ```
     apiVersion: "v1"
     kind: Pod
     metadata: 
       name: mypod
       labels:
         app: demo
         env: test
     spec:
       containers:
         - name: nginx
           image: nginx
           ports:
             - name: http
               containerPort: 80
               protocol: TCP
     ```
     ```
     kubectl create -f mypod.yml
     kubectl get pods
     kubectl describe pod mypod
     kubectl expose pod mypod --type=NodePort
     kubectl get svc
     kubectl get nodes
     curl minikube-ip:port -> nginx output
     ```
  * What is pod 
    * containers within the same pod communicate with each other using IPC
    * Containers can find each other via localhost
    * Each container inherits the name of the pod
    * Each pod has an IP Address in a flat shared networking space 
    * volume shared by contaienrs in a pod
* Use cases for pod
    * content managment systems, file and data loaders, locacl cache managers, etc
    * Log and checkpoint backup, compression, rotation, snapshotting, etc.
    * Data change watchers, log tailers, logging and monitoring adapters, event publishers, etc.
    * Proxies, bridges, and adapters
    * Controllers, managers, configurators, and updaters
    ```
    {
      "kind": "Pod",
      "apiVersion": "v1",
      "metadata": {
        "name": "redis-django",
        "labels": {
          "app": "webapp"
        }
      },
      "spec": {
        "containers": [
          {
            "name": "key-value-store",
            "image": "redis",
            "ports": [
              {
                "containersPort": 6379
              }
            ]
          },
          {
            "name": "frontend",
            "image": "django",
            "ports": [
              {
                "containersPort": 8000
              }
            ]
          }
        ]
      }
    }
    ``` 
   * Python container -> Redis Container
   * mysql container
   * Demo : https://github.com/janakiramm/Kubernetes-multi-container-pod
* Replication Controller
  * Ensures that a Pod or homogeneous set of pods are always up and available
  * always maintains desired number of Pods
    * if there are excess pods, they get killed
    * new pods are launched when they fail, get deleted, or terminated
  * creating a replication controller with a count of 1 ensures that a Pod is always available
  * Replication controller and pods are associated through labels
* Replica Set
  * Replica Sets are the next generation replication controllers
  *  Ensures specified number of pods are alway running
  * Pods are replaced by replica sets when a failure occurs
    * new POds are automatically scheduled
  * Labels and Selectors are used for associating pods with Replica sets
  * Usually combined with pods when defining the deployment
  * Annotations are next generation for labels and selectors
