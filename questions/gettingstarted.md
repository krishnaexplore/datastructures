## Getting started

* Kuberetes Architecture
  * Master Components
  * Node Components
  * Pods
  * Labels & Selectors
  * Replication Controllers
  * Services

  * Master Components
    * API
    * UI
    * CLI 
    * API Server
    * Scheduler
    * Controller
    * etcd - key/value - db - coreOs - Single Store truth
    [Image of master component image here]()
    * Declarative defination / YAML/yml
    
  * Kubernetes Node Components
    * Kube-proxy - network configuration in cluster - distributed network
    * Docker - container
    * kubelet agent- talking to master through api
    * Supervisord - docer + kubelet
    * FluentD - logging - central mechanism
    * Pods
    * Hetrogeonous pods
    * Addons -> DNS/optional
    * [image of kubernetes component]()
 * Pod 
   * fundamental unit of deployment
   * Group of one more containers that always co-locatedco-Scheduled, and run in shared context
   * containers in same pod have the same hostname
   * each pod is isolated by
     * process id
     * network namespace
     * interprocess comminication IPC namespace
     * unix time sharing (UTS) namespace
     * Alternative to a VM with multiple processes
     [deploying pod image] ()
 * Labels & Selectors
  * key/value pairs associated with kubernetes objects
  * used to organize and select subsets of objects
  * Attached to objects at creation time but modified at anytime
  * Labels are the essential glue to associate one api object with other
    * Replication Controller -> Pods
    * Service -> Pods
    * Pods -> Nodes
  * Services
    * An abstraction to define a logical set of Pods bound by a policy by to access them
    * Services are exposed through internal and external endpoints
    * Services can also point to non-kubernetes endpoints through a Virtual-ip-brigde
    * Supports TCP and UDP
    * intefaces with kube-proxy to manipulate iptables
    * service can be exposed internal or external to the cluster
    * [Exposing service image]()
  * Replication Controller
    * Ensures that a Pod or homogeneous set of pods are always up and available
    * always maintains desired number of Pods
      * if there are excess pods, they get killed
      * new pods are launched when they fail, get deleted, or terminated
    * Creating a replication Controller with a count of 1 ensures that a pod is alway available
    * Replication Controller and pods are associated through labels

   * Demo : https://github.com/janakiramm/kubernetes-101
     ```
     kubectl get nodes
     kubectl cluster-info
     kubectl get cs
     ```
   * Redis container as POD db-pod.yml
   * db-svc.yml
   * web POD
   * web-svc.yml
     ```
     kubectl create -f db-pod.yml
     kubectl create -f db-svc.yml
     kubectl create -f web-pod.yml
     kubectl exec -it web /bin/bash
     env
     ping redis
     curl localhost:5000
     kubectl create -f web-svc.yml
     NodePort -> REserved b/w 31000 and 4000
     kubectl get nodes
     minikube ip
     curl <ip>:32163 from (web-svc.yml)
     kubectl describe pod web
     web-rc.yml
     kubectl create -f web-rc.yml
     kubectl get rc
     kubectl get pods
     kubectl delete pod
     kubectl get pods
     kubectl scale rc web --replicas=10
     kubectl get pods
     kubectl delete rc web : deteles replication controller and underlaying pods
    ```
