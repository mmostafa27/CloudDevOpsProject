variable "project_name" {
  description = "Project name prefix"
  type        = string
  default     = "ivolve"
}

variable "private_subnet_ids" {
  description = "Private subnet IDs for EKS cluster and worker nodes"
  type        = list(string)
}

variable "eks_version" {
  description = "Kubernetes version for EKS"
  type        = string
  default     = "1.29"
}

variable "node_instance_types" {
  description = "EC2 instance types for worker nodes"
  type        = list(string)
  default     = ["t3.medium"]
}
