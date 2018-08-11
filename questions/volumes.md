
## Volumes

* Pods are ephemeral and stateless
* Volume bring persistence to pods
* Kubernetes volumes are similar to Docker volumes, but managed differently
* All containers in pod can access the volume
* Volumes are associated with lifecycle of Pod
* Directories in the host are exposed as volumes
* Volumes may be based on variety of storage backends
* Types of VOlumes
  * Host-Based
    * EmptyDir
    * HostPath
  * Block Storage
    * Aws ebs
    * GCE Persistent Disk
    * AZure Disk
    * vSphere Volume
  * Distribute File System
    * NFS
    * Ceph
    * Gluster
    * aws EFS
    * Azure file system
  * Other
    * Flocker
    * iScsi
    * Git Repo
    * Quobyte

```
apiVersion: "v1"
kind: Pod
metadata:
  name: nginx
  labels:
    env: dev
spec:
  containers:
  - name: nginx
     image: nginx
     ports:
      - containerPort: 80
        name: http
        protocol: TCP
    volumeMounts:
      - mountPath: /usr/share/ngix/html
        name: my-vol
  volumes:
    - name: my-vol
      hostPath:
        path: /var/lib/my-data
```
```
kubectl create -f Pod-Vol-local.yml
kubect get pods
kubectl describe pod Pod-Vol-local    -- scheduled on - node3
kubectl exec -it nigix /bin/bash
ls
```
```
apiVersion: "v1"
kind: Pod
metadata:
  name: nginx
  labels:
    env: dev
spec:
  containers:
   - name: nginx
     image: nginx
     ports:
      - containerPort: 80
        name: http
        protocol: TCP
    volumeMounts:
      - mountPath: /usr/share/ngix/html
        name: my-vol

  volumes:
    - name: my-vol
      gcePersistentDisk:
        pdName: my-data-Disk
        fsType: ext4
```

* PersistenVolume
  * Networked storage in the cluster pre-provisioned by an administrator
* PersistentVolumeClaim
  * Storage resource requested by a user
* StoageClass
  * Types of supported storage profiles offered by administrators  
* Provisioning and Claiming NFS-based Volumes
  * my-pv.yml as admin
```
kind: PersistentVolume
apiVersion: v1
metadata:
  name: my-pv
  labels:
    type: local
spec:
  capacity:
    storage: 1Gi
  accessModes:
    - ReadWriteOnce
  persistentVolumeReclaimPolicy: Recycle
  nfs:
    path: /opt/data/web
    server: 10.245.1.2
```
  
* my-pvc.yml as developer

```
kind: PersistentVolumeClaim
apiVersion: v1
metadata:
 name: my-pvc
spec:
  accessModes:
    - ReadWriteOnce
  resources:
    requests:
      storage: 1Gi
```
* my-pod.yml

```
kind: Pod
apiVersion: v1
metadata:
  name: my-pod
  labels:
    name: web
spec:
 containers:
   - name: web
     image: nginx
     ports:
       - containerPorts: 80
         name: "http-server"
     volumeMounts:
       - mountPath: "/usr/share/nginx/html"
         name: mypd
  volumes:
    - name: mypd
      persistentVolumeClaim:
        claimName: my-pvc
```
```
kubectl create -f my-pv.yml
kubectl get pv
kubectl create -f my-pvc.yml
kubectl get pvc
kubectl get pv
kubectl create -f my-pod.yml
kubectl get pods
kubectl describe pod my-pod
kubectl exec -it my-pod /bin/bash
```
